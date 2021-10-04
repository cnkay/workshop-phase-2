package com.archisacademy.workshopphase2.repository;

import com.archisacademy.workshopphase2.data.Trainee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee,Long> {
    List<Trainee> findAll();
}
