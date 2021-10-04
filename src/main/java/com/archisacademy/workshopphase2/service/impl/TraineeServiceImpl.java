package com.archisacademy.workshopphase2.service.impl;

import com.archisacademy.workshopphase2.data.Trainee;
import com.archisacademy.workshopphase2.dto.TraineeDto;
import com.archisacademy.workshopphase2.repository.TraineeRepository;
import com.archisacademy.workshopphase2.service.TraineeService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TraineeServiceImpl implements TraineeService {

    private TraineeRepository traineeRepository;

    public TraineeServiceImpl(TraineeRepository traineeRepository) {
        this.traineeRepository = traineeRepository;
    }

    @Override
    public List<Trainee> getAllTrainees() {
        return traineeRepository.findAll();
    }

    @Override
    public Trainee createTrainee(TraineeDto traineeDto) {
        Trainee trainee = new Trainee();
        trainee.setFirstName(traineeDto.getFirstName());
        trainee.setLastName(traineeDto.getLastName());
        trainee.setEmail(traineeDto.getEmail());
        return traineeRepository.save(trainee);
    }

    @Override
    public Trainee getTraineeById(Long id) {
        return findById(id);
    }

    @Override
    public Trainee updateTraineeById(Long id, TraineeDto traineeDto) {
        Trainee trainee = findById(id);
        if (traineeDto.getFirstName() != null) {
            trainee.setFirstName(traineeDto.getFirstName());
        }
        if (traineeDto.getLastName() != null) {
            trainee.setLastName(traineeDto.getLastName());
        }
        if (traineeDto.getEmail() != null) {
            trainee.setEmail(traineeDto.getEmail());
        }
        return traineeRepository.save(trainee);
    }

    @Override
    public void deleteTraineeById(Long id) {
        Trainee trainee = findById(id);
        traineeRepository.delete(trainee);
    }

    private Trainee findById(Long id) {
        Optional<Trainee> optionalTrainee = traineeRepository.findById(id);
        if (!optionalTrainee.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"There is no trainee with ID: "+id);
        }
        return optionalTrainee.get();
    }
}
