package sunsfan_spring.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import sunsfan_spring.aspect.TrackCounter;
import sunsfan_spring.dao.CompactDisc;
import sunsfan_spring.daoImpl.BlankDisc;

@Configuration
@EnableAspectJAutoProxy
public class TrackCounterConfig {
	@Bean
	public CompactDisc eninemSongs() {
		BlankDisc bd = new BlankDisc();
		bd.setTitle("Encore");
		bd.setArtist("Eminem");
		List<String> tracks = new ArrayList<String>();
		tracks.add("love the way you lie");
		tracks.add("not afraid");
		tracks.add("without me");
		tracks.add("the way i am");
		tracks.add("berzerk");
		tracks.add("monster");
		bd.setTracks(tracks);
		return bd;
	}

	@Bean
	public TrackCounter trackCounter() {
		return new TrackCounter();
	}
}
