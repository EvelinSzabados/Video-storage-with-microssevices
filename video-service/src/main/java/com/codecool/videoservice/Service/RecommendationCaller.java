package com.codecool.videoservice.Service;

import com.codecool.videoservice.Model.RecommendationResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;


@Service
@Slf4j
public class RecommendationCaller {

    @Autowired
    RestTemplate restTemplate;

    @Value("${recommendationservice.url}")
    public String baseUrl;

    public RecommendationResult[] getRecommendation(String route){
        ResponseEntity<RecommendationResult[]> response =
                restTemplate.getForEntity(
                        baseUrl+route,
                        RecommendationResult[].class);
        return response.getBody();
    }

}
