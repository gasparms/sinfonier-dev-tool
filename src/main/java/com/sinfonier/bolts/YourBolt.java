package com.sinfonier.bolts;

public class YourBolt extends BaseSinfonierBolt {

    // Class variables

    // Must implement constructor. Do not touch
    public YourBolt(String path) {
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

        // emit();  // Call emit() always at the end of this method.
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
