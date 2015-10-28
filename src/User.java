import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

import org.json.JSONArray;
import org.json.JSONObject;

public class User {

	// User ID
	private String id;
	
	// List of reviews
	private ArrayList<Review> reviews;
	
	//List of friends
	private HashSet<String> friend_ids; 
	
	// Star rating provided by the user
	private Double average_stars;
	
	//Constructor
	public User(JSONObject line)
	{
		setId((String) line.get("user_id"));
		setAverage_stars((Double) line.get("average_stars"));

		//Implicit conversion of JSONArray to ArrayList is not supported
		//Explicitly loop over and add entries
		HashSet<String> list = new HashSet<String>();     
		JSONArray jsonArray = (JSONArray)line.get("friends");
		if (jsonArray != null) { 
			int len = jsonArray.length();
			for (int i=0;i<len;i++){ 
				list.add(jsonArray.get(i).toString());
			} 
		}

		setFriend_ids(list);
		setReviews(new ArrayList<Review>());
	}
	
	// Default constructor
	public User()
	{
		setId(new String());
		setAverage_stars(new Double(0));
		setFriend_ids(new HashSet<String>());
		setReviews(new ArrayList<Review>());
	}

	//Getters and Setters
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Review> getReviews() {
		return reviews;
	}

	public void setReviews(ArrayList<Review> reviews) {
		this.reviews = reviews;
	}

	public Double getAverage_stars() {
		return average_stars;
	}

	public void setAverage_stars(Double average_stars) {
		this.average_stars = average_stars;
	}

	public HashSet<String> getFriend_ids() {
		return friend_ids;
	}

	public void setFriend_ids(HashSet<String> friend_ids) {
		this.friend_ids = friend_ids;
	}

}
