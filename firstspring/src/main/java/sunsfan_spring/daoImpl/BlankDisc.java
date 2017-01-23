package sunsfan_spring.daoImpl;

import java.util.List;

import sunsfan_spring.dao.CompactDisc;

public class BlankDisc implements CompactDisc {
	private String title;
	private String artist;
	private List<String> tracks;

	public void setTitle(String title) {
		this.title = title;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}

	public void playTrack(int trackNum) {
		System.out.println("-Track " + tracks.get(trackNum));
	}

	@Override
	public void play() {
		System.out.println("Playing " + title + " by " + artist);
		for (String track : tracks) {
			System.out.println("-Track " + track);
		}
	}

}
