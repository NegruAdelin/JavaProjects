package com.example.demo.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.DentalOffice;
import com.example.demo.model.User;
import com.example.demo.model.Appointment;
import com.example.demo.srvices.AppointmentService;
import com.example.demo.srvices.DentalOfficeService;
import com.example.demo.srvices.UserService;

@Controller
public class APIController {
	
	private List<Integer> listOfUsers;
	private List<Integer> listOfDental;
	private final UserService userService;
	private final DentalOfficeService dentalOfficeService;
	private final AppointmentService appointmentService;
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	public APIController(UserService userService, DentalOfficeService dentalOfficeService, AppointmentService appointmentService,
			List<Integer> listOfUsers, List<Integer> listOfDental) {
		this.userService = userService;
		this.dentalOfficeService = dentalOfficeService;
		this.appointmentService = appointmentService;
		this.listOfUsers = listOfUsers;
		this.listOfDental = listOfDental;
	}
	
	public boolean isLogged(int id) {
		Optional<User> optionalUser = userService.getById(id);
		
		return listOfUsers.contains(optionalUser.get().getId());
	}
	
	public boolean isLoggedDental(int id) {
		Optional<DentalOffice> optionalDental = dentalOfficeService.getById(id);
		
		return listOfDental.contains(optionalDental.get().getId());
	}
	
	@GetMapping
	public String Login() {
		return "Login";
	}
	
	@GetMapping("/LoginDental")
	public String LoginDental() {
		return "LoginDental";
	}
	
	@GetMapping("/Signup")
	public String Signup() {
		return "Sign-up";
	}
	
	@GetMapping("/SignupDental")
	public String SignupDental() {
		return "Sign-upDental";
	}
	
	@GetMapping("/Home")
	public String Home(@RequestParam(value = "id") int id,
						Model model) {
		
		if(isLogged(id)) {
			List<DentalOffice> dentalOfficeList = dentalOfficeService.getAll();
			model.addAttribute("id", id);
			
			if(!dentalOfficeList.isEmpty())
				model.addAttribute("DentalOffice", dentalOfficeList);
			return "Home";
		}
		else {
			return "Login";
		}
	}
	
	@GetMapping("/HomeDental")
	public String HomeDental(@RequestParam(value = "id") int id,
						Model model) {
		
		if(isLoggedDental(id)) {
			List<Appointment> appointmentList = appointmentService.getByDentalId(id);
			model.addAttribute("id", id);
			
			if(!appointmentList.isEmpty())
				model.addAttribute("appointment", appointmentList);
			return "HomeDental";
		}
		else {
			return "LoginDental";
		}
	}
	
	@GetMapping("/Appointment")
	public String Appointment(@RequestParam(value = "id") int id, 
			Model model) {
		
		if(isLogged(id)) {
			List<Appointment> appointmentList = appointmentService.getByUserId(id);
			model.addAttribute("id", id);

			if(!appointmentList.isEmpty())
				model.addAttribute("appointment", appointmentList);
			return "Appointment";
		}
		else {
			return "Login";
		}
	}
	
	@GetMapping("/Logout")
	public RedirectView Logout(@RequestParam(value = "id") int id) {
		Optional<User> userOptional = userService.getById(id);
		int index = listOfUsers.indexOf(userOptional.get().getId());
		listOfUsers.remove(index);
		return new RedirectView("http://localhost:8080/"); 
	}
	
	@GetMapping("/LogoutDental")
	public RedirectView LogoutDental(@RequestParam(value = "id") int id) {
		/* Optional<DentalOffice> dentalOptional = dentalOfficeService.getById(id); */
		int index = listOfDental.indexOf(id);
		listOfDental.remove(index);
		return new RedirectView("http://localhost:8080/"); 
	}
	
	@GetMapping("/CreateAppointment")
	public RedirectView CreateAppointment(@RequestParam(value = "id_user") int idUser,
									@RequestParam(value = "id_dental") int idDental) {
		Optional<User> user = userService.getById(idUser);
		Optional<DentalOffice> dental = dentalOfficeService.getById(idDental);
		
		LocalDate localDate = LocalDate.now();
		String stringDate = localDate.toString();
		appointmentService.add(new Appointment(user.get(), dental.get(), stringDate));
		
		if(isLogged(idUser))
		{
			return new RedirectView("http://localhost:8080/Home?id=" + idUser);
		}
		else {
			if(isLoggedDental(idDental)) {
				return new RedirectView("http://localhost:8080/HomeDental?id=" + idDental);
			}
			else {
				return new RedirectView("/Login");
			}	
		}
	}
	
	@GetMapping("/Contact")
	public String Contact(@RequestParam(value = "id")int id, 
						  Model model) {
		
		if(isLogged(id)) {
			Optional<User> userOptional = userService.getById(id);
			model.addAttribute("id", id);

			model.addAttribute("user", userOptional.get());
			return "Contact";
		}
		else {
			return "Login";
		}
	}
	
	@GetMapping("/ContactDental")
	public String ContactDental(@RequestParam(value = "id")int id, 
						  Model model) {
		
		if(isLoggedDental(id)) {
			Optional<DentalOffice> dentalOptional = dentalOfficeService.getById(id);
			model.addAttribute("id", id);

			model.addAttribute("dental", dentalOptional.get());
			return "ContactDental";
		}
		else {
			return "LoginDental";
		}
	}

	@GetMapping("/EditData")
	public String EditData(@RequestParam(value = "id") int id, 
						   Model model) {
		if(isLogged(id)) {
			Optional<User> userOptional = userService.getById(id);
			model.addAttribute("id", id);

			model.addAttribute("user", userOptional.get());
			return "EditData";
		}
		else {
			return "Login";
		}
	}
	
	@GetMapping("/EditDataDental")
	public String EditDataDental(@RequestParam(value = "id") int id, 
						   Model model) {
		if(isLoggedDental(id)) {
			Optional<DentalOffice> dentalOptional = dentalOfficeService.getById(id);
			model.addAttribute("id", id);

			model.addAttribute("dental", dentalOptional.get());
			return "EditDataDental";
		}
		else {
			return "LoginDental";
		}
	}
	
	@GetMapping("/DeleteDental")
	public RedirectView DeleteDental(@RequestParam(value = "id_dental") int idDental,
									 @RequestParam(value ="id_appointment") int idAppointment) {
		if(isLoggedDental(idDental)) {
			appointmentService.deleteById(idAppointment);
		}

		return new RedirectView("/HomeDental?id=" + idDental);
	}
	
	
	@GetMapping("/UsersForAppointment")
	public String UsersForAppointment(@RequestParam(value = "id") int id,
									  Model model) {
		
		if(isLoggedDental(id)) {
			model.addAttribute("id", id);
			
			List<User> userList = userService.getAll();
			if(!userList.isEmpty()) {
				model.addAttribute("user", userList);
			}
			
			return "UsersForAppointment";
		}
		else {
			return "LoginDental";
		}
	}
	
	@GetMapping("/ResetPasswordDental")
	public String ResetPasswordDental(@RequestParam("id") int id,
									 Model model) {
		
		if(isLoggedDental(id)) {
			model.addAttribute("id", id);
			return "ResetPasswordDental";
		}
		else {
			return "LoginDental";
		}
	}
	
	@GetMapping("/ResetPassword")
	public String ResetPassword(@RequestParam("id") int id,
									 Model model) {
		
		if(isLogged(id)) {
			model.addAttribute("id", id);
			return "ResetPassword";
		}
		else {
			return "Login";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/ResetPassword")
	public RedirectView ResetPassword(@RequestParam(value = "id") int id, User user) {
		
		if(isLogged(id)) {
			Optional<User> userOptional = userService.getById(id);
			if(!userOptional.isEmpty()) {
				userOptional.get().setPassword(passwordEncoder.encode(user.getPassword()));
				userService.add(userOptional.get());
				return new RedirectView("/Home?id=" + id);
			}
			else {
				return new RedirectView("/");
			}
		}
		else {
			return new RedirectView("/");
		}
	}
	
	@PostMapping("/ResetPasswordDental")
	public RedirectView ResetPasswordDental(@RequestParam(value = "id") int id, DentalOffice dental) {
		
		if(isLoggedDental(id)) {
			Optional<DentalOffice> dentalOptional = dentalOfficeService.getById(id);
			if(!dentalOptional.isEmpty()) {
				dentalOptional.get().setPassword(passwordEncoder.encode(dental.getPassword()));
				dentalOfficeService.add(dentalOptional.get());
				return new RedirectView("/HomeDental?id=" + id);
			}
			else {
				return new RedirectView("/LoginDental");
			}
		}
		else {
			return new RedirectView("/LoginDental");
		}
	}
	
	@PostMapping("/EditData")
	public RedirectView EditData(User user) {
		userService.add(user);
		return new RedirectView("/Home?id=" + user.getId());
	}
	
	@PostMapping("/EditDataDental")
	public RedirectView EditDataDental(DentalOffice dental) {
		dentalOfficeService.add(dental);
		return new RedirectView("/HomeDental?id=" + dental.getId());
	}
	
	@PostMapping
	public RedirectView Login(User user) {
		Optional<User> userOptional = userService.getByEmail(user.getEmail());
		
		if(userOptional.isEmpty()) {
			return new RedirectView("http://localhost:8080/");
		}
		else {
			if(passwordEncoder.matches(user.getPassword(), userOptional.get().getPassword())) {
				listOfUsers.add(userOptional.get().getId());
				return new RedirectView("http://localhost:8080/Home?id=" + userOptional.get().getId());
			}
			else {
				return new RedirectView("/");
			}
		}
	}
	
	@PostMapping("/LoginDental")
	public RedirectView LoginDental(DentalOffice dental) {
		Optional<DentalOffice> dentalOptional = dentalOfficeService.getByEmail(dental.getEmail());
		
		if(dentalOptional.isEmpty()) {
			return new RedirectView("http://localhost:8080/LoginDental");
		}
		else {
			if(passwordEncoder.matches(dental.getPassword(), dentalOptional.get().getPassword())) {
				listOfDental.add(dentalOptional.get().getId());
				return new RedirectView("http://localhost:8080/HomeDental?id=" + dentalOptional.get().getId());
			}
			else {
				return new RedirectView("/LoginDental");
			}
		}
	}
	
	@PostMapping("/Signup")
	public RedirectView Signup(User user) {
		String password = passwordEncoder.encode(user.getPassword());
		user.setPassword(password);
		userService.add(user);
		return new RedirectView("http://localhost:8080/");
	}
	
	@PostMapping("/SignupDental")
	public RedirectView SignupDental(DentalOffice dentalOffice) {
		String password = passwordEncoder.encode(dentalOffice.getPassword());
		dentalOffice.setPassword(password);
		dentalOfficeService.add(dentalOffice);
		return new RedirectView("/LoginDental");
	}
}
