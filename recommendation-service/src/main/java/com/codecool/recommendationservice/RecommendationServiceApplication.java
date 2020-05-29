package com.codecool.recommendationservice;

import com.codecool.recommendationservice.Model.Recommendation;
import com.codecool.recommendationservice.Repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
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
@EnableEurekaClient
public class RecommendationServiceApplication {

    @Autowired
    RecommendationRepository recommendationRepository;

    public static void main(String[] args) {
        SpringApplication.run(RecommendationServiceApplication.class, args);
    }
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/**"))
                .build();
    }

    @PostConstruct
    public void createRecommendation(){
        Recommendation recom1 = Recommendation.builder()
                .comment("He covered React in <1.5 hours in a free video which other instructors on their paid courses take around 5 hours to explain.")
                .rating(5)
                .videoId(1L)
                .build();
        Recommendation recom2 = Recommendation.builder()
                .comment("The ability to setup environment variables alone makes it worth over Firbase. Continuous integration is amazing, too.")
                .rating(4)
                .videoId(2L)
                .build();
        Recommendation recom3 = Recommendation.builder()
                .comment("You should really give azure a shot, great documentation and it’s very intuitive")
                .rating(3)
                .videoId(3L)
                .build();
        Recommendation recom4 = Recommendation.builder()
                .comment("You are today's Bucky Roberts. Keep it up. Your project-based approach is a model that makes you stand out. Blessings.")
                .rating(5)
                .videoId(4L)
                .build();
        Recommendation recom5 = Recommendation.builder()
                .comment("Really useful tutorial, bro! Keep up the good work.")
                .rating(5)
                .videoId(4L)
                .build();
        List<Recommendation> recommendationList = Arrays.asList(recom1,recom2,recom3,recom4,recom5);
        recommendationRepository.saveAll(recommendationList);


    }
}
