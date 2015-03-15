package com.sinfonier.drains;


import com.sinfonier.base.BaseComponent;

public abstract class BaseSinfonierDrain extends BaseComponent{

    public BaseSinfonierDrain(String file) {}

    public abstract void userprepare();

    public abstract void userexecute();

    public abstract void usercleanup();

    public void tickTupleCase() {
    }

}
