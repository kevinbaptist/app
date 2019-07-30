package ovh.ladon.patterns.behavioral.state;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private State state;
	private boolean playing;
	private List<String> playlist;
	private int currentTrack;

	public Player() {
		this.state = new ReadyState(this);
		playing = false;
		playlist = new ArrayList<>();
		for (int i = 1; i <= 12; i++) {
			playlist.add("Track " + i);
		}
		currentTrack = 0;
	}

	public String startPlayback() {
		return "Playing " + playlist.get(currentTrack);
	}

	public String nextTrack() {
		currentTrack++;
		if (currentTrack > playlist.size() - 1) {
			currentTrack = 0;
		}
		return "Playing " + playlist.get(currentTrack);
	}

	public String previousTrack() {
		currentTrack--;
		if (currentTrack < 0) {
			currentTrack = playlist.size() - 1;
		}
		return "Playing " + playlist.get(currentTrack);
	}


	public void changeState(State state) {
		this.state = state;
	}

	public State getState() {
		return state;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setCurrentTrackAfterStop() {
		this.currentTrack = 0;
	}

}
