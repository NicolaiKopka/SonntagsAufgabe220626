package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class GitBookService {

    RestTemplate restTemplate = new RestTemplate();

    private final GitBookRepository gitBookRepository;

    public GitHubRepo[] getAllRepos(String user) {
        String api_url = "https://api.github.com/users/" + user + "/repos";
//        RestTemplate restTemplate = new RestTemplate();
        var response = restTemplate.getForEntity(api_url, GitHubRepo[].class);
        return response.getBody();

    }


    public FavoriteDataFromFrontend saveFavoriteRepo(FavoriteDataFromFrontend data) {
        String apiUrl = "https://api.github.com/repos/" + data.getUserName() + "/" + data.getRepoName();
//        RestTemplate restTemplate = new RestTemplate();
        var response = restTemplate.getForObject(apiUrl, GitHubRepo.class);
        if(response == null) {
            throw new RuntimeException("wrong username or repo name");
        }
        gitBookRepository.save(response);
        return data;
    }
}

