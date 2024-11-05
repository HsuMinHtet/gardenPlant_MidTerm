package edu.miu.cs489.midterm.gardenplant.service;

import edu.miu.cs489.midterm.gardenplant.model.Plant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlantService {
    Optional<Plant> addPlant(Plant plant);
    Optional<Plant> modifyPlant(Plant plant);
    void deletePlant(Integer plantId);
    List<Plant> getAllPlantSortedByName();
    List<Plant> getAllPlantSortedByPlantDate();
}
