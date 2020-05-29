package com.codecool.videoservice.Repository;

import com.codecool.videoservice.Model.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    @Override
    Optional<Video> findById(Long aLong);
}
