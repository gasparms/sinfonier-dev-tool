package com.sinfonier.json;


import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public abstract class JSONHandler {

    static final Logger log = Logger.getLogger(JSONHandler.class.getName());
    private Map<String, Object> json = new HashMap<String, Object>();
    private ObjectMapper mapper;

    public JSONHandler() {
        mapper = new ObjectMapper();
        URL url = Resources.getResource("input.json");
        String input = null;
        try {
            input = Resources.toString(url, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.json = mapper.readValue(input, new TypeReference<Map<String, Object>>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Add <key,value> to current tuple.
     *
     * @param key
     * @param value
     */
    public void addField(String key, Object value) {
        if (key.indexOf(".") >= 0) {
            addNestedField(key, value);
        } else {
            json.put(key, value);
        }

        log.info("Added field " + key + ":" + value);
    }

    private void addNestedField(String key, Object value) {
        String[] parts = key.split("\\.");
        Map<String, Object> jsonCopy = json;
        for (int i = 0; i < parts.length - 1; i++) {
            if (jsonCopy.get(parts[i]) == null) {
                jsonCopy.put(parts[i], new HashMap<String, Object>());
            }
            jsonCopy = (Map<String, Object>) jsonCopy.get(parts[i]);
        }
        jsonCopy.put(parts[parts.length - 1], value);
    }

    /**
     * Get field in the tuple. Use . to access nested fields. (i.e. : user.lang)
     *
     * @param key
     * @return
     */
    public Object getField(String key) {
        if (key.indexOf(".") >= 0) {
            return getNestedField(key);
        }
        return json.get(key);
    }


    @SuppressWarnings("unchecked")
    private Object getNestedField(String key) {
        String[] parts = key.split("\\.");
        Map<String, Object> value = json;
        for (int i = 0; i < parts.length - 1; i++) {
            value = (Map<String, Object>) value.get(parts[i]);
        }
        return value.get(parts[parts.length - 1]);
    }


    public void removeField(String key) {
        if (key.indexOf(".") >= 0) {
            removeNestedField(key);
        }
        json.remove(key);

        log.info("Rmove field with key " + key);
    }

    /**
     * Divide key in parts (split by '.'), access to nested documents and finally removes the key.
     *
     * @param key Name of key.
     * @return Value of given key in tuple.
     */
    @SuppressWarnings("unchecked")
    private Object removeNestedField(String key) {
        String[] parts = key.split("\\.");
        Map<String, Object> value = json;
        for (int i = 0; i < parts.length - 1; i++) {
            value = (Map<String, Object>) value.get(parts[i]);
        }
        return value.remove(parts[parts.length - 1]);
    }


    /**
     * Check if field with key exists in the tuple.
     *
     * @param key Key to check
     * @return {@code true} if exists or {@code false} in other case.
     */
    public boolean existsField(String key) {
        return json.containsKey(key);
    }


    /**
     * Simulate emit method.
     */
    public void emit() {

        String jsonstr = "";
        try {
            jsonstr = mapper.writeValueAsString(this.json);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        log.info("Result tuple: " + jsonstr);
    }

    /**
     * Replace or set current tuple for given json.
     *
     * @param json Json to set or replace.
     */
    public void setJson(String json) {
        try {
            this.json = mapper.readValue(json, new TypeReference<Map<String, Object>>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Replace current tuple by given tuple. Useful if you make deep changes in tuple.
     * 
     * @param json Tuple to set up.
     */
    public void setJSon(Map<String, Object> json) {
        this.json = json;
    }

    /**
     * Get Jackson mapper.
     *
     * @return
     */
    public ObjectMapper getMapper() {
        return mapper;
    }


    /**
     * Get current tuple.
     *
     * @return
     */
    public Map<String, Object> getJson() {
        return json;
    }

    /**
     * Get current tuple in raw json format.
     *
     * @return
     */
    public String getRawJson() {
        String jsonstr = "";
        try {
            jsonstr = mapper.writeValueAsString(this.json);
        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonstr;
    }
}
