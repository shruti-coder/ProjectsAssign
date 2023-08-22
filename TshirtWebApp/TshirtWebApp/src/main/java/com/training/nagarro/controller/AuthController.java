package com.training.nagarro.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.training.nagarro.model.TShirt;
import com.training.nagarro.model.User;
import com.training.nagarro.service.AuthService;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Auth Cntroller
 */
@Controller
public class AuthController {
	private static final String INDEX = "index";
	@Autowired
	private User user;

	@Autowired
	private AuthService authService;

	@Autowired
	private CSVController csv;
	
	@Autowired
	private TShirt tshirt;

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String index(Model model) {
		csv.loadData();
		model.addAttribute("user", user);
		return INDEX;
	}

	/**
	 * @param webDataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	/**
	 * @param user
	 * @param bindingResult
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	public String isLoggedIn(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return INDEX;
		}
		if (authService.validateUser(user)) {
			model.addAttribute("tshirt", tshirt);
			return "productSearch";
		} else
			return INDEX;
	}

	/**
	 * @param model
	 * @return
	 */
	@RequestMapping("/signup")
	public String signUp(Model model) {
		model.addAttribute("user", user);
		return "signUp";
	}
	

    /**
     * @param user
     * @param bindingResult
     * @param model
     * @return
     */
    @PostMapping("/signed")
    public String signingUp(@Valid @ModelAttribute("user") User user,
                            BindingResult bindingResult, Model model){
        if(!bindingResult.hasErrors()){
        	authService.addUser(user);
        	model.addAttribute("user",user);                   
        }
        return INDEX;
    }
    
    /**
     * @return size list
     */
    @ModelAttribute("sizeList")
    public Map<String, String> getSize() {
        Map<String, String> sizeList = new HashMap<>();

        sizeList.put("xs", "XS");
        sizeList.put("s", "S");
        sizeList.put("m", "M");
        sizeList.put("l", "L");
        sizeList.put("xl", "Xl");
        sizeList.put("xxl", "XXL");

        return sizeList;
    }
}
