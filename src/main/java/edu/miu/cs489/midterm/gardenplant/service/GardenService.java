package edu.miu.cs489.midterm.gardenplant.service;

import edu.miu.cs489.midterm.gardenplant.model.Garden;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface GardenService {
    Optional<Garden> addGarden(Garden garden);
    Optional<Garden> modifyGarden(Garden garden);
    void deleteGarden(Integer gardenId);
    List<Garden> getAllGarden();
}
