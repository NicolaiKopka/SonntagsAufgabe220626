package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/githubrepos")
    public ResponseEntity<FavoriteDataFromFrontend> saveDBEntry(@RequestBody FavoriteDataFromFrontend data) {
        try {
            return ResponseEntity.ok(gitBookService.saveFavoriteRepo(data));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }


}
