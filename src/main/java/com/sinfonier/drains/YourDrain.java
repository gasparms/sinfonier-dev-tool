package com.sinfonier.drains;

public class YourDrain extends BaseSinfonierDrain {


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

        // This method will be executed every ingoing tuple
    }

    @Override
    public void usercleanup() {
        // Close connections, clean resources
    }

    @Override
    public void tickTupleCase() {
        super.tickTupleCase();
    }
}
