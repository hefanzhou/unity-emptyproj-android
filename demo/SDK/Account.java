package com.zulong.sdk.core.bean;

public class Account
{
  private String userId = "0";
  private String token = "";
  private String password = "";

  public String getUserId()
  {
    return this.userId;
  }

  public void setUserId(String userId)
  {
    this.userId = userId;
  }

  public String getToken()
  {
    return this.token;
  }

  public void setToken(String token)
  {
    this.token = token;
  }

  public String getPassword()
  {
    return this.password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String toString()
  {
    return "LibAccount [userId=" + this.userId + ", token=" + this.token + ", password=" + this.password + "]";
  }
}