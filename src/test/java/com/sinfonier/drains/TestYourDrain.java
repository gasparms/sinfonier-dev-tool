package com.sinfonier.drains;


import com.sinfonier.spouts.LauncherPySpouts;
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
        
    	// Java
        //Map<String, Object> result = Runner.run(ComponentType.DRAIN, YourDrain.class);
        
        // Python
    	//Map<String, Object> result = Runner.runPy(ComponentType.DRAIN, LauncherPyDrains.class, "pythondrainfile.py");
        Map<String, Object> result = Runner.runPy(ComponentType.DRAIN, LauncherPyDrains.class, "logit.py");

        // Code the test conditions
    }
}
