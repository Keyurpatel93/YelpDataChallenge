import org.json.JSONObject;

public class Review {

	private String type;
	
	private String business_id;
	
	private String stars;
	
	private String text;
	
	private String date;
	
	//Constructor
	public Review(JSONObject line)
	{
		setType((String) line.get("type"));		
		setBusiness_id((String) line.get("business_id"));
		setStars((String) line.get("stars"));
		setText((String) line.get("text"));
		setDate((String) line.get("date"));
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

	public String getStars() {
		return stars;
	}

	public void setStars(String stars) {
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
	
	
}
