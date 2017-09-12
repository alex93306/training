package org.springInAction.soundsystem;

import org.springframework.stereotype.Component;

/**
 * Created by ALEX on 31.07.2017.
 */
@Component
public class SgtPeppers implements CompactDisc {
    private String title = "Sgt. Pepper's Lonely Hearts Club Band";
    private String artist = "The Beatles";
    public String play() {
        return "Playing " + title + " by " + artist;
    }
}
