package com.sinfonier.utils;


import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class GetTweet {

    public static void main(String [] args){

        /**
         * To run this sample, edit twitter4j.properties file with your API Keys.
         */

        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setJSONStoreEnabled(true);

        StatusListener listener = new StatusListener(){
            public void onStatus(Status status) {

                System.out.println(TwitterObjectFactory.getRawJSON(status));
            }
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}

            public void onScrubGeo(long l, long l1) {}
            public void onStallWarning(StallWarning stallWarning) {}
            public void onException(Exception ex) {
                ex.printStackTrace();
            }
        };

        TwitterStreamFactory tsf = new TwitterStreamFactory(cb.build());
        TwitterStream twStream = tsf.getInstance();
        twStream.addListener(listener);
        twStream.sample();
    }
}
