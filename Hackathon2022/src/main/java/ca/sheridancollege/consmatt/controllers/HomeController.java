package ca.sheridancollege.consmatt.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ca.sheridancollege.consmatt.beans.Task;
import ca.sheridancollege.consmatt.beans.Time;
import ca.sheridancollege.consmatt.repositories.TaskRepository;
import ca.sheridancollege.consmatt.repositories.TimeRepository;




@Controller
public class HomeController { //Class starts
	
	static ArrayList<Task> tasks = new ArrayList<Task>(); 
	static ArrayList<Time> times = new ArrayList<Time>(); 
	
	@Autowired
	private TaskRepository taskRepo; 
	
	@Autowired
	private TimeRepository timeRepo; 

	@GetMapping("/") 
	public String root() {   //Method to access root page
		return "home.html";
	} //Method ends
	
	@GetMapping("/login") 
	public String login() { //Method to access root page, Security to be finished
		return "login.html";
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
	public String displayTasks(Model model) {
		model.addAttribute("myTasksMon", taskRepo.getTaskMonday());
		model.addAttribute("myTasksTue", taskRepo.getTaskTuesday());
		model.addAttribute("myTasksWed", taskRepo.getTaskWednesday());
		model.addAttribute("myTasksThu", taskRepo.getTaskThursday());   //Method to access displayTasks page, model.addAttribute is what refreshes the tables
		model.addAttribute("myTasksFri", taskRepo.getTaskFriday());
		model.addAttribute("myTasksSat", taskRepo.getTaskSaturday());
		model.addAttribute("myTasksSun", taskRepo.getTaskSunday());
		return "tasks.html";
	} //Method ends
	
	@GetMapping("/addTime")
	public String loadAddTimePage(Model model) { //Method to access addTask page
		model.addAttribute("time", new Time());
		return "addTime.html";
	} //Method ends
	
	@PostMapping("/addTime")
	public String addTime(@ModelAttribute Time time, Model model) { //Method to submit data on addTask page
		System.out.println(time);
		model.addAttribute("time", new Time());
		times.add(time);
		timeRepo.addTime(time);
		return"redirect:/addTime";
	} //Method ends
	
	
	
	
	
} //Class ends
