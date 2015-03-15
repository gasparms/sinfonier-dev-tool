package com.sinfonier.utils;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Runner {

    public static void run(ComponentType type, Class _class){
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

            o.getClass().getDeclaredMethod("userexecute");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }



}
