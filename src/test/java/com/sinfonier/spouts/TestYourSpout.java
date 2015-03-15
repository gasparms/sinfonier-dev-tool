package com.sinfonier.spouts;


import com.sinfonier.utils.ComponentType;
import com.sinfonier.utils.Runner;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class TestYourSpout {

    @Before
    public void setUp() {
    }


    @Test
    public void testYourSpout() {
        // Instantiate your module
        Map<String, Object> result = Runner.run(ComponentType.SPOUT, YourSpout.class);

        // Code the test conditions
    }
}
