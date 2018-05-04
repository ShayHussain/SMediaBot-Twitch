/**
* author: Maxim Tsoy
* tester: Haram Kim
*/

package com.example.selen.stevebot;

import java.io.IOException;
import java.io.File;

import org.brunocvcunha.instagram4j.*;
import org.brunocvcunha.instagram4j.requests.*;

public class InstagramBot extends MediaSkeleton {

    Instagram4j instagram; // set up the Instagram object for use in the methods

    /**
    * CONSTRUCTOR - initializes the instagram object and assigns the parameter to the string message
    */
    public InstagramBot(String message)
    {
        super(message);
        instagram = Instagram4j.builder().username("username").password("password").build();
        instagram.setup();

    }

    /**
    * METHOD - connects the user and logs them into their instagram account.
    */
    public void connect(){
        instagram.setup();
        try {
            instagram.login();
        }
        catch(IOException jeff) {
            System.out.println("Unexpected login error, IO Exception");
        }
    }

    /**
    * METHOD - posts a default image and the message to the user's instagram account
    */
    public void post(){
        try {
            instagram.sendRequest(new InstagramUploadPhotoRequest(
                    new File("pizza_time.jpg"),
                    message));
        }
        catch(IOException e) {
            System.out.println("Unexpected post error");
        }

    }
}
