package com.edugroupe.firstspringsecurity.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {


		@GetMapping(value="")
		@ResponseBody
		public String hello() {
			return "<h2>Bienvenue admin</h2>";
		}
}
