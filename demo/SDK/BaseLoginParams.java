package com.zulong.sdk.core.param;

public abstract class BaseLoginParams extends BaseParams
{
  protected String channelUid;
  protected String channelToken;

  public void setBasicParams(String channelUid, String channelToken)
  {
    this.channelUid = channelUid;
    this.channelToken = channelToken;
  }

  public String getChannelUid()
  {
    return this.channelUid;
  }

  public String getChannelToken()
  {
    return this.channelToken;
  }

  public String toString()
  {
    return "LoginParams{platUid='" + this.channelUid + '\'' + ", platToken='" + this.channelToken + '\'' + "} " + super.toString();
  }
}