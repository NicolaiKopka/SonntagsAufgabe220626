package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("/api")
@RestController
@RequiredArgsConstructor
public class GitBookController {

    private final GitBookService gitBookService;

    @GetMapping("/githubrepos/{user}")
    public GitHubRepo[] getAllReposFromGitHub(@PathVariable String user){
        return gitBookService.getAllRepos(user);
    }
}
