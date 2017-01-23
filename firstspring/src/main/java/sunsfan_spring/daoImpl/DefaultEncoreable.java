package sunsfan_spring.daoImpl;

import org.springframework.stereotype.Component;

import sunsfan_spring.dao.Encoreable;

public class DefaultEncoreable implements Encoreable {

	@Override
	public void performEncore() {
		System.out.println("This is a encore!");
	}

}
