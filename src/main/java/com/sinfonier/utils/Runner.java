package com.sinfonier.utils;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Runner {

    public static Map<String, Object> run(ComponentType type, Class _class) {
        try {
            Constructor constructor;
            Object o;
            switch (type){
                case SPOUT:
                    constructor = _class.getConstructor(String.class, String.class);
                    o = constructor.newInstance("", "");
                    o.getClass().getDeclaredMethod("useropen").invoke(o);
                    o.getClass().getDeclaredMethod("usernextTuple").invoke(o);
                    o.getClass().getDeclaredMethod("userclose").invoke(o);
                    break;
                case BOLT:
                case DRAIN:
                default:
                    constructor = _class.getConstructor(String.class);
                    o = constructor.newInstance("");
                    o.getClass().getDeclaredMethod("userprepare").invoke(o);
                    o.getClass().getDeclaredMethod("userexecute").invoke(o);
                    o.getClass().getDeclaredMethod("usercleanup").invoke(o);
                    break;
            }

            return (Map<String, Object>) o.getClass().getSuperclass().getSuperclass().getSuperclass().getDeclaredMethod("getJson").invoke(o);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public static Map<String, Object> runPy(ComponentType type, Class _class, String pythonFile) {
        try {
            Constructor constructor;
            Object o;
            switch (type){
                case SPOUT:
                	System.out.println("Set parameter 'iterations' (<Number of Emissions>) if you are testing Spouts. It's mandatory.");
                    break;
                case BOLT:
                case DRAIN:
                default:
                    constructor = _class.getConstructor(String.class, String.class);
                    o = constructor.newInstance("", pythonFile);
                    o.getClass().getDeclaredMethod("run").invoke(o);
                    return (Map<String, Object>) o.getClass().getDeclaredMethod("getJson").invoke(o);
            }
            
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    public static Map<String, Object> runPy(ComponentType type, Class _class, String pythonFile, int iterations) {
        try {
            Constructor constructor;
            Object o;
            String iter = Integer.toString(iterations);
            switch (type){
                case SPOUT:
                    constructor = _class.getConstructor(String.class, String.class, String.class);
                    o = constructor.newInstance("", pythonFile, iter);
                    o.getClass().getDeclaredMethod("run").invoke(o);
                    return (Map<String, Object>) o.getClass().getDeclaredMethod("getJson").invoke(o);
                case BOLT:
                case DRAIN:
                default:
                    System.out.println("Remove parameter 'iterations' (<Number of Emissions>) if you are testing Bolts or Drains. That param is just for Spouts.");
                    break;
            }

            
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }


}
