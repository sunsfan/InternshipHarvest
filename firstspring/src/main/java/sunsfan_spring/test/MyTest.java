package sunsfan_spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sunsfan_spring.annotation.Cold;
import sunsfan_spring.config.DessertConfig;
import sunsfan_spring.dao.Dessert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DessertConfig.class)
public class MyTest {

	private Dessert dessert;

	@Autowired
	//@Qualifier("cold")
	@Cold
	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}

	@Test
	public void call() {
		dessert.call();
	}
}
