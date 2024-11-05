package edu.miu.cs489.midterm.gardenplant.service.impl;

import edu.miu.cs489.midterm.gardenplant.model.Plant;
import edu.miu.cs489.midterm.gardenplant.repository.PlantRepository;
import edu.miu.cs489.midterm.gardenplant.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {

    private final PlantRepository plantRepository;

    @Override
    public Optional<Plant> addPlant(Plant plant) {
        Plant savedPlant=plantRepository.save(plant);
        return Optional.of(savedPlant);
    }

    @Override
    public Optional<Plant> modifyPlant(Plant plant) {
        Optional<Plant> foundPlant=plantRepository.findById(plant.getId());
        foundPlant.ifPresent(
                plant1 -> plantRepository.save(plant)
        );
        return foundPlant;
    }

    @Override
    public void deletePlant(Integer plantId) {
        plantRepository.findById(plantId).ifPresent(
                plant -> plantRepository.delete(plant)
        );
    }

    @Override
    public List<Plant> getAllPlantSortedByName() {

        return plantRepository.findAllByOrderByName();
    }

    @Override
    public List<Plant> getAllPlantSortedByPlantDate() {
        return plantRepository.findAllByOrderByPlanDate();
    }
}
