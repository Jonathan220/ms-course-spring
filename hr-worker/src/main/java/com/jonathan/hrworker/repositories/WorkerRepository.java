package com.jonathan.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jonathan.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
