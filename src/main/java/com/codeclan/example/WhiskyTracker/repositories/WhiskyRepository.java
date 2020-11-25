package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskysByYear(int year);

    List<Whisky> findWhiskysByDistilleryNameAndAge(String name, int age);

    List<Whisky> findWhiskysByDistilleryName(String name);

    List<Whisky> findWhiskysByDistilleryRegion(String region);
}
