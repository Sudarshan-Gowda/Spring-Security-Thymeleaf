package com.star.sud.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.star.sud.SectionKeys;
import com.star.sud.StarUtil;
import com.star.sud.security.service.StarSecurityService;

@Controller
public class StarLoginController {

	@Resource(name = "starSecurityService")
	protected StarSecurityService starSecurityService;

	protected static final String STAR_MESSAGE = "starMessage";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String loginPage(Model model, HttpSession session, @RequestParam Map<String, String> reqParams) {
		String starMessage = reqParams.get(STAR_MESSAGE);

		if (starMessage != null)
			model.addAttribute(STAR_MESSAGE, starMessage);

		reqParams.remove(STAR_MESSAGE);
		model.addAttribute(SectionKeys.REQ_PARAMS, StarUtil.getParamsAsString(reqParams));
		return "login/login-page";
	}

	@RequestMapping(value = "/login/login-failure", method = RequestMethod.GET)
	public String loginFailureView(Model model, RedirectAttributes redirectAttributes) {

		redirectAttributes.addAttribute(STAR_MESSAGE, "Invalid Credentials.");

		return "redirect:/";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	protected String welcome(Model model, HttpSession session, HttpServletRequest request,
			@RequestParam Map<String, String> requestParam) {

		int sessionTomeout = 50000;
		String sesTimeout = 60000 + "";
		if (sesTimeout != null && !sesTimeout.isEmpty()) {
			try {
				sessionTomeout = Integer.parseInt(sesTimeout);
			} catch (Exception e) {
			}
		}

		session.setMaxInactiveInterval(sessionTomeout);

		if (request.getRemoteUser() != null) {

			model.addAttribute("userName", request.getRemoteUser());
			return "welcome/welcome";
		} else {
			return "redirect:/";
		}

	}

	@RequestMapping(value = "/logout/success", method = RequestMethod.GET)
	public String logoutSuccessView(Model model) {
		return "redirect:/";
	}

}
