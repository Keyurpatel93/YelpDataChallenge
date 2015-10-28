import java.util.ArrayList;

import org.json.JSONObject;

public class User {

	// User ID
	private String id;
	
	// List of reviews
	private ArrayList<Review> reviews;
	
	// Star rating provided by the user
	private String average_stars;
	
	//Constructor
	public User(JSONObject line)
	{
		setId((String) line.get("user_id"));
		setAverage_stars((String) line.get("average_stars"));
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

	public String getAverage_stars() {
		return average_stars;
	}

	public void setAverage_stars(String average_stars) {
		this.average_stars = average_stars;
	}

}
