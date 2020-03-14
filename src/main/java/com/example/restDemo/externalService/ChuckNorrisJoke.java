package com.example.restDemo.externalService;

import com.example.restDemo.appException.domain.OutboundException;

public interface ChuckNorrisJoke {
    String getRandomJoke() throws OutboundException;
    String getRandomJokeByCategory(String category);
}
