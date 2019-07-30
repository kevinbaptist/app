package ovh.ladon.patterns;

import org.junit.jupiter.api.Test;
import ovh.ladon.patterns.behavioral.state.Player;
import ovh.ladon.patterns.behavioral.state.PlayingState;
import ovh.ladon.patterns.behavioral.state.ReadyState;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class StateTest {

	@Test
	void name() {
		final var player = new Player();

		assertFalse(player.isPlaying());

		player.getState().onPlay();
		assertTrue(player.getState() instanceof PlayingState);

		assertEquals(player.getState().onPlay(), "Paused...");
		assertTrue(player.getState() instanceof ReadyState);

		assertEquals(player.getState().onPlay(), "Playing Track 1");


	}
}
