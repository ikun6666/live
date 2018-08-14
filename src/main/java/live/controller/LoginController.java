package live.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import live.model.UserRedis;
import live.service.LiveService;
import live.service.UserService;

@RestController
public class LoginController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	UserService userService;

	@Autowired
	LiveService liveService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView toLogin(ModelMap model) {
		UserRedis user = new UserRedis();
		model.addAttribute("user", user);
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(ModelMap model, @ModelAttribute(value = "user") UserRedis user, HttpSession session) {
		String url = "liveList";
		if (userService.isUser(user)) {
			session.setAttribute("user", user);
			model.addAttribute("liveList", liveService.getAll());
		} else {
			model.addAttribute("user", user);
			model.addAttribute("errorMessage", "用户名或者密码错误！");
			logger.info("用户名= " + user.getName());// 打印日志
			url = "login";
		}
		return new ModelAndView(url);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("login");
	}
}
