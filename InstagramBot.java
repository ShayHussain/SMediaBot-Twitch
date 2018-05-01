package com.example.selen.stevebot;

import java.io.IOException;
import java.io.File;

import org.brunocvcunha.instagram4j.*;
import org.brunocvcunha.instagram4j.requests.*;

public class InstagramBot extends MediaSkeleton {

    Instagram4j instagram;

    public InstagramBot(String message)
    {
        super(message);
        instagram = Instagram4j.builder().username("username").password("password").build();
        instagram.setup();

    }

    public void connect(){
        instagram.setup();
        try {
            instagram.login();
        }
        catch(IOException jeff) {
            System.out.println("Unexpected login error, IO Exception");
        }
    }

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
