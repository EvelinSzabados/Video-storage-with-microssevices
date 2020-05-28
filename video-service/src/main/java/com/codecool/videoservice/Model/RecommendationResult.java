package com.codecool.videoservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecommendationResult {
    private Long id;
    private String comment;
    private int rating;
    private Long videoId;
}
