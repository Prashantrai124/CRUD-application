package com.example.Registration.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import NewProject.NewProject2.controller.User;



@Controller
public class API {
	@Autowired
	private UserRepository repo;
	
	@PostMapping("/process_register")	
	public String processRegister(@RequestParam String firstName,@RequestParam String lastName,@RequestParam String email,@RequestParam String password) {
	   User u = new User();
	  u.setFirstName(firstName);
	  u.setLastName(lastName);
	  u.setEmail(email);
	  u.setPassword(password);
	   repo.save(u);	   
	   return "login_page";
	}
	@GetMapping("process_login")
	public String processLogin(@RequestParam String email,@RequestParam String password) {
		User u= repo.findByEmailAndPassword(email, password);
		if(u==null)
		{
			return "error";
		}
	   return "home_page";
	}
	@GetMapping("/login")
	public String login()
	{
		return "login_page";
	}
	@PostMapping("/addall")
	   public @ResponseBody boolean addall(@RequestParam Integer id,@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email)
	   {
		   User u = new User();
		    u.setId(id);
		    u.setFirstName(firstName);
		    u.setLastName(lastName);
		    u.setEmail(email);		   		   
		    repo.save(u);
		    return true;
	   }
	   @GetMapping("/readall")
	   public @ResponseBody Iterable<User> read() {
	  
	  	return repo.findAll();
	  	
	   }
	   @PostMapping("/update")
	   public @ResponseBody boolean update(@RequestParam Integer id ,@RequestParam String firstName , @RequestParam String lastName,String email) {
		      repo.updateFirstNameById(firstName, id);
		      repo.updateLastNameById(lastName, id);
		      repo.updateEmailById(email, id);
		       return true;
	   }
	   @GetMapping("/deleteall")
	   public @ResponseBody boolean delete(@RequestParam Integer id)
	   {
	  	 repo.deleteById(id);
	  	 return true;
	   }
	   
}
