package hello.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@GetMapping("/sayHi")
	public @ResponseBody String sayHello() {
		return "Hello World!!!";
	}

	@GetMapping("/sayBye")
	public @ResponseBody String sayBye() {
		return "Bye World!!!";
	}
}
