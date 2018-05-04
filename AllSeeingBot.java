/**
* author: Maxim Tsoy
* tester: Haram Kim
*/

package com.example.selen.stevebot;

public class AllSeeingBot extends MediaSkeleton{

    TwitterBot twitter; // createes the TwitterBot object
    InstagramBot instagram; // creates the InstagramBot object

    /**
    * CONSTRUCTOR - initializes the twitter and instagram objects, assings the message to the super constructor, and runs the connect methods 
    * for the Instagram and Twitter bots. 
    */
    public AllSeeingBot(String message) {
        super(message);
        twitter = new TwitterBot(message);
        instagram = new InstagramBot(message);

        connect();
    }

    /**
    * METHOD - runs the post methods for the twitter and instagram objects.
    */
    public void post(){
        twitter.post();
        instagram.post();
    }

    /**
    * METHOD - runs the connect methods for the twitter and instagram objects.
    */
    public void connect(){
        twitter.connect();
        instagram.connect();
    }

    
}
