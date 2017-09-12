package org.springInAction.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ALEX on 31.07.2017.
 */
@Configuration
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    @Bean
    public MediaPlayer mediaPlayer() {
        return new CDPlayer(sgtPeppers());
    }
}