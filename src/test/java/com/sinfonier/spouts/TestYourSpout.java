package com.sinfonier.spouts;


import com.sinfonier.utils.ComponentType;
import com.sinfonier.utils.Runner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class TestYourSpout {

    @Before
    public void setUp() {
    }


    @Test
    public void testYourSpout() {
        
    	// Java
        //Map<String, Object> result = Runner.run(ComponentType.SPOUT, YourSpout.class);
        
        // Python
    	//Map<String, Object> result = Runner.runPy(ComponentType.SPOUT, LauncherPySpouts.class, "pythonspoutfile.py", <Number of Emissions>);
    	// <Number of Emissions> = 0 means infinite
        Map<String, Object> result = Runner.runPy(ComponentType.SPOUT, LauncherPySpouts.class, "testpyspout.py", 3);

        // Code the test conditions
    }
}
