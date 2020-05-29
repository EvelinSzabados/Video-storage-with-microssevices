package com.codecool.recommendationservice.Controller;

import com.codecool.recommendationservice.Model.Recommendation;
import com.codecool.recommendationservice.Repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    @Autowired
    RecommendationRepository recommendationRepository;

    @GetMapping("/all")
    public List<Recommendation> getAllRecommendations(){
        return recommendationRepository.findAll();
    }

    @GetMapping("/{videoId}")
    public List<Recommendation> getByVideoId(@PathVariable Long videoId){
        return recommendationRepository.findAllByVideoId(videoId);
    }
    @PutMapping("/update")
    public void updateRecommendationById(@RequestBody Recommendation recommendation){
        recommendationRepository.save(recommendation);
    }
}
