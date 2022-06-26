package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class GitBookService {

    // private final GitBookRepository gitBookRepository;

    public GitHubRepo[] getAllRepos(String user) {
        String api_url = "https://api.github.com/users/" + user + "/repos";
        RestTemplate restTemplate = new RestTemplate();
        var response = restTemplate.getForEntity(api_url, GitHubRepo[].class);
        return response.getBody();

    }



}
