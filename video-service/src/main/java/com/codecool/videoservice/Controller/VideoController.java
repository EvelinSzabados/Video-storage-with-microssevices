package com.codecool.videoservice.Controller;

import com.codecool.videoservice.Model.Video;
import com.codecool.videoservice.Repository.VideoRepository;
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

    @GetMapping("/all")
    public List<Video> getAllVideos(){
        return videoRepository.findAll();
    }
}
