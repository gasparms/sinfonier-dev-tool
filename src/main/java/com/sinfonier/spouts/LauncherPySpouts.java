package com.sinfonier.spouts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * PythonBolt Class.
 */
public class LauncherPySpouts {
	
	static final String MarkEmit = "EMIT:";
	static final String MarkKill = "-ModuleFinishMark-";
	
	private String pythonFilePath = "";
	private String moduleProperties = "";
	private String jsonInput = "";
	private Map<String, Object> resultmap = new HashMap<String, Object>();
	private String numOfIterations = "0";

    public LauncherPySpouts(String xmlFile, String pythonFile, String numIt) {
        
    	pythonFilePath = getClass().getProtectionDomain().getCodeSource().getLocation().getPath().replaceAll("target.*", "multilang/python/")+pythonFile;
    	moduleProperties = getClass().getClassLoader().getResource("module.properties").getPath();
    	jsonInput = getClass().getClassLoader().getResource("input.json").getPath();
    	numOfIterations = numIt;
    	
    }

    public Map<String, Object> getJson() {
        return resultmap;
    }
    
    public void run() {
    	
    	ProcessBuilder builder = new ProcessBuilder("python2.7", pythonFilePath, moduleProperties, jsonInput, numOfIterations);
    	try {
			Process _subprocess = builder.start();
			BufferedReader reader = new BufferedReader(new InputStreamReader(_subprocess.getInputStream()));
	    	String line = null;
	    	String emittedjson = "{}";
	    	while (true) {
	    		line = reader.readLine();
	    		if (line != null) {
		    		if (line.startsWith(MarkEmit)){
		    			emittedjson = line.replace(MarkEmit, "");
		    		}
		    		else if (line.equals(MarkKill)){
		    			_subprocess.destroy();
		    			break;
		    		}
		    		else {
		    			System.out.println(line);
		    		}

	    		}
	    	}
	    	
	    	try {
				resultmap = new ObjectMapper().readValue(emittedjson, HashMap.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    	
		} catch (IOException e) {
			e.printStackTrace();
		}

    }

}