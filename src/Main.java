import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import org.json.*;



public class Main {

	public static void main (String [] args) throws IOException, InterruptedException{
		
		String userJSONPath = "yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_user.json";
		
		String reviewJSONPath = "yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_review.json";
		
		//String businessJSONPath = "yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_business.json";
		
		
		try{	
			BufferedReader br = new BufferedReader(new FileReader(userJSONPath));
		    String line = br.readLine();
		    while(line != null){
		    	
		    	User usr = new User(new JSONObject(line));
		    	
		    	System.out.println("Number of friends: " + usr.getFriend_ids().size());
		    	
		    	Hashtable<String, User> frnds = new Hashtable<String, User>();
		    	
		    	Hashtable<String, Business> bsnss = new Hashtable<String, Business>();
		    	
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
		    			
		    		//System.out.println(rev.getBusiness_id() + rev.getStars());
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
		    		   
		    		   Business bus;

		    		   
		    			if(bsnss.containsKey(rev.getBusiness_id()))
		    			{
		    				bus = bsnss.get(rev.getBusiness_id());
		    				//System.out.println("Business already exists!");
		    			}
		    			else
		    			{
		    				bus = new Business();
		    				bus.setBusiness_id(rev.getBusiness_id());
		    				
		    			}
		    			
		    			bus.getFriends_ratings().add(rev.getStars());
	    				bsnss.put(rev.getBusiness_id(), bus);
		    			

		    		}
		    		line2 = br2.readLine();
		    	}
		    	br2.close();
		    	///do processing
		    	
		    	Enumeration<String> e = bsnss.keys();
		    	
		    	float sse_avg = 0;
		    	float sse_median = 0;
		    	int count_sse = 0;
		    	
		    	while(e.hasMoreElements())
		    	{
		    		Business bus = bsnss.get(e.nextElement().toString());
		    		ArrayList<Review> rev = usr.getReviews();
		    		for(int i=0; i< rev.size(); i++)
		    		{
		    			Review r = rev.get(i);
		    			if(r.getBusiness_id().equals(bus.getBusiness_id()))
		    			{
		    				
		    				float rating = r.getStars();
		    				float avg_rating = bus.getAverage_friends_ratings();
		    				float median_rating = bus.getMedian_friends_ratings();
		    				System.out.println("User Rating: " + rating + " Average Rating: " + avg_rating + " Median Rating:" + median_rating);
		    				sse_avg += Math.abs(rating - avg_rating);
		    				sse_median += Math.abs(rating - median_rating);
		    				count_sse +=1;
		    			}
		    		}
		    	}
		    	
		    	System.out.println("Total Average Rating Deviation: " + sse_avg + " Count: " + count_sse + " Mean Avg. Rating Deviation: " + sse_avg/count_sse);
		    	System.out.println("Total Median Rating Deviation: " + sse_median + " Count: " + count_sse + " Mean Median Rating Deviation: " + sse_median/count_sse);
		    	
//		    	BufferedReader br3 = new BufferedReader(new FileReader(businessJSONPath));
//		    	
//		    	String line3 = br3.readLine();
//		    		
//
//		    	
//		    	while(line3!=null)
//		    	{
//		    		
//		    		Business bsn = new Business(new JSONObject(line3));
//		    		
//		    		
//		    		   
//		    		
//		    		line3 = br3.readLine();
//		    	}
//		    	br3.close();		    	
		    	
		    	
		    	line = br.readLine();
			 }
		    br.close();
		} catch (Exception ex) {
			System.out.println("Error Message: " + ex.toString());
		}
		
		
		
	}
	
}
