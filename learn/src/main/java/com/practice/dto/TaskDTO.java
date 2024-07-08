package com.practice.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TaskDTO {

    @NotBlank
    private String description;

    @NotNull
    private LocalDate date;

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

	@Override
	public String toString() {
		return "TaskDTO [description=" + description + ", date=" + date + "]";
	}

	public TaskDTO(@NotBlank String description, @NotNull LocalDate date) {
		super();
		this.description = description;
		this.date = date;
	}

	public TaskDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}
