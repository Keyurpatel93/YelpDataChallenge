import org.json.JSONObject;

public class Review {

	private String type;
	
	private String business_id;
	
	private String user_id;
	
	private float stars;
	
	private String text;
	
	private String date;
	
	//Constructor
	public Review(JSONObject line)
	{
		setType((String) line.get("type"));		
		setBusiness_id((String) line.get("business_id"));
		setUser_id((String) line.get("user_id"));
		///System.out.println(line.get("stars"));
		
		setStars((float) line.getDouble("stars"));
		setText((String) line.get("text"));
		setDate((String) line.get("date"));
	}
	
	//Default constructor
	public Review()
	{
		setType(new String());
		setBusiness_id(new String());
		setUser_id(new String());
		setStars(0);
		setText(new String());
		setDate(new String());
	}

	//Getters and Setters
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}

	public float getStars() {
		return stars;
	}

	public void setStars(float stars) {
		this.stars = stars;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
}
