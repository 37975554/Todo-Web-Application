package com.practice.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dto.TaskDTO;
import com.practice.entity.Task;

import com.practice.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasksByDate(LocalDate date, boolean isFinished) {
        return taskRepository.findByDateAndIsFinished(date, isFinished);
    }
    public List<Task> getTodoTasks() {
        return taskRepository.findByIsFinished(false);
    }

    public List<Task> getFinishedTasks() {
        return taskRepository.findByIsFinished(true);
    }

    public Task createTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setDescription(taskDTO.getDescription());
        task.setDate(taskDTO.getDate());
        task.setFinished(false);
        return taskRepository.save(task);
    }

	
}

