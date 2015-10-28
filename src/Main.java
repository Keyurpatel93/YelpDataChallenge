import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

import org.json.*;



public class Main {

	public static void main (String [] args) throws IOException, InterruptedException{
		
		String userJSONPath = "yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_user.json";
		
		String reviewJSONPath = "yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_review.json";
		
		
		try{	
			BufferedReader br = new BufferedReader(new FileReader(userJSONPath));
		    String line = br.readLine();
		    while(line != null){
		    	
		    	User usr = new User(new JSONObject(line));
		    	
		    	System.out.print("Number of friends" + usr.getFriend_ids().size());
		    	
		    	Hashtable<String, User> frnds = new Hashtable<String, User>();
		    	
		    	BufferedReader br2 = new BufferedReader(new FileReader(reviewJSONPath));
		    	
		    	String line2 = br2.readLine();
		    		
		    	//int count = 0;
		    	
		    	while(line2!=null)
		    	{
		    		//count++;
		    		
		    		Review rev = new Review(new JSONObject(line2));
		    		
		    		if(usr.getId().equals(rev.getUser_id()))
		    		{
		    			usr.getReviews().add(rev);
		    		}
		    		else if(usr.getFriend_ids().contains(rev.getUser_id()))
		    		{
		    		   User frnd;
		    		   
		    		   if(frnds.containsKey(rev.getUser_id()))
		    		   {
		    			   frnd = frnds.get(rev.getUser_id());
		    		   }
		    		   else
		    		   {
		    			   frnd = new User();
		    			   frnd.setId(rev.getUser_id());
		    		   }
		    		   
		    		   frnd.getReviews().add(rev);
		    		   frnds.put(rev.getUser_id(), frnd);
		    		   
		    		}
		    		line2 = br2.readLine();
		    	}
		    	br2.close();
		    	///do processing
		    	line = br.readLine();
			 }
		    br.close();
		} catch (Exception ex) {
			System.out.println("Error Message: " + ex.toString());
		}
		
		
		
	}
	
}
