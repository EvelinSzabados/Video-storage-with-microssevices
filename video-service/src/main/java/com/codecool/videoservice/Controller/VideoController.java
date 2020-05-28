package com.codecool.videoservice.Controller;

import com.codecool.videoservice.Model.RecommendationResult;
import com.codecool.videoservice.Model.Video;
import com.codecool.videoservice.Repository.VideoRepository;
import com.codecool.videoservice.Service.RecommendationCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideoController {

    @Autowired
    VideoRepository videoRepository;
    @Autowired
    RecommendationCaller recommendationCaller;

    @GetMapping("/all")
    public List<Video> getAllVideos(){
        return videoRepository.findAll();
    }

    @GetMapping("/recommendations")
    public RecommendationResult getRecommendations(){return recommendationCaller.getRecommendation("/all");}
}
