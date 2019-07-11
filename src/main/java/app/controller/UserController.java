package app.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.model.User;
import app.service.UserService;

@Controller
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/")
	public ModelAndView index() {
		logger.info("home page");
		ModelAndView model = new ModelAndView("index");
		model.addObject("users", new User());
		model.addObject("users", userService.loadUsers());
		return model;
	}

	@RequestMapping("/userform")
	public String showform(Model m) {
		m.addAttribute("command", new User());
		return "userform";
	}

	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("user") User user) {
		
		userService.saveOrUpdate(user);
		return "redirect:/viewuser";
	}

	@RequestMapping("/viewuser")
	public String viewuser(Model m) {
	
		List<User> list = userService.loadUsers();
		m.addAttribute("list", list);
		return "viewuser";
	}

	@RequestMapping(value = "/edituser/{id}")
	public String edit(@PathVariable int id, Model m) {
		User user = userService.findById(id);
		m.addAttribute("command", user);
		return "usereditform";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String editsave(@ModelAttribute("user") User user) {
		userService.saveOrUpdate(user);
		return "redirect:/viewuser";
	}

	@RequestMapping(value = "/deleteuser/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable int id) {
		userService.deleteUser(id);
		return "redirect:/viewuser";
	}
}