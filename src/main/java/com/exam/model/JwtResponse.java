package com.exam.model;

public class JwtResponse {
	String token;

	public JwtResponse(String token) {
		this.token = token;
	}

	public JwtResponse() {
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
}
