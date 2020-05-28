package com.codecool.videoservice;

import com.codecool.videoservice.Model.Video;
import com.codecool.videoservice.Repository.VideoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
@Slf4j
@EnableEurekaClient
public class VideoServiceApplication {

    @Autowired
    VideoRepository videoRepository;

    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/**"))
                .build();
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){return new RestTemplate();}

    @PostConstruct

    public void createVideos() {

        Video video1 = Video.builder()
                .name("React JS Crash Course")
                .url("https://www.youtube.com/watch?v=sBws8MSXN7A&t=1572s").build();
        Video video2 = Video.builder()
                .name("Deploy Websites In Seconds With Netlify")
                .url("https://www.youtube.com/watch?v=bjVUqvcCnxM")
                .build();
        Video video3 = Video.builder()
                .name("Serverless Lambda Functions")
                .url("https://www.youtube.com/watch?v=drJwMlD9Mjo")
                .build();
        Video video4 = Video.builder()
                .name("GraphQL With React & Apollo [1] - Express GraphQL Server")
                .url("https://www.youtube.com/watch?v=SEMTj8w04Z8")
                .build();
        List<Video> videos = Arrays.asList(video1, video2, video3, video4);
        videoRepository.saveAll(videos);
        log.info("Sample videos created");

    }
}

