package app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		ModelAndView model = new ModelAndView("home");
		model.addObject("users", new User());
		model.addObject("users", userService.loadUsers());
		return model;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") int id, Model model) {
		logger.info("detail user");
		User user = userService.findById(id);
		if (user == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "User not found");
		}
		model.addAttribute("user", user);
		return "user";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String deleteUser(@PathVariable("id") Integer id, final RedirectAttributes redirectAttributes) {
		logger.info("delete user");
		if (userService.deleteUser(id)) {
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "User is deleted!");
		} else {
			redirectAttributes.addFlashAttribute("css", "error");
			redirectAttributes.addFlashAttribute("msg", "Delete user fails!!!!");
		}

		return "redirect:/";

	}

	@RequestMapping(value = "/users/add", method = RequestMethod.GET)
	public String newUser(Model model) {
		User user = new User();

		// set default value
		user.setGender(0);

		model.addAttribute("userForm", user);
		model.addAttribute("status", "add");

		return "userform";

	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String editUser(@PathVariable("id") int id, Model model) {

		User user = userService.findById(id);
		model.addAttribute("userForm", user);
		model.addAttribute("status", "edit");

		return "userform";

	}
}