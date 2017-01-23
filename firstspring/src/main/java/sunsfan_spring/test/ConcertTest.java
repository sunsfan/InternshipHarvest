package sunsfan_spring.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sunsfan_spring.aspect.Audience;
import sunsfan_spring.config.ConcertConfig;
import sunsfan_spring.dao.Encoreable;
import sunsfan_spring.dao.Performance;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class ConcertTest {
	@Autowired
	private Performance pi;
	@Autowired
	private Audience audience;

	@Test
	public void perform() {
		pi.perform();
		Encoreable e = (Encoreable) pi;
		e.performEncore();
	}
}
