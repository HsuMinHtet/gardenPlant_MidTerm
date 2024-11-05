package edu.miu.cs489.midterm.gardenplant.repository;

import edu.miu.cs489.midterm.gardenplant.model.Garden;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GardenRepository extends JpaRepository<Garden,Integer> {

}
