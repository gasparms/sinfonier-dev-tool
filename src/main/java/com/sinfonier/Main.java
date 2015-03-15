package com.sinfonier;


import com.sinfonier.bolts.YourBolt;
import com.sinfonier.utils.ComponentType;
import com.sinfonier.utils.Runner;

public class Main {
    public static void main(String[] args){

        // Instantiate your module
        Runner.run(ComponentType.BOLT, YourBolt.class);
    }
}
