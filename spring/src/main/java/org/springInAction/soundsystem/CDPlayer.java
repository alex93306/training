package org.springInAction.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ALEX on 06.08.2017.
 */
@Component
public class CDPlayer implements MediaPlayer {
    private CompactDisc cd;
    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }
    public String play() {
        return cd.play();
    }
}