package org.cripac.isee.authentication;

import org.cripac.isee.entity.User;
import org.cripac.isee.service.RegistService;
import org.cripac.isee.util.Constant;
import org.cripac.isee.util.MD5Encoder;
import org.cripac.isee.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;	

@Controller
@SessionAttributes(Constant.SESSION_USER_KEY)
public class Regist {

	@Autowired
	private RegistService registService;
	
	@RequestMapping("/regist")
	public ModelAndView regist(@RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "password", required = false) String password,
			@RequestParam(value = "repassword", required = false) String repassword,
			@RequestParam(value = "gender") int gender, @RequestParam(value = "phone", required = false) String phone,
			@RequestParam(value = "email", required = false) String email,
			@RequestParam(value = "gender") int type,
			ModelMap modelMap) {

		ModelAndView view = new ModelAndView();

		String viewName = "register";
		int tag = 0;

		// message defines
		String msg = "message";
		String msgc = "message content";
		String msgt = "messagetype";
		String error = "error";
		String warning = "warning";
		String notice = "notice";

		// tag = 1 : cases of no input
		if (StringUtil.isBlank(name)) {
			tag = 1;
			msgc = "Please enter name.";
		} else if (StringUtil.isBlank(password)) {
			tag = 1;
			msgc = "Please enter password.";
		} else if (StringUtil.isBlank(repassword)) {
			tag = 1;
			msgc = "Please confirm password.";
		} else if (StringUtil.isBlank(phone)) {
			tag = 1;
			msgc = "Please enter phone number.";
		} else if (StringUtil.isBlank(email)) {
			tag = 1;
			msgc = "Please enter email address.";
		}

		// tag = 2 : cases of invalid input
		if (0 == tag) {
			if (!password.equals(repassword)) {
				tag = 2;
				msgc = "Password confirmation doesn't match, please re-enter.";
			} else if (!email.matches("(([a-zA-Z]|[0-9])|([-]|[_]|[.]))+[@](([a-zA-Z0-9])|([-])){2,63}[.](([a-zA-Z0-9]){2,63})+")) {
				tag = 2;
				msgc = "Invalid email address, please check.";
			} else if (!phone.matches("[0-9-]+")) {
				tag = 2;
				msgc = "Invalid phone number, please check.";
			}
		}

		// tag = 3 : cases of error
		if (0 == tag) {
			MultiValueMap<String, Object> params = new LinkedMultiValueMap<String, Object>();
			params.add("name", name);
			
//			if (0 != Integer.parseInt(resp.getStatus())) {
//				tag = 3;
//				msgc = "Username existed, please change another one.";
//			} else {
				
				User user = new User();
//				ui.setEmail(email);
//				ui.setGender(Integer.toString(gender));
//				ui.setMobile(phone);
				user.setName(name);
//				user.setPassWord(MD5Encoder.encode(password));
				user.setPassWord(password);
				user.setType(1);
				params.clear();
				params.add("user", user);
				
				System.out.println(user);
				registService.insert(name,password,type);
				msgc = "Regist success. Please login.";
//				if (0 != Integer.parseInt(rest.getStatus())) {
//					tag = 3;
//					msgc = "Regist error, please contact administrator. (Error Code - 0xE0)";
//				}
			}
//		}

		// process msgs
		view.addObject(msg, msgc);
		if (1 == tag) {
			view.addObject(msgt, notice);
		} else if (2 == tag) {
			view.addObject(msgt, warning);
		} else if (3 == tag) {
			view.addObject(msgt, error);
		} else {
			view.addObject(msgt, notice);
			viewName = "login";
		}

		// persist value
		if (0 != tag) {
			if (!StringUtil.isBlank(name)) {
				view.addObject("name", name);
			}
			if (!StringUtil.isBlank(phone)) {
				view.addObject("phone", phone);
			}
			if (!StringUtil.isBlank(email)) {
				view.addObject("email", email);
			}
			if (0 != gender) {
				view.addObject("gender", gender);
			}
		}

		view.setViewName(viewName);
		return view;
	}

}
