package com.codecool.videoservice.Controller;

import com.codecool.videoservice.Model.RecommendationResult;
import com.codecool.videoservice.Model.Video;
import com.codecool.videoservice.Repository.VideoRepository;
import com.codecool.videoservice.Service.RecommendationCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/{videoId}")
    public Map<String,Object> getVideoById(@PathVariable Long videoId){
        RecommendationResult recommendation = recommendationCaller.getRecommendation("/" + videoId);
        Video video = videoRepository.findById(videoId).get();
        Map<String,Object> response = new HashMap<>();
        response.put("Video",video);
        response.put("Recommendation",recommendation);
        return response;
    }
}
