package com.sinfonier.bolts;


import com.sinfonier.base.BaseComponent;

public abstract class BaseSinfonierBolt extends BaseComponent {

    // Must implement constructor
    public BaseSinfonierBolt(String path) {
    }

    public abstract void userprepare();

    public abstract void userexecute();

    public abstract void usercleanup();

    public void tickTupleCase() {
    }
}
