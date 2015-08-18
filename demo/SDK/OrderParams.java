package com.zulong.sdk.core.param;

import java.util.HashMap;


public class OrderParams extends BaseOrderParams
{
  public static final String EXCHANGE_RATE = "exchangeRate";
  public static final String PRODUCT_ID = "productId";
  public static final String APP_NAME = "appName";
  public static final String ROLE_NAME = "roleName";
  public static final String ROLE_ID = "roleId";
  public static final String LV = "lv";
  public static final String SERVER_NAME = "serverName";
  public static final String BALANCE = "balance";
  public static final String VIP = "vip";
  public static final String PARTY_NAME = "partyName";
  public static final String COMPANY = "company";
  public static final String CURRENCY_NAME = "currencyName";
  public static final String PRODUCT_COUNT = "productCount";

  public OrderParams()
  {
    this.payParamHashMap.put("exchangeRate", new Param("exchangeRate", "", true));
    this.payParamHashMap.put("productId", new Param("productId", "-1", true));
    this.payParamHashMap.put("appName", new Param("appName", "-1", true));
    this.payParamHashMap.put("roleName", new Param("roleName", "", true));
    this.payParamHashMap.put("roleId", new Param("roleId", "", true));
    this.payParamHashMap.put("lv", new Param("lv", "", true));
    this.payParamHashMap.put("serverName", new Param("serverName", "", true));
    this.payParamHashMap.put("balance", new Param("balance", "", true));
    this.payParamHashMap.put("vip", new Param("vip", "", true));
    this.payParamHashMap.put("partyName", new Param("partyName", "", true));
    this.payParamHashMap.put("company", new Param("company", "", true));
    this.payParamHashMap.put("currencyName", new Param("currencyName", "", true));
    this.payParamHashMap.put("productCount", new Param("productCount", "", false));
  }

  public int getExchangeRate()
  {
    return ((Param)this.payParamHashMap.get("exchangeRate")).getIntValue();
  }

  public void setExchangeRate(int exchangeRate)
  {
    ((Param)this.payParamHashMap.get("exchangeRate")).setValue(Integer.toString(exchangeRate));
  }

  public String getProductId()
  {
    return ((Param)this.payParamHashMap.get("productId")).getStringValue();
  }

  public void setProductId(String productId)
  {
    ((Param)this.payParamHashMap.get("productId")).setValue(productId);
  }

  public String getAppName()
  {
    return ((Param)this.payParamHashMap.get("appName")).getStringValue();
  }

  public void setAppName(String appName)
  {
    ((Param)this.payParamHashMap.get("appName")).setValue(appName);
  }

  public String getRoleName()
  {
    return ((Param)this.payParamHashMap.get("roleName")).getStringValue();
  }

  public void setRoleName(String roleName)
  {
    ((Param)this.payParamHashMap.get("roleName")).setValue(roleName);
  }

  public String getRoleId()
  {
    return ((Param)this.payParamHashMap.get("roleId")).getStringValue();
  }

  public void setRoleId(String roleId)
  {
    ((Param)this.payParamHashMap.get("roleId")).setValue(roleId);
  }

  public String getLv()
  {
    return ((Param)this.payParamHashMap.get("lv")).getStringValue();
  }

  public void setLv(String lv)
  {
    ((Param)this.payParamHashMap.get("lv")).setValue(lv);
  }

  public String getServerName()
  {
    return ((Param)this.payParamHashMap.get("serverName")).getStringValue();
  }

  public void setServerName(String serverName)
  {
    ((Param)this.payParamHashMap.get("serverName")).setValue(serverName);
  }

  public String getBalance()
  {
    return ((Param)this.payParamHashMap.get("balance")).getStringValue();
  }

  public void setBalance(String balance)
  {
    ((Param)this.payParamHashMap.get("balance")).setValue(balance);
  }

  public String getVip()
  {
    return ((Param)this.payParamHashMap.get("vip")).getStringValue();
  }

  public void setVip(String vip)
  {
    ((Param)this.payParamHashMap.get("vip")).setValue(vip);
  }

  public String getPartyName()
  {
    return ((Param)this.payParamHashMap.get("partyName")).getStringValue();
  }

  public void setPartyName(String partyName)
  {
    ((Param)this.payParamHashMap.get("partyName")).setValue(partyName);
  }

  public String getCompany()
  {
    return ((Param)this.payParamHashMap.get("company")).getStringValue();
  }

  public void setCompany(String company)
  {
    ((Param)this.payParamHashMap.get("company")).setValue(company);
  }

  public int getProductCount()
  {
    return ((Param)this.payParamHashMap.get("productCount")).getIntValue();
  }

  public void setProductCount(int productCount)
  {
    ((Param)this.payParamHashMap.get("productCount")).setValue(Integer.toString(productCount));
  }

  public String getCurrencyName()
  {
    return ((Param)this.payParamHashMap.get("currencyName")).getStringValue();
  }

  public void setCurrencyName(String currencyName)
  {
    ((Param)this.payParamHashMap.get("currencyName")).setValue(currencyName);
  }

  public HashMap<String, String> addExtraParams(HashMap<String, String> params)
  {
    return params;
  }
}