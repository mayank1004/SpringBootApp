package com.example.restDemo.externalService;

import com.example.restDemo.externalService.WSObject.CheckNorrisJokeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestOperations;


public class BaseOutboundService<T> {

    public <T> T executeOutboundCall(OutboundService<T> service) throws Exception {
        System.out.printf("Starting to make outbound call");
        try {
            T response = service.outBoundCall();
            System.out.printf("Completed outbound call");
            return response;
        } catch (Exception e){
            throw new Exception(e);
        }
    }
}
