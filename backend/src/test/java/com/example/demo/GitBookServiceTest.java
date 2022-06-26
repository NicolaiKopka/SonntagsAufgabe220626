package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class GitBookServiceTest {

    @Test

    void shouldsaveRepoInDB(){
      GitBookRepository gitBookRepository  = Mockito.mock(GitBookRepository.class);
      GitBookService testService = new GitBookService(gitBookRepository);
      FavoriteDataFromFrontend favoriteDataFromFrontend = new FavoriteDataFromFrontend("clarakraus", "partyparty");
      Owner owner = new Owner(92689668,"clarakraus");
      GitHubRepo data = new GitHubRepo("493174370","partyparty",owner);
      testService.saveFavoriteRepo(favoriteDataFromFrontend);
      Mockito.verify(gitBookRepository).save(data);
    }
}