package com.example.demo.Repository;

import com.example.demo.Entity.TodolistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodolistRepository extends JpaRepository<TodolistEntity, Long> {
}
