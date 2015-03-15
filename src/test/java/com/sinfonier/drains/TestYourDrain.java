package com.sinfonier.drains;


import com.sinfonier.utils.ComponentType;
import com.sinfonier.utils.Runner;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class TestYourDrain {

    @Before
    public void setUp() {
    }


    @Test
    public void testYourDrain() {
        // Instantiate your module
        Map<String, Object> result = Runner.run(ComponentType.DRAIN, YourDrain.class);

        // Code the test conditions
    }
}
