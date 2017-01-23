package sunsfan_spring.daoImpl;

import org.springframework.stereotype.Component;

import sunsfan_spring.dao.Dessert;
@Component
public class Cake implements Dessert {

	@Override
	public void call() {
		System.out.println("This is a cake!");
	}

}
