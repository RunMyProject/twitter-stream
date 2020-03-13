package mytwitter.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@JsonProperty("id_str")
    private String id_str;

	@JsonProperty("id")
    private Long id;

    @JsonProperty("created_at")
    private Date created_at;

    @JsonProperty("name")
    private String name;

    @JsonProperty("screen_name")
    private String screen_name;
    
    @JsonProperty("location")
    private String location;

    @JsonProperty("url")
    private String url;

    @JsonProperty("description")
    private String description;
    
    @JsonProperty("translator_type")
    private String translator_type;
    
    @JsonProperty("protected")
    private String protected_str;
    
    @JsonProperty("verified")
    private String verified;
    
    @JsonProperty("followers_count")
    private String followers_count;
    
    @JsonProperty("friends_count")
    private String friends_count;    
    
    @JsonProperty("listed_count")
	private String listed_count;
    
    @JsonProperty("favourites_count")
	private String favourites_count;
	
    @JsonProperty("statuses_count")
	private String statuses_count;
    
    @JsonProperty("utc_offset")
	private String utc_offset;
	
    @JsonProperty("time_zone")
	private String time_zone;
    
    @JsonProperty("geo_enabled")
	private String geo_enabled;
    
    @JsonProperty("lang")
	private String lang;
	
    @JsonProperty("contributors_enabled")
	private String contributors_enabled;
	
    @JsonProperty("is_translator")
	private String is_translator;
	
    @JsonProperty("profile_background_color")
	private String profile_background_color;
	
    @JsonProperty("profile_background_image_url")
	private String profile_background_image_url;
	
    @JsonProperty("profile_background_image_url_https")
	private String profile_background_image_url_https;
	
    @JsonProperty("profile_background_tile")
	private String profile_background_tile;
	
    @JsonProperty("profile_link_color")
	private String profile_link_color;
	
    @JsonProperty("profile_sidebar_border_color")
	private String profile_sidebar_border_color;
	
    @JsonProperty("profile_sidebar_fill_color")
	private String profile_sidebar_fill_color;
	
    @JsonProperty("profile_text_color")
	private String profile_text_color;
	
    @JsonProperty("profile_use_background_image")
	private String profile_use_background_image;
	
    @JsonProperty("profile_image_url")
	private String profile_image_url;
	
    @JsonProperty("profile_image_url_https")
	private String profile_image_url_https;
	
    @JsonProperty("profile_banner_url")
	private String profile_banner_url;
	
    @JsonProperty("default_profile")
	private String default_profile;
	
    @JsonProperty("default_profile_image")
	private String default_profile_image;
	
    @JsonProperty("following")
	private String following;
	
    @JsonProperty("follow_request_sent")
	private String follow_request_sent;
	
    @JsonProperty("notifications")
	private String notifications;
    
	public User() {
		// TODO Auto-generated constructor stub
	}

	// For each author, we will need the following:
	//	The user ID
	//	The creation date of the user as epoch value
	//	The name of the user
	//	The screen name of the user
	//
    @Override
    public String toString() {
    	return "{id:" + id + ", created_at:" + created_at + ", name:" + name + ", screen_name:" + screen_name + "}";
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTranslator_type() {
		return translator_type;
	}

	public void setTranslator_type(String translator_type) {
		this.translator_type = translator_type;
	}

	public String getProtected_str() {
		return protected_str;
	}

	public void setProtected_str(String protected_str) {
		this.protected_str = protected_str;
	}

	public String getVerified() {
		return verified;
	}

	public void setVerified(String verified) {
		this.verified = verified;
	}

	public String getFollowers_count() {
		return followers_count;
	}

	public void setFollowers_count(String followers_count) {
		this.followers_count = followers_count;
	}

	public String getListed_count() {
		return listed_count;
	}

	public void setListed_count(String listed_count) {
		this.listed_count = listed_count;
	}

	public String getFavourites_count() {
		return favourites_count;
	}

	public void setFavourites_count(String favourites_count) {
		this.favourites_count = favourites_count;
	}

	public String getStatuses_count() {
		return statuses_count;
	}

	public void setStatuses_count(String statuses_count) {
		this.statuses_count = statuses_count;
	}

	public String getUtc_offset() {
		return utc_offset;
	}

	public void setUtc_offset(String utc_offset) {
		this.utc_offset = utc_offset;
	}

	public String getTime_zone() {
		return time_zone;
	}

	public void setTime_zone(String time_zone) {
		this.time_zone = time_zone;
	}

	public String getGeo_enabled() {
		return geo_enabled;
	}

	public void setGeo_enabled(String geo_enabled) {
		this.geo_enabled = geo_enabled;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getContributors_enabled() {
		return contributors_enabled;
	}

	public void setContributors_enabled(String contributors_enabled) {
		this.contributors_enabled = contributors_enabled;
	}

	public String getIs_translator() {
		return is_translator;
	}

	public void setIs_translator(String is_translator) {
		this.is_translator = is_translator;
	}

	public String getProfile_background_color() {
		return profile_background_color;
	}

	public void setProfile_background_color(String profile_background_color) {
		this.profile_background_color = profile_background_color;
	}

	public String getProfile_background_image_url() {
		return profile_background_image_url;
	}

	public void setProfile_background_image_url(String profile_background_image_url) {
		this.profile_background_image_url = profile_background_image_url;
	}

	public String getProfile_background_image_url_https() {
		return profile_background_image_url_https;
	}

	public void setProfile_background_image_url_https(String profile_background_image_url_https) {
		this.profile_background_image_url_https = profile_background_image_url_https;
	}

	public String getProfile_background_tile() {
		return profile_background_tile;
	}

	public void setProfile_background_tile(String profile_background_tile) {
		this.profile_background_tile = profile_background_tile;
	}

	public String getProfile_link_color() {
		return profile_link_color;
	}

	public void setProfile_link_color(String profile_link_color) {
		this.profile_link_color = profile_link_color;
	}

	public String getProfile_sidebar_border_color() {
		return profile_sidebar_border_color;
	}

	public void setProfile_sidebar_border_color(String profile_sidebar_border_color) {
		this.profile_sidebar_border_color = profile_sidebar_border_color;
	}

	public String getProfile_sidebar_fill_color() {
		return profile_sidebar_fill_color;
	}

	public void setProfile_sidebar_fill_color(String profile_sidebar_fill_color) {
		this.profile_sidebar_fill_color = profile_sidebar_fill_color;
	}

	public String getProfile_text_color() {
		return profile_text_color;
	}

	public void setProfile_text_color(String profile_text_color) {
		this.profile_text_color = profile_text_color;
	}

	public String getProfile_use_background_image() {
		return profile_use_background_image;
	}

	public void setProfile_use_background_image(String profile_use_background_image) {
		this.profile_use_background_image = profile_use_background_image;
	}

	public String getProfile_image_url() {
		return profile_image_url;
	}

	public void setProfile_image_url(String profile_image_url) {
		this.profile_image_url = profile_image_url;
	}

	public String getProfile_image_url_https() {
		return profile_image_url_https;
	}

	public void setProfile_image_url_https(String profile_image_url_https) {
		this.profile_image_url_https = profile_image_url_https;
	}

	public String getProfile_banner_url() {
		return profile_banner_url;
	}

	public void setProfile_banner_url(String profile_banner_url) {
		this.profile_banner_url = profile_banner_url;
	}

	public String getDefault_profile() {
		return default_profile;
	}

	public void setDefault_profile(String default_profile) {
		this.default_profile = default_profile;
	}

	public String getDefault_profile_image() {
		return default_profile_image;
	}

	public void setDefault_profile_image(String default_profile_image) {
		this.default_profile_image = default_profile_image;
	}

	public String getFollowing() {
		return following;
	}

	public void setFollowing(String following) {
		this.following = following;
	}

	public String getFollow_request_sent() {
		return follow_request_sent;
	}

	public void setFollow_request_sent(String follow_request_sent) {
		this.follow_request_sent = follow_request_sent;
	}

	public String getNotifications() {
		return notifications;
	}

	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}
	
}
