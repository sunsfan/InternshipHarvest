package sunsfan_spring.daoImpl;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/spitter")
public class SpitterController {
	@RequestMapping(value = "/register", method = GET)
	public String showRegisterationForm() {
		return "registerForm";
	}
}
