// ****************************************** 
// Letter program 
// written by Kristina Saha 
// Program that sets up how a specific letter should be formatted.  
// *******************************************

public class Letter {
		
		   private String sender;
		   private String recipient;
		   private String body;

		  
		  public Letter(String from, String to)
		   {
		      this.sender = from;
			  this.recipient = to;
			  this.body = "";
		   }
		   
		 //Adding a line
		  
		   public void addLine(String line)
		   {
		     body = body + line + "\n"; 
		   }
		   
		   
		 //The text of this letter 
		   
		   public String getText() 
		   {
		    String text = "Dear " + recipient + "\n";
			text += body + "Sincerely," + "\n" + sender + ".";
			return text; 
		   }


	}


