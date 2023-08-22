package com.training.nagarro.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.training.nagarro.model.TShirt;
import com.training.nagarro.model.User;
import com.training.nagarro.service.TShirtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Tshirt controller
 */
@Controller
public class TShirtController {
	private final TShirtService tshirtService;

	@Autowired
	public TShirtController(TShirtService tshirtService) {
		this.tshirtService = tshirtService;
	}

	@Autowired
	private TShirt tshirt;

	@Autowired
	private User user;

	/**
	 * @param pref
	 * @param tShirt
	 * @param model
	 * @return
	 */
	@PostMapping("/getTshirt")
	public String searchTShirt(@RequestParam("pref") String pref, @ModelAttribute("TShirt") TShirt tShirt,
			Model model) {
		if (tShirt != null) {
			List<TShirt> tShirtList = tshirtService.sortedTShirts(tShirt, pref);
			model.addAttribute("tshirt", tshirt);
			if (!tShirtList.isEmpty()) {
				model.addAttribute("tShirtList", tShirtList);
			}
			else
				model.addAttribute("tShirtList", "null");
		}
		return "productSearch";
	}

	/**
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/logout")
	public String logoutPage(HttpServletRequest request, Model model) {
		model.addAttribute("user", user);
		return "index";
	}

    /**
     * @return sizelist
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
