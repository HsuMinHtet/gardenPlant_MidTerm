package edu.miu.cs489.midterm.gardenplant.service.impl;

import edu.miu.cs489.midterm.gardenplant.model.Garden;
import edu.miu.cs489.midterm.gardenplant.repository.GardenRepository;
import edu.miu.cs489.midterm.gardenplant.service.GardenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GardenServiceImpl implements GardenService {

    private final GardenRepository gardenRepository;

    @Override
    public Optional<Garden> addGarden(Garden garden) {
        Garden saveGarden= gardenRepository.save(garden);
        return Optional.of(saveGarden);
    }

    @Override
    public Optional<Garden> modifyGarden(Garden garden) {
        Optional<Garden> foundGarden= gardenRepository.findById(garden.getId());
        foundGarden.ifPresent(
                garden1 -> gardenRepository.save(garden)
        );
        return foundGarden;
    }

    @Override
    public void deleteGarden(Integer gardenId) {
        gardenRepository.findById(gardenId).ifPresent(
                garden -> gardenRepository.delete(garden)
        );
    }

    @Override
    public List<Garden> getAllGarden() {
        return gardenRepository.findAll();
    }
}
