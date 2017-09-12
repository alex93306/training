package org.springInAction.soundsystem;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ALEX on 06.08.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class)
public class CDPlayerTest {

    @Autowired
    private MediaPlayer player;

    @Autowired
    private CompactDisc cd;

    @Test
    public void chShouldNotBeNull() {
        assertNotNull(cd);
    }

    @Test
    public void play() {
                assertEquals(
                "Playing Sgt. Pepper's Lonely Hearts Club Band" +
                        " by The Beatles\n", player.play()
                );
    }

}
