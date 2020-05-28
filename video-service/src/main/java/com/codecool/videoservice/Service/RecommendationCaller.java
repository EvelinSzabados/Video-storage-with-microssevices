package com.codecool.videoservice.Service;

import com.codecool.videoservice.Model.RecommendationResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class RecommendationCaller {

    @Autowired
    RestTemplate restTemplate;

    @Value("${recommendationservice.url}")
    public String baseUrl;

    public RecommendationResult getRecommendation(String route){
        return restTemplate.getForEntity(baseUrl + route, RecommendationResult.class).getBody();
    }
}
