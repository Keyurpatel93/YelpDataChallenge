import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;


public class YelpDataset {

	private LinkedList<JSONObject> tipList = null;
	private LinkedList<JSONObject> userList = null;
	private LinkedList<JSONObject> businessList = null;
	private LinkedList<JSONObject> checkinList = null;
	private LinkedList<JSONObject> reviewList = null;
	
	
	YelpDataset() {
		tipList = new LinkedList<JSONObject>();
		userList = new LinkedList<JSONObject>();
		businessList = new LinkedList<JSONObject>();
		checkinList = new LinkedList<JSONObject>();
		reviewList = new LinkedList<JSONObject>();
	};
	
	public void loadJSON(String filePath){
		if(filePath.contains("business")){
			businessList = getJSONObjList(filePath);
			System.out.println("Size businessList: " +businessList.size());
		}
		else if (filePath.contains("checkin")){
			checkinList = getJSONObjList(filePath);
			System.out.println("Size checkinList: " + checkinList.size());
		}
		else if (filePath.contains("tip")){
			tipList = getJSONObjList(filePath);
			System.out.println("Size tipList: " + tipList.size());
		}
		else if (filePath.contains("review")){
			reviewList = getJSONObjList(filePath);
			System.out.println("Size reviewList: + " + reviewList.size());
		}
		else if (filePath.contains("user")){
			userList = getJSONObjList(filePath);	
			System.out.println("Size userList: " + userList.size());
		}
	}
	
	private LinkedList<JSONObject> getJSONObjList(final String filePath) {
		int count = 0;
		LinkedList<JSONObject> tmp = new LinkedList<>();
		try{	
			BufferedReader br = new BufferedReader(new FileReader(filePath));  
		    String line = br.readLine();
		    while(line != null){
		    	//System.out.println(line);
		    	count++;
		    	JSONObject obj = new JSONObject(line);	    	
			    tmp.add(obj);
			    line = br.readLine();  
			    
		    }	
		    System.out.println(count);
		} catch (Exception ex) {
			System.out.println("Error Message: " + ex.toString());
		    return null;
		}
		return tmp;
	}
	
	
	public void sizesOfList(){
		//for (JSONObject obj : tipList){
		//	System.out.println(obj.get("user_id"));
		//}
		System.out.println("Size tipList: " + tipList.size());
		System.out.println("Size userList: " + userList.size());
		System.out.println("Size businessList: " +businessList.size());
		System.out.println("Size checkinList: " + checkinList.size());
		System.out.println("Size reviewList: + " + reviewList.size());
		
	}
	
	public ArrayList<FriendsReviews> test(){
		
		ArrayList<FriendsReviews> friendsReviews = new ArrayList<>();
		int countFriendsAboveThreshold = 0;
		for (JSONObject obj : userList){
			//System.out.println(obj.get("friends"));		
			JSONArray arr = obj.getJSONArray("friends");
			FriendsReviews  temp = new FriendsReviews(obj.getString("user_id"));
			for (int i = 0; i < arr.length(); i++) {
				  //System.out.println(arr.getString(i));	
				  temp.table.put(arr.getString(i), new ArrayList<JSONObject>());
			}
			//System.out.println("Size of hashTAble: " + temp.table.size());
			if (temp.table.size()>40)
				countFriendsAboveThreshold++;
			//getFriendsReviews(temp);
			friendsReviews.add(temp);
		}
		System.out.println("Number Users Above Threshold: "+ countFriendsAboveThreshold);
		return friendsReviews;
	}
	
	public void getFriendsReviews(FriendsReviews friendReviews){
		int count = 0;
		String reviewJSONPath = "yelp_dataset_challenge_academic_dataset/yelp_academic_dataset_review.json";
		
		try{	
			BufferedReader br = new BufferedReader(new FileReader(reviewJSONPath));  
		    String line = br.readLine();
		    while(line != null){
		    	//System.out.println(line);
		    	count++;
		    	JSONObject obj = new JSONObject(line);
		    	String reviewUserID = (String) obj.get("user_id");
		    	//System.out.println(reviewUserID);
			    if(friendReviews.table.containsKey(reviewUserID)){
			    	//System.out.println("In table YEs");
			    	ArrayList<JSONObject> exisitingReviews = friendReviews.table.get(reviewUserID);
			    	exisitingReviews.add(obj);
			    	friendReviews.table.put(reviewUserID, exisitingReviews);	    	
			    }
			    line = br.readLine();  		
		    }			    
			    
			   	
		    System.out.println(count);
		} catch (Exception ex) {
			System.out.println("Error Message: " + ex.toString());
		   
		}
		
		Enumeration<String> e = friendReviews.table.keys();
		while(e.hasMoreElements()){
			System.out.println(friendReviews.table.get(e.nextElement().toString()).size());			
			
			}
	
	}
	
}
