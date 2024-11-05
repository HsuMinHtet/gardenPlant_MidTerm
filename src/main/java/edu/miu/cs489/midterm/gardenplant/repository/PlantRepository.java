package edu.miu.cs489.midterm.gardenplant.repository;

import edu.miu.cs489.midterm.gardenplant.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant,Integer> {
    List<Plant> findAllByOrderByName();
    List<Plant> findAllByOrderByPlanDate();
}
