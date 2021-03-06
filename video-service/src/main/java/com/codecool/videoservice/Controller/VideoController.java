package com.codecool.videoservice.Controller;

import com.codecool.videoservice.Model.AllVideoData;
import com.codecool.videoservice.Model.RecommendationResult;
import com.codecool.videoservice.Model.Video;
import com.codecool.videoservice.Repository.VideoRepository;
import com.codecool.videoservice.Service.RecommendationCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/videos")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
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
    public AllVideoData getVideoById(@PathVariable Long videoId){
        RecommendationResult[] recommendation = recommendationCaller.getRecommendation("/" + videoId);
        Video video = videoRepository.findById(videoId).get();
        return AllVideoData.builder()
                .id(video.getId())
                .name(video.getName())
                .url(video.getUrl())
                .recommendations(Arrays.asList(recommendation))
                .build();
    }

    @PutMapping("/{videoId}")
    public void updateVideoData(@PathVariable Long videoId,@RequestBody AllVideoData requestData){
        Video video = videoRepository.getOne(videoId);
        video.setName(requestData.getName());
        video.setUrl(requestData.getUrl());
        videoRepository.save(video);
        recommendationCaller.updateRecommendation(requestData.getRecommendations());
    }

    @PostMapping("/add")
    public void addRecommendation(@RequestBody RecommendationResult recommendation){
        recommendationCaller.updateRecommendation(Collections.singletonList(recommendation));
    }
}
