package com.example.demo;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class GitHubRepo {

    @Id
    private String id;
    private String name;
    private Owner owner;

}
