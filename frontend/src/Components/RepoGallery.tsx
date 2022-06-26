import {Repo} from "../gitBookService/model";

export interface UserRepoProps{
    userRepo:Repo[]
}

export default function RepoGallery(props:UserRepoProps) {

    return(
<div>
    <div>{props.userRepo.map(r => <div>{r.name}</div>)}</div>
</div>
    )
}