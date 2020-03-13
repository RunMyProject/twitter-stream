package mytwitter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MyTwitterObj implements Comparable {

	private String track;
	
    @JsonProperty("id_str")
    private String id_str;
    
    @JsonProperty("id")
    private Long id;

    @JsonProperty("created_at")
    private Date created_at;

    @JsonProperty("text")
    private String text;

    @JsonProperty("user")
    private User user;

	public MyTwitterObj() {
		// TODO Auto-generated constructor stub
	}

    public int compareTo(Object object) {
        return getCreated_at().compareTo(((MyTwitterObj)object).getCreated_at());
    }

    //
    // For each message, we will need the following:
    	// The message ID
    	// The creation date of the message as epoch value
    	// The text of the message
    	// The author of the message
    	//
    @Override
    public String toString() {
        return track + "#[ id = " + id + ", " + "created_at = " + created_at + ", " +
                "text = "    + text + ", " + "#user = " + user.toString() + " ]";
    }

    public String getId_str() {
		return id_str;
	}
    
	public void setId_str(String id_str) {
		this.id_str = id_str;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

}