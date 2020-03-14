package com.example.restDemo.externalService;

public interface ChuckNorrisJoke {
    String getRandomJoke() throws Exception;
    String getRandomJokeByCategory(String category);
}
