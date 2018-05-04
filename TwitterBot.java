/**
* author: Maxim Tsoy
* tester: Haram Kim
*/

package com.example.selen.stevebot;
import java.io.BufferedReader;
import java.io.IOException;
import twitter4j.*;
import twitter4j.auth.*;
import java.io.InputStreamReader;
import twitter4j.TwitterException;

import java.util.List;


public class TwitterBot extends MediaSkeleton {

    /**
    *  CONSTRUCTOR - assigns message to the message string in the MediaSkeleton class
    */
    public TwitterBot(String message){
        super(message);
    }
    
    /**
    * METHOD - logs the user into their twitter account through OAuth. 
    * Built from example code from the Twitter4j website
    */
    public void connect(){
        Twitter twitter = TwitterFactory.getSingleton();
        twitter.setOAuthConsumer("[consumer key]", "[consumer secret]");
        RequestToken requestToken = twitter.getOAuthRequestToken();
        AccessToken accessToken = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (null == accessToken) {
            System.out.println("Open the following URL and grant access to your account:");
            System.out.println(requestToken.getAuthorizationURL());
            System.out.print("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
            String pin = br.readLine();
            try{
                if(pin.length() > 0){
                    accessToken = twitter.getOAuthAccessToken(requestToken, pin);
                }else{
                    accessToken = twitter.getOAuthAccessToken();
                }
            } catch (TwitterException te) {
                if(401 == te.getStatusCode()){
                    System.out.println("Unable to get the access token.");
                }else{
                    te.printStackTrace();
                }
            }
        }
    }

    /**
    *  METHOD - posts the message onto the user's twitter account.
    * Built from example code found on the Twitter4j website
    */
    public void post(){
        Twitter twitter = TwitterFactory.getSingleton();
        StatusUpdate jimmy = new StatusUpdate(message);
        try {
            Status status = twitter.updateStatus(jimmy);
            System.out.println("Successfully updated the status to [" + status.getText() + "].");
        }
        catch(TwitterException te) {
            if(401 == te.getStatusCode()){
                System.out.println("Unable to update status");
            }
            else{
                te.printStackTrace();
            }
        }

    }

    /**
    * METHOD - displays the user's feed on the device.
    */
    public void displayFeed() {
        Twitter twitter = TwitterFactory.getSingleton();
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());
        }
    }

}
