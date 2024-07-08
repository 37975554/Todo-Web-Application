package com.practice.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Task {
	
    public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(Long id, String description, LocalDate date, boolean isFinished) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
		this.isFinished = isFinished;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isFinished() {
		return isFinished;
	}
	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", date=" + date + ", isFinished=" + isFinished
				+ "]";
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String description;
    private LocalDate date;
    private boolean isFinished;

}