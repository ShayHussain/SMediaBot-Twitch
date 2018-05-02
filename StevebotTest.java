public class StevebotTest
{
   public static void main(String args[])
   {
      TwitterBot twitter = new TwitterBot("I have posted from a java project, praise me");
      //Instagrambot instagram = new Instagrambot("I have posted from a java project, praise me");
      //AllSeeingBot allbois = new AllSeeingBot("I have posted from a java project, praise me");
      
      twitter.connect();
      //instagram.connect();
      //allbois.connect();
      
      twitter.post();
      //instagram.post();
      //allbois.post();
   }
}
