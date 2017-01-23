package sunsfan_spring.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TrackCounter {
	private Map<Integer, Integer> trackCounter = new HashMap<Integer, Integer>();
	
	

	public Map<Integer, Integer> getTrackCounter() {
		return trackCounter;
	}

	@Pointcut("execution(* sunsfan_spring.dao.CompactDisc.playTrack(int))" + "&& args(trackNum)")
	public void trackPlayed(int trackNum) {
	};

	@Before("trackPlayed(trackNum)")
	public void countTrack(int trackNum) {
		int current = getCount(trackNum);
		trackCounter.put(trackNum, current + 1);
	}

	public int getCount(int trackNum) {
		return trackCounter.containsKey(trackNum) ? trackCounter.get(trackNum) : 0;
	}
}
