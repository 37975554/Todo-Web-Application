package com.practice.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;



public class UserDTO {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(@NotBlank String username, @NotBlank String password, @Email @NotBlank String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", email=" + email + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Email
    @NotBlank
    private String email;

}