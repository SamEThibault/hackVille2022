package ca.sheridancollege.consmatt.controllers;

import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import ca.sheridancollege.consmatt.beans.Avail;
import ca.sheridancollege.consmatt.logic.Logic;
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

	// hard coded availability objects specifying available times grouped with weekday title
	Avail mon = new Avail("Monday", 0);
	Avail tue = new Avail("Tuesday", 2);
	Avail wed = new Avail("Wednesday", 3);
	Avail thu = new Avail("Thursday", 6);
	Avail fri = new Avail("Friday", 7);

	// availability object array to store these instances
	Avail[] availArray = {mon, tue, wed, thu, fri};
	String[] suggestions = new String[20]; // this is where we will populate the final suggestions for a max 20 tasks
	int count = 0;
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

		// sam section to capture logic input:

		Logic callLogic = new Logic(task, availArray);
		String taskSuggest = callLogic.Output(); // this should call the logic routine
		suggestions[count] = taskSuggest; // add the suggested day to suggestion string array
		count++; // array index counter increments



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
		return "redirect:/";
	}
	
	
	
	
	
	
} //Class ends
