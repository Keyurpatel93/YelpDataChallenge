import java.util.ArrayList;
import java.util.Hashtable;

import org.json.JSONObject;


public class FriendsReviews {

	public String name;
	//public ArrayList<String> friends;
	
	//public ArrayList<JSONObject> reviews;
	public Hashtable<String, ArrayList<JSONObject>> table;
	
	
	FriendsReviews(String Name){
		//reviews = new ArrayList<>();
		//friends = new ArrayList<>();
		table = new Hashtable<>();
		name = Name;
	}
	
	public void addFriend(String name){
		ArrayList<JSONObject> temp = new ArrayList<>();
		table.put(name, temp);
	}
	
	
}
