import {useNavigate} from "react-router-dom";
import {FormEvent, useState} from "react";
import Button from '@mui/material/Button';
import {styled, TextField} from "@mui/material";
import SendIcon from '@mui/icons-material/Send'

const MyButton = styled(Button)({
    color: "gold",
    background: "hotpink",
    variant: "contained",
})

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
                    <TextField id="outlined-basic" label="Username" variant="outlined" />
                    <input type = "text" placeholder={"your github username" } value={username} onChange={event => handleUsernameChange(event.target.value)}/>
                    <input type = "submit" value="Set your username" />
                </form>
                <p>Username: {savedName}</p>
            </div>
            <Button variant="contained" size="large" endIcon={<SendIcon />} sx={{background: "hotpink"}} onClick={() => nav("/search" )}>search for user</Button>
            <MyButton onClick={() => nav(`/myrepos/${savedName}` )}>go to own repos</MyButton>
        </div>
    )
}