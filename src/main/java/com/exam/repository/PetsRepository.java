package com.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exam.entity.Pets;

public interface PetsRepository extends JpaRepository<Pets, Integer> {

}
