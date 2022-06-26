package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class FavoriteDataFromFrontend {

    private String userName;
    private String repoName;
}
