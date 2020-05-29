package com.codecool.videoservice.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AllVideoData {
    private Long id;
    private String name;
    private String url;
    private List<RecommendationResult> recommendations;
}
