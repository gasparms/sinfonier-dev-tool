package com.sinfonier.bolts;


import com.sinfonier.utils.ComponentType;
import com.sinfonier.utils.Runner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class TestYourBolt {

    @Before
    public void setUp() {
    }


    @Test
    public void testYourBolt() {
        // Instantiate your module
        Map<String, Object> result = Runner.run(ComponentType.BOLT, MultiplyBolt.class);

        // Code the test conditions
        Assert.assertNotNull(result.get("result"));
        Assert.assertEquals(Integer.parseInt(result.get("result").toString()), 2);
    }
}
