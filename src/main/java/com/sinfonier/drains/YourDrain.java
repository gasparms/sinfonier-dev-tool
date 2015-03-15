package com.sinfonier.drains;

public class YourDrain extends BaseSinfonierDrain {

    // Must implement constructor. Do not touch
    public YourDrain(String path) {
        super(path);
    }

    @Override
    public void userprepare() {

        // Initialize your DB Connections or non-serializable classes.
        // This method will be executed once.
    }

    @Override
    public void userexecute() {

        // TO-DO: Write code here. This method will be called every ingoing tuple
    }

    @Override
    public void usercleanup() {
        // Close connections, clean resources
    }

    @Override
    public void tickTupleCase() {
        // Write tickTuple case. This method will be called every tickTuple.
        // Usually is used for flush data, send alarms, window event ...
        // If your module not use this feature leave empty
    }
}
