package com.archisacademy.workshopphase2.controller;

import com.archisacademy.workshopphase2.data.Trainee;
import com.archisacademy.workshopphase2.dto.TraineeDto;
import com.archisacademy.workshopphase2.service.TraineeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/trainee")
public class TraineeController {

    private TraineeService traineeService;

    public TraineeController(TraineeService traineeService){
        this.traineeService = traineeService;
    }

    @GetMapping
    public List<Trainee> getAllTrainees(){
        return traineeService.getAllTrainees();
    }

    @PostMapping
    public Trainee createTrainee(@RequestBody TraineeDto traineeDto){
        return traineeService.createTrainee(traineeDto);
    }

    @GetMapping(value = "/{id}")
    public Trainee getTraineeById(@PathVariable("id") Long id){
        return traineeService.getTraineeById(id);
    }

    @PutMapping(value = "/{id}")
    public Trainee updateTraineeById(@PathVariable("id") Long id, @RequestBody TraineeDto traineeDto){
        return traineeService.updateTraineeById(id,traineeDto);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTraineeById(@PathVariable("id") Long id){
        traineeService.deleteTraineeById(id);
    }
}
