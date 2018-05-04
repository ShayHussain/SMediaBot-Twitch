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
   
   /**
   * CONSTRUCTOR - base constructor assigning message to a default statement.
   */
   public MediaSkeleton()
   {
      message = "You have no message";
   }
   
   /*
   * CONSTRUCTOR - assisgns message to the string value in the parameter
   */
   public MediaSkeleton(String message)
   {
      this.message = message;
   }
   
   /*
   * METHOD - sets oauth to the given string value
   */
   public void setOAuth(String oAuth)
   {
      this.oAuth = oAuth;
   }
   
   /*
   * METHOD - returns oauth
   */
   public String getOAuth()
   {
      return oAuth;
   }
   
   /*
   * METHOD - sets message to the given string value
   */
   public void setMessage(String message)
   {
      this.message = message;
   }
	
   /*
   * METHOD - returns the message
   */
   public String getMessage()
   {
      return message;
   }
   
   /*
   * ABSTRACT METHOD - posts the message on a social media platform
   */
   public abstract void post();

   /*
   * ABSTRACT METHOD - logs the user into the given social media platform
   */
   public abstract void connect();
}
