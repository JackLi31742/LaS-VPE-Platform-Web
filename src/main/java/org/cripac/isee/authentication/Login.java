package org.cripac.isee.authentication;

import org.apache.log4j.Logger;
import org.cripac.isee.entity.User;
import org.cripac.isee.service.LoginService;
import org.cripac.isee.util.Constant;
import org.cripac.isee.util.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(Constant.SESSION_USER_KEY)
public class Login {
	
	@Autowired
	private LoginService loginService;
	Logger log=null;
	
	@RequestMapping(value="/Login", method=RequestMethod.POST)
	public ModelAndView login(@RequestParam("name") String name, @RequestParam String password, ModelMap modelMap){
		ModelAndView view = new ModelAndView();
//		System.out.println("name is " + name);
//		System.out.println("password is " + password);
		log.info("name is " + name);
		log.info("password is " + password);
		//set RESTful parameters
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
		params.add("name", name);
		//the password should be encoded using MD5 algorithm
		params.add("password", MD5Encoder.encode(password));
		//invoke the RESTful interface and retrieve the response
		User user = loginService.getUser(name, password);
		
		String viewName = "login";
		if(null == user) {
			//login failed and back to the login page
			view.addObject("message", "username or password is incorrect");
			view.addObject("messagetype", "error");
		} else {
			// login successfully
			modelMap.addAttribute(Constant.SESSION_USER_KEY, user);
			if(user.getType() == Constant.USER_TYPE_ADMIN){
				// if the user is admin, go to approved task list
				viewName = "admin/success";
			} else {
				// if the user is normal user, go to user's task list page
				//TODO waiting for the controller to be completed
//				System.out.println("haven't implemented yet, forward to a sample page!!!!!");
				viewName = "views/success";
			}
		}
		view.setViewName(viewName);
		return view;
	}
	@RequestMapping("/Logout")
	public String logout(SessionStatus session) {
		session.setComplete();
		return "redirect:index.jsp";
	}
}
