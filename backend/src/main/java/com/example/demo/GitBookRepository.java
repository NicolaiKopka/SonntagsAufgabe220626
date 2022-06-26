package com.example.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GitBookRepository extends MongoRepository<GitHubRepo, Integer> {
}
