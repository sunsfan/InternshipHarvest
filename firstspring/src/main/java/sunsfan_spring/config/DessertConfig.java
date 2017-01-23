package sunsfan_spring.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import sunsfan_spring.annotation.Cold;
import sunsfan_spring.dao.Dessert;
import sunsfan_spring.daoImpl.Cake;
import sunsfan_spring.daoImpl.Cookies;
import sunsfan_spring.daoImpl.IceCream;
import sunsfan_spring.daoImpl.Popsicle;

@Configuration
// @ComponentScan(basePackages = "sunsfan_spring")
public class DessertConfig {

	@Bean
	@Primary
	@Qualifier("soft")
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Dessert cake() {
		return new Cake();
	}

	@Bean
	@Qualifier("crispy")
	public Dessert cookies() {
		return new Cookies();
	}

	@Bean
	//@Primary
	@Qualifier("cold")
	public Dessert iceCream() {
		return new IceCream();
	}

	@Bean
	@Qualifier("cold")
	@Cold
	public Dessert popsicle() {
		return new Popsicle();
	}
}
