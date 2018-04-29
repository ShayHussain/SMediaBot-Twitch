package com.example.selen.stevebot;

public class AllSeeingBot extends MediaSkeleton{

    TwitterBot twitter;
    InstagramBot instagram;

    public AllSeeingBot(String message) {
        super(message);
        twitter = new TwitterBot(message);
        instagram = new InstagramBot(message);

        connect();
    }

    public void post(){
        twitter.post();
        instagram.post();
    }

    public void connect(){
        twitter.connect();
        instagram.connect();
    }

    
}
