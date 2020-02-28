package com.edugroup.securityandoauth.metier;

public class GoogleOAuth2UserInfo {
	
	private String id;
	private String name;
	private String email;
	private String imageUrl;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	public GoogleOAuth2UserInfo(String id, String name, String email, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.imageUrl = imageUrl;
	}
	
	
	public GoogleOAuth2UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
	

}
