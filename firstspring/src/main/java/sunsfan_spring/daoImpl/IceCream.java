package sunsfan_spring.daoImpl;

import org.springframework.stereotype.Component;

import sunsfan_spring.annotation.Cold;
import sunsfan_spring.dao.Dessert;
@Component
//@Qualifier("cold")
public class IceCream implements Dessert {
	@Override
	public void call() {
		System.out.println("This is an icecream!");
	}
}
