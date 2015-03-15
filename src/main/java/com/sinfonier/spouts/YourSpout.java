package com.sinfonier.spouts;

public class YourSpout extends BaseSinfonierSpout {

    // Class variables

    public YourSpout(String spoutName, String path) {
        super(spoutName, path);
    }

    public void useropen() {

        // TO-DO: Init values. Code here runs once.
        // In Spouts this function is very important. Must get an object than can
        // iterate to use it in usernextTuple()
    }

    public void usernextTuple() {

        // TO-DO: Write code here. This code reads an input tuple by each execution
        // You can use the same functions as in the Bolts to process it.

        // You can use this.getMapper() to get an Jackson mapper to parse a JSON

        // Use this.addField(String key, Object value) or this.setJson(String json)
        // to build the tuple.

        // emit();  // Call emit() always at the end of this method.

    }

    public void userclose() {

        // Close connections, resources.
    }
}
