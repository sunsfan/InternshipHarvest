package sunsfan_spring.daoImpl;

import org.springframework.stereotype.Component;

import sunsfan_spring.dao.Performance;

@Component
public class PerformanceImpl implements Performance {


	@Override
	public void perform() {
		System.out.println("This is a perfect performance!");
	}

}
