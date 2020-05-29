package com.codecool.videoservice.Service;

import com.codecool.videoservice.Model.RecommendationResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Service
@Slf4j
public class RecommendationCaller {

    @Autowired
    RestTemplate restTemplate;

    @Value("${recommendationservice.url}")
    public String baseUrl;

    public RecommendationResult[] getRecommendation(String route) {
        ResponseEntity<RecommendationResult[]> response =
                restTemplate.getForEntity(
                        baseUrl + route,
                        RecommendationResult[].class);
        return response.getBody();
    }

    public void updateRecommendation(List<RecommendationResult> updatedRecommendations) {
        String url = baseUrl + "/update";


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        for (RecommendationResult updatedInstance : updatedRecommendations) {

            HttpEntity<RecommendationResult> entity = new HttpEntity<>(updatedInstance, headers);
            this.restTemplate.exchange(url, HttpMethod.PUT, entity, RecommendationResult.class);
        }


    }
}
