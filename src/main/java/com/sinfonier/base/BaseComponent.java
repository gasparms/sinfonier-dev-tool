package com.sinfonier.base;

import com.sinfonier.json.JSONHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public abstract class BaseComponent extends JSONHandler {

    private Properties prop;
    static Logger logger = Logger.getLogger(BaseComponent.class.getName());
    protected static Logger LOG = Logger.getLogger(BaseComponent.class);

    public BaseComponent(){
        prop = new Properties();
        String propFileName = "module.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        if (inputStream != null) {
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public Logger log(){ return logger; }

    public String getParam(String name){
        return prop.getProperty(name);
    }
}
