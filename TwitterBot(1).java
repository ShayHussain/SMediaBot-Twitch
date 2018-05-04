
import java.io.BufferedReader;
import java.io.IOException;
import twitter4j.*;
import twitter4j.auth.*;
import java.io.InputStreamReader;
import twitter4j.TwitterException;

import java.util.List;


public class TwitterBot {


    private String message;
   
   public TwitterBot()
   {
      message = "You have no message."; 
   }
   public TwitterBot(String message)
   {
      this.message = message;
   }
   
   public void setMessage(String message)
   {
      this.message = message;
   }
   
   public String getMessage()
   {
      return message;
   }

    public void connect(){
        Twitter twitter = TwitterFactory.getSingleton();
        twitter.setOAuthConsumer("bob_burgah", "abc123abc");
        try
        {
         RequestToken requestToken = twitter.getOAuthRequestToken();
        
        AccessToken accessToken = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (null == accessToken) {
            System.out.println("Open the following URL and grant access to your account:");
            System.out.println(requestToken.getAuthorizationURL());
            System.out.print("Enter the PIN(if aviailable) or just hit enter.[PIN]:");
            try
            {
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
            catch(IOException io)
            {
               System.out.println("Pin read line error");
            }
        }
        }
        catch (TwitterException te) 
        {
         System.out.println("Request token error.");
        }
    }



    public void post()
    {
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


    public void displayFeed() {
        Twitter twitter = TwitterFactory.getSingleton();
        try
        {
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());
        }
        }
        catch(TwitterException te)
        {
         System.out.println("Error getting timeline");
        }
    }

}