package com.teapink.joke;

import org.junit.Test;

/**
 * Created by Devipriya on 10-Jul-16.
 */
public class JokeTellerTest {

    @Test
    public void testTellJoke() {
        JokeTeller jokeTeller = new JokeTeller();
        assert jokeTeller.tellJoke().length() != 0;
    }
}
