import {useEffect, useState} from "react";
import {Repo} from "../gitBookService/model";
import {useNavigate, useParams} from "react-router-dom";
import {getUserRepos} from "../gitBookService/GitBookServiceApi";
import RepoGallery from "./RepoGallery";

export  default function OwnRepos (){
    const [userRepos, setUserRepos] = useState<Repo[]>([]);
    const nav = useNavigate();
    const params = useParams();

    useEffect(()=>{
        getUserRepos(params.savedname!)
            .then(data => setUserRepos(data))
    }, [])

    return(
        <div>
            <div>
                {
                    userRepos &&
                    <RepoGallery userRepo={userRepos}/>
                }
            </div>
            <div>
                <button onClick = {() => nav('/')  }  >back</button>
            </div>

        </div>

    )
}