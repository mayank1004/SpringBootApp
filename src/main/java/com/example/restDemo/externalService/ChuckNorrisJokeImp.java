package com.example.restDemo.externalService;

import com.example.restDemo.externalService.WSObject.CheckNorrisJokeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Service
public class ChuckNorrisJokeImp implements ChuckNorrisJoke {

    private RestOperations restTemplate;

    @Autowired
    public void setRestTemplate(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String BASE_URL = "https://api.chucknorris.io";


    @Override
    public String getRandomJoke() throws Exception {
        try{
            BaseOutboundService<CheckNorrisJokeResponse> baseOutboundService = new BaseOutboundService<>();
            CheckNorrisJokeResponse response = baseOutboundService.executeOutboundCall(() -> restTemplate.getForObject(BASE_URL+"/jokes/random", CheckNorrisJokeResponse.class));
            return response.getValue();
        } catch (Exception e){
            throw new Exception("external api failed");
        }
    }

    @Override
    public String getRandomJokeByCategory(String category) {
        return null;
    }
}
