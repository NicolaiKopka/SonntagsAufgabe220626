package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class GitBookServiceTest {

    @Test

    void shouldsaveRepoInDB(){
      GitBookRepository gitBookRepository  = Mockito.mock(GitBookRepository.class);
      GitBookService testService = new GitBookService(gitBookRepository);
      FavoriteDataFromFrontend data = new FavoriteDataFromFrontend("testUser", "testRepoName");
      testService.saveFavoriteRepo(data);
      Mockito.verify()
    }
}