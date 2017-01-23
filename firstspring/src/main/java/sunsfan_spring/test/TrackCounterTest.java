package sunsfan_spring.test;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sunsfan_spring.aspect.TrackCounter;
import sunsfan_spring.config.TrackCounterConfig;
import sunsfan_spring.dao.CompactDisc;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackCounterConfig.class)
public class TrackCounterTest {
	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();
	@Autowired
	private CompactDisc cd;
	@Autowired
	private TrackCounter counter;

	@Test
	public void testTrackCounter() {
		cd.playTrack(1);
		cd.playTrack(2);
		cd.playTrack(2);
		cd.playTrack(3);
		cd.playTrack(4);
		cd.playTrack(4);
		cd.playTrack(3);
		cd.playTrack(4);
		cd.playTrack(4);
		cd.playTrack(3);

		 assertEquals(1, counter.getCount(1));
		 assertEquals(2, counter.getCount(2));
		 assertEquals(3, counter.getCount(3));
		 assertEquals(4, counter.getCount(4));
		 System.out.println(counter.getTrackCounter().containsKey(1));
		 System.out.println(counter.getCount(2));
		 System.out.println(counter.getCount(3));
		 System.out.println(counter.getCount(4));
	}
}
