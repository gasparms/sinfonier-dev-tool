package com.sinfonier.spouts;

import com.sinfonier.base.BaseComponent;

public abstract class BaseSinfonierSpout extends BaseComponent{

    public BaseSinfonierSpout(String spoutName, String xmlFile) {}

    public abstract void useropen();

    public abstract void usernextTuple();

    public abstract void userclose();
}
