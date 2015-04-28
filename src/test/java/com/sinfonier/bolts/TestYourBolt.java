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
    	
    	// Java
        //Map<String, Object> result = Runner.run(ComponentType.BOLT, ForocochesUserParsing.class);
    	
    	// Python
        Map<String, Object> result = Runner.runPy(ComponentType.BOLT, LauncherPyBolts.class, "addtimestamp.py");

        // Code the test conditions
        Assert.assertNotNull(result.get("timestamp"));
        Assert.assertEquals("testing get json fields", result.get("fieldfromjson").toString());
    }
}
