import {FormEvent, useState} from "react";
import {getUserRepos} from "../gitBookService/GitBookServiceApi";
import {Repo} from "../gitBookService/model";
import RepoGallery from "./RepoGallery";
import {useNavigate} from "react-router-dom";


export default function RepoSearchpage (){

    const [username, setUsername] = useState<string>("")
    const [userRepos, setUserRepos] = useState<Repo[]>([])
    const nav = useNavigate()

    const handleUsernameChange = (name: string) => {
        setUsername(name)
        console.log(name);
    }

    const handleSubmit = (event: FormEvent) => {
        event.preventDefault();
        getUserRepos(username)
            .then(data => setUserRepos(data))
    }

    return(
        <div>
            <div>
                <form onSubmit={handleSubmit}>
                    <input type = "text" placeholder={"github username"} value={username} onChange={event => handleUsernameChange(event.target.value)}/>
                    <input type = "submit" value="Search"/>
                    <div><RepoGallery userRepo={userRepos}/></div>
                </form>
            </div>
            <div>
                <button onClick = {() => nav('/') } >back</button>
            </div>

        </div>

    )

}