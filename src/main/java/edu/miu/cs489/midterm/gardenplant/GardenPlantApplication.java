package edu.miu.cs489.midterm.gardenplant;

import edu.miu.cs489.midterm.gardenplant.model.Garden;
import edu.miu.cs489.midterm.gardenplant.model.Plant;
import edu.miu.cs489.midterm.gardenplant.service.GardenService;
import edu.miu.cs489.midterm.gardenplant.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@RequiredArgsConstructor
public class GardenPlantApplication {

    private final GardenService gardenService;
    private final PlantService plantService;

    public static void main(String[] args) {
        SpringApplication.run(GardenPlantApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            //create Garden
            Garden garden = new Garden("Vegatable Patch",50.00);
            Garden garden1= new Garden("Herb Garden", 20.00);
            gardenService.addGarden(garden);
            gardenService.addGarden(garden1);
            //get All Garden
            System.out.println();
            System.out.println("--------------------------------------");
            System.out.println("Gardens: ");
            gardenService.getAllGarden().forEach(System.out::println);
            //create plant
            Plant plant= new Plant("Tomato","Vegatable", LocalDate.of(2024,03,10),garden);
            Plant plant1= new Plant("Carrot","Vegatable", LocalDate.of(2024,02,20),garden);
            Plant plant2= new Plant("Basil","Herb", LocalDate.of(2024,04,05),garden1);
            plantService.addPlant(plant);
            plantService.addPlant(plant1);
            plantService.addPlant(plant2);
            //get All plant
            System.out.println("_____________________________________");
            System.out.println("Plants(Sorted By Name): ");
            plantService.getAllPlantSortedByName().forEach(System.out::println);
            System.out.println("_____________________________________");
            System.out.println("Plants(Sorted By Date): ");
            plantService.getAllPlantSortedByPlantDate().forEach(System.out::println);
            System.out.println();

            System.out.println("_____________________________________");
            System.out.println("CRUD Operations:");
            garden.setName("Happy Farm");
            gardenService.modifyGarden(garden);
            gardenService.getAllGarden().forEach(System.out::println);
            System.out.println();
            plant.setName("Sugar Cane");
            plantService.modifyPlant(plant);
            plantService.getAllPlantSortedByName().forEach(System.out::println);
            System.out.println();

        };
    }

}
