package ca.sheridancollege.consmatt.controllers;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ca.sheridancollege.consmatt.beans.Task;
import ca.sheridancollege.consmatt.repositories.TaskRepository;





@Controller
public class HomeController { //Class starts
	
	static ArrayList<Task> tasks = new ArrayList<Task>(); 

	@Autowired
	private TaskRepository taskRepo; 
	 

	@GetMapping("/") 
	public String root(@ModelAttribute Task task, Model model) {   //Method to access root page
		model.addAttribute("myTasksMon", taskRepo.getTaskMonday());
		model.addAttribute("myTasksTue", taskRepo.getTaskTuesday());
		model.addAttribute("myTasksWed", taskRepo.getTaskWednesday());
		model.addAttribute("myTasksThu", taskRepo.getTaskThursday());   //Method to access displayTasks page, model.addAttribute is what refreshes the tables
		model.addAttribute("myTasksFri", taskRepo.getTaskFriday());
		return "home.html";
	} //Method ends
	
	
	@GetMapping("/signUp") 
	public String signup() { //Method to access signUp page, Security to be finished
		return "signUp.html";
	} //Method ends
	
	@GetMapping("/addTask")
	public String loadAddTaskPage(Model model) { //Method to access addTask page
		model.addAttribute("task", new Task());
		return "addTask.html";
	} //Method ends
	
	@PostMapping("/addTask")
	public String addTask(@ModelAttribute Task task, Model model) { //Method to submit data on addTask page
		System.out.println(task);
		model.addAttribute("task", new Task());
		tasks.add(task);
		taskRepo.addTask(task);
		return"redirect:/addTask";
	} //Method ends
	


	@GetMapping("/displayTasks")
	public String loadTasksPage(Authentication authentication, Model model,  HttpServletRequest req, Principal principal) { 
		String name = authentication.getName();  
		
		ArrayList<String> roles = new ArrayList<String>();
		for (GrantedAuthority ga : authentication.getAuthorities()) {                                
			roles.add(ga.getAuthority());
		}
		model.addAttribute("myTasksMon", taskRepo.getTaskMonday());
		model.addAttribute("myTasksTue", taskRepo.getTaskTuesday());
		model.addAttribute("myTasksWed", taskRepo.getTaskWednesday());
		model.addAttribute("myTasksThu", taskRepo.getTaskThursday());   //Method to access displayTasks page, model.addAttribute is what refreshes the tables
		model.addAttribute("myTasksFri", taskRepo.getTaskFriday());
	  
	    System.out.println(principal.getName());
		return "tasks.html";
		}
	
	@GetMapping("/delete/{id}") 
	public String deleteEmployee(@PathVariable int id, Model model) {
		taskRepo.deleteTask(id);
		model.addAttribute("myTasksMon", taskRepo.getTaskMonday());
		model.addAttribute("myTasksTue", taskRepo.getTaskTuesday());
		model.addAttribute("myTasksWed", taskRepo.getTaskWednesday());
		model.addAttribute("myTasksThu", taskRepo.getTaskThursday());
		model.addAttribute("myTasksFri", taskRepo.getTaskFriday());
		return "tasks.html";
	}
	
	
	
	
	
	
} //Class ends
