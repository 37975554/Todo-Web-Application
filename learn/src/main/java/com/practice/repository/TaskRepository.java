package com.practice.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.entity.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByDateAndIsFinished(LocalDate date, boolean isFinished);
    default List<Task> findByIsFinished(boolean isFinished) {
        return findAll().stream()
            .filter(task -> task.isFinished() == isFinished)
            .collect(Collectors.toList());
    }
}
