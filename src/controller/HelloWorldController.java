package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;;

@Controller
public class HelloWorldController {
	public String message = "Hello World, Spring 3.0!";
	@RequestMapping("/hello")
	public ModelAndView helloWorld()
	{
		System.out.println(message);
		return new ModelAndView("hello", "message", message);
	}
}
