/**
 * 
 */

/**
 * @author Maxim Tsoy
 *
 */

public abstract class MediaSkeleton
{	
   protected String oAuth;
   protected String message;
   
   public MediaSkeleton()
   {
      oAuth = "You have no oAuth";
      message = "You suck"; 
   }
   
   public MediaSkeleton(String oAuth, String message)
   {
      this.oAuth = oAuth;
      this.message = message;
   }
   
   public void setOAuth(String oAuth)
   {
      this.oAuth = oAuth;
   }
   
   public String getOAuth()
   {
      return oAuth;
   }
   
   public void setMessage(String message)
   {
      this.message = message;
   }
   
   public String getMessage()
   {
      return message;
   }
   
	public abstract void post();
	
	public abstract void connect();
}
