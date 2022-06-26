import {useNavigate} from "react-router-dom";
import {FormEvent, useState} from "react";

export default function MainPage(){

    const [username, setUsername] = useState<string>(localStorage.getItem("username")??"")
    const [savedName, setSavedName] = useState<string>(localStorage.getItem("username")??"")
    const nav = useNavigate()

    const handleUsernameChange = (name: string) => {
        setUsername(name)
    }

    const handleSubmit = (event: FormEvent) => {
        event.preventDefault();
        localStorage.setItem("username", username);
        setSavedName(username);
    }

    return(
        <div>
            <div>
                <form onSubmit={handleSubmit}>
                    <input type = "text" placeholder={"your github username" } value={username} onChange={event => handleUsernameChange(event.target.value)}/>
                    <input type = "submit" value="Set your username" />
                </form>
                <p>Username: {savedName}</p>
            </div>
            <button onClick={() => nav("/search" )}>search for user</button>
            <button onClick={() => nav(`/myrepos/${savedName}` )}>go to own repos</button>
        </div>
    )
}