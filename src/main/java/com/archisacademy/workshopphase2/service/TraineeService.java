package com.archisacademy.workshopphase2.service;

import com.archisacademy.workshopphase2.data.Trainee;
import com.archisacademy.workshopphase2.dto.TraineeDto;

import java.util.List;

public interface TraineeService {
    List<Trainee> getAllTrainees();
    Trainee createTrainee(TraineeDto traineeDto);
    Trainee getTraineeById(Long id);
    Trainee updateTraineeById(Long id, TraineeDto traineeDto);
    void deleteTraineeById(Long id);
}
