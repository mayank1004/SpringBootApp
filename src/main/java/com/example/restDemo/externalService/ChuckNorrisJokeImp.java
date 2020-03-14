package com.example.restDemo.externalService;

import com.example.restDemo.appException.domain.OutboundException;
import com.example.restDemo.externalService.WSObject.ChuckNorrisJokeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

@Service
public class ChuckNorrisJokeImp implements ChuckNorrisJoke {

    private RestOperations restTemplate;

    @Autowired
    public void setRestTemplate(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String BASE_URL = "https://api.chucknorris.io";


    @Override
    public String getRandomJoke() throws OutboundException {
        try{
            BaseOutboundService<ChuckNorrisJokeResponse> baseOutboundService = new BaseOutboundService<>();
            ChuckNorrisJokeResponse response = baseOutboundService.executeOutboundCall(() -> restTemplate.getForObject(BASE_URL+"/jokes/random", ChuckNorrisJokeResponse.class));
            return response.getValue();
        } catch (Exception e){
            throw new OutboundException(e.getMessage(), "need to imp","-","-");
        }
    }

    @Override
    public String getRandomJokeByCategory(String category) {
        return null;
    }
}
