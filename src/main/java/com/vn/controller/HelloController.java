package com.vn.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping("/hello")
	public String hello(@RequestParam Map<String,String> params, Model model) {
		System.out.println(params.get("a"));
		model.addAttribute("title","Don Quijote");
		return "home";
	}
	
	@GetMapping("/suma")
	public String suma(@RequestParam Map<String,String> params, Model model) {
		int a =Integer.parseInt(params.get("a"));
		int b =Integer.parseInt(params.get("b"));
		model.addAttribute("a",a);
		model.addAttribute("b",b);
		model.addAttribute("suma",a+b);
		return "suma";
	}
	
}
