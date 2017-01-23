package sunsfan_spring.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import sunsfan_spring.daoImpl.HomeController;

public class HomeControllerTest {
	@Test
	public void testHomePage() throws Exception {
		HomeController hc = new HomeController();
		// assertEquals("home", hc.home());
		// System.out.println(hc.home());
		MockMvc mockMvc = standaloneSetup(hc).build();
		mockMvc.perform(get("/")).andExpect(view().name("home"));
	}

}
