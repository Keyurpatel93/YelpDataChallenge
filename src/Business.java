import org.json.JSONObject;

public class Business {

	private String type;
	
	private String business_id;
	
	private String name;
	
	private String full_address;
	
	private String city;
	
	private String state;
	
	private Double latitude;
	
	private Double longitude;
	
	private Double stars;
	
	private int review_count;
	
	// Default Constructor
	public Business()
	{
		setType(new String());
		setBusiness_id(new String());
		setName(new String());
		setFull_address(new String());
		setCity(new String());
		setStars(new Double(0));
		setLatitude(new Double(0));
		setLongitude(new Double(0));
		setStars(new Double(0));
		setReview_count(0);
	}
	
	public Business(JSONObject line)
	{
		setType((String)line.get("type"));
		setBusiness_id((String)line.get("business_id"));
		setName((String)line.get("name"));
		setFull_address((String)line.get("full_address"));
		setCity((String)line.get("city"));
		setStars((Double)line.get("stars"));
		setLatitude((Double)line.get("latitude"));
		setLongitude((Double)line.get("longitude"));
		setStars((Double)line.get("stars"));
		setReview_count((int)line.get("review_count"));
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFull_address() {
		return full_address;
	}

	public void setFull_address(String full_address) {
		this.full_address = full_address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getStars() {
		return stars;
	}

	public void setStars(Double stars) {
		this.stars = stars;
	}

	public int getReview_count() {
		return review_count;
	}

	public void setReview_count(int review_count) {
		this.review_count = review_count;
	}
}
