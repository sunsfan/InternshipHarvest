package sunsfan_spring.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import org.springframework.web.servlet.view.InternalResourceView;

import sunsfan_spring.dao.SpittleRepo;
import sunsfan_spring.daoImpl.SpitterController;
import sunsfan_spring.daoImpl.Spittle;
import sunsfan_spring.daoImpl.SpittleController;

public class SpittleControllerTest {
	/*
	 * @Test public void shouldShowRecentSpittles() throws Exception{
	 * List<Spittle> expectedSpittles = createSpittleList(20);
	 * 
	 * SpittleRepo spittleRepo = mock(SpittleRepo.class);
	 * when(spittleRepo.findSpittles(1000000, 20)).thenReturn(expectedSpittles);
	 * SpittleController controller = new SpittleController(spittleRepo);
	 * MockMvc mockMvc = standaloneSetup(controller) .setSingleView(new
	 * InternalResourceView("/WEB-INF/views/spttiles.jsp")).build();
	 * mockMvc.perform(get("/spittles")).andExpect(view().name("spittles"))
	 * .andExpect(model().attributeExists("spittleList"))
	 * .andExpect(model().attribute("spittleList", expectedSpittles));
	 * 
	 * }
	 */
	/*
	 * @Test public void shouldShowPagedSpittles() throws Exception{
	 * List<Spittle> expectedSpittles = createSpittleList(50);
	 * 
	 * SpittleRepo spittleRepo = mock(SpittleRepo.class);
	 * when(spittleRepo.findSpittles(238900, 50)).thenReturn(expectedSpittles);
	 * SpittleController controller = new SpittleController(spittleRepo);
	 * MockMvc mockMvc = standaloneSetup(controller) .setSingleView(new
	 * InternalResourceView("/WEB-INF/views/spttiles.jsp")).build();
	 * mockMvc.perform(get("/spittles?max=238900&count=50")).andExpect(view().
	 * name("spittles")) .andExpect(model().attributeExists("spittleList"))
	 * .andExpect(model().attribute("spittleList", expectedSpittles));
	 * 
	 * }
	 */
	/*
	 * @Test public void testSpittle() throws Exception{ Spittle expectedSpittle
	 * = new Spittle("hello", new Date()); SpittleRepo spittleRepo =
	 * mock(SpittleRepo.class);
	 * when(spittleRepo.findOne(123456)).thenReturn(expectedSpittle);
	 * SpittleController controller = new SpittleController(spittleRepo);
	 * MockMvc mockMvc = standaloneSetup(controller) .build();
	 * mockMvc.perform(get("/spittles/show?spittle_id=123456")).andExpect(view()
	 * .name("spittle")) .andExpect(model().attributeExists("spittle"))
	 * .andExpect(model().attribute("spittle", expectedSpittle));
	 * 
	 * }
	 */
	/*
	 * @Test public void testSpittle() throws Exception{ Spittle expectedSpittle
	 * = new Spittle("hello", new Date()); SpittleRepo spittleRepo =
	 * mock(SpittleRepo.class);
	 * when(spittleRepo.findOne(123456)).thenReturn(expectedSpittle);
	 * SpittleController controller = new SpittleController(spittleRepo);
	 * MockMvc mockMvc = standaloneSetup(controller) .build();
	 * mockMvc.perform(get("/spittles/123456")).andExpect(view().name("spittle")
	 * ) .andExpect(model().attributeExists("spittle"))
	 * .andExpect(model().attribute("spittle", expectedSpittle));
	 * 
	 * }
	 */
	@Test
	public void testShowRegisterForm() throws Exception {
		SpitterController controller = new SpitterController();
		MockMvc mockMvc = standaloneSetup(controller).build();
		mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
	}

	private static List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("Spittle" + i, new Date()));
		}
		return spittles;
	}
}
