package com.example.mode;

import java.io.Serializable;

public class TokenInfo implements Serializable{

	private int userId; //用户唯一标识ID
	private String username; //用户登录名
	private String ssoClient; //来自登录请求的某应用系统标识
	private String globalId; //本次登录成功的全局会话sessionId

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSsoClient() {
		return ssoClient;
	}

	public void setSsoClient(String ssoClient) {
		this.ssoClient = ssoClient;
	}

	public String getGlobalId() {
		return globalId;
	}

	public void setGlobalId(String globalId) {
		this.globalId = globalId;
	}


	@Override
	public String toString() {
		return "TokenInfo{" +
				"userId=" + userId +
				", username='" + username + '\'' +
				", ssoClient='" + ssoClient + '\'' +
				", globalId='" + globalId + '\'' +
				'}';
	}
}
