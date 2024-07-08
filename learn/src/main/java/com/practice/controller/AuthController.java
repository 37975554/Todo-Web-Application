package com.practice.controller;

import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

import javax.validation.Valid;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.practice.dto.TaskDTO;
import com.practice.dto.UserDTO;
import com.practice.entity.Task;
import com.practice.entity.User;
import com.practice.repository.TaskRepository;
import com.practice.repository.UserRepository;
import com.practice.services.TaskService;
import com.practice.services.UserService;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskService taskService;
    @Autowired
    private TaskRepository taskRepository;
    
    @GetMapping("/update-profile")
    public String updateProfile() {
        return "update-profile"; 
    }
    @PostMapping("/create-task")
    public ModelAndView createTask(@RequestParam("description") String description,
                                   @RequestParam("date") String date) {
        // Process the task creation here
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setDescription(description);
        taskDTO.setDate(LocalDate.parse(date)); 

        taskService.createTask(taskDTO); 

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/auth/tasks"); // 
        return modelAndView;
    }

    @GetMapping("/create-task")
    public String newTasks() {
        return "create-task"; 
    }

    
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
    	
        return "login"; 
    }
    
    @GetMapping("/register")
    public String showRegisterForm() {
    	return "register";
    }
    @GetMapping("/tasks")
    public String showTasks(ModelMap model) {
        List<Task> todoTasks = taskService.getTodoTasks();
       
        

        model.addAttribute("todoTasks", todoTasks);
       

        return "tasks";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute @Valid UserDTO userDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "register"; 
        }
        userService.registerUser(userDTO);
        return "redirect:login"; 
    }

    @PostMapping("/login")
    public ModelAndView loginUser(@RequestParam String email, @RequestParam String password) {
        ModelAndView modelAndView = new ModelAndView();

        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
           
            if (decryptPassword(user.getPassword()).equals(password)) {
                modelAndView.setViewName("redirect:/auth/tasks"); 
               // modelAndView.addObject("message", "User logged in successfully");
            } else {
                modelAndView.setViewName("login");
                modelAndView.addObject("error", "Invalid email or password");
            }
        } else {
            modelAndView.setViewName("login");
            modelAndView.addObject("error", "Invalid email or password");
        }

        return modelAndView;
    }


    private String encryptPassword(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    private String decryptPassword(String encryptedPassword) {
        return new String(Base64.getDecoder().decode(encryptedPassword));
    }

    @PutMapping("/update-profile")
    public ModelAndView updateUser(@RequestBody @Valid UserDTO userDTO) {
    	ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("redirect:/auth/tasks");
        userService.updateUser(userDTO);
        modelAndView.addObject("message", "User updated successfully");
        return modelAndView;
    }
    @GetMapping("/updateTask")
    public String showUpdateTast() {
    	return "updateTask";
    }
    @PostMapping("/updateTask")
    public ModelAndView updateTask(@RequestParam("description") String description,
                                   @RequestParam("date") String date,@RequestParam String isFinished) {
        // Process the task creation here
        Task task = new Task();
        task.setDescription(description);
        task.setDate(LocalDate.parse(date));
        task.setFinished(true);
  
        taskRepository.save(task); 

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/auth/tasks"); // 
        return modelAndView;
    }
    
}
