import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import org.json.*;



public class Main {

	public static void main (String [] args) throws IOException, InterruptedException{
		System.out.println("Hello");
		

		
		String businessJSONPath = "yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_business.json";
		String userJSONPath = "yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_user.json";
		//String userJSONPath = "yelp_dataset_challenge_academic_dataset/usersSubset.json";
		
		String tipJSONPath = "yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_tip.json";
		String checkinJSONPath = "yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_checkin.json";
		String reviewJSONPath = "yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_review.json";
		
		
		YelpDataset dataSet = new YelpDataset();
		//dataSet.loadJSON(businessJSONPath);
		dataSet.loadJSON(userJSONPath);
		//dataSet.loadJSON(checkinJSONPath);
		//dataSet.loadJSON(reviewJSONPath);
		//dataSet.loadJSON(tipJSONPath);
		dataSet.test();
	
		
		ArrayList<FriendsReviews> friendReviews = dataSet.test();
		
		System.out.println("Size of FriendsReviews: " + friendReviews.size()) ;
		
		//System.out.println(friendReviews.get(1).table.size());
		
		
		LinkedList<JSONObject> tmp = new LinkedList<>();
		int count = 0;
		try{	
			BufferedReader br = new BufferedReader(new FileReader(reviewJSONPath));  
		    String line = br.readLine();
		    while(line != null){
		    	//System.out.println(line);
		    	count++;
		    	JSONObject obj = new JSONObject(line);
		    	String reviewUserID = (String) obj.get("user_id");
		    	
			    for(FriendsReviews friend :friendReviews){
			    	if(friend.table.containsKey(reviewUserID)){
			    		//friend.table.put(reviewUserID, friend.table.get(reviewUserID).add(obj));
			    		//friend.table.put(reviewUserID, friend.table.get(reviewUserID).add(obj));
			    	
			    	}
			    		
			    }
			    
			    
			    line = br.readLine();  
			    
		    }	
		    System.out.println(count);
		} catch (Exception ex) {
			System.out.println("Error Message: " + ex.toString());
		   
		}
		
		
		
	}
	
}
