package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "savedRepos")
@Data
public class GitHubRepo {

//    @Id
    private String id;
    private String name;
    private Owner owner;

}
