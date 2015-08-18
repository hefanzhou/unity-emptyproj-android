package com.zulong.sdk.core.param;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public abstract class BaseOrderParams extends BaseParams
{
  private static final String TAG = BaseOrderParams.class.getName();
  protected HashMap<String, Param> payParamHashMap = new HashMap();
  public static final String ORDER_NUM = "orderNum";
  public static final String PRICE = "price";
  public static final String SERVER_ID = "serverId";
  public static final String PRODUCT_NAME = "productName";
  public static final String PRODUCT_DESC = "productDesc";
  public static final String EXT = "ext";

  protected BaseOrderParams()
  {
    this.payParamHashMap.put("orderNum", new Param("orderNum", "", true));
    this.payParamHashMap.put("price", new Param("price", "-1", true));
    this.payParamHashMap.put("serverId", new Param("serverId", "-1", true));
    this.payParamHashMap.put("productName", new Param("productName", "", true));
    this.payParamHashMap.put("productDesc", new Param("productDesc", "", true));
    this.payParamHashMap.put("ext", new Param("ext", "", true));
  }

  public final HashMap<String, Param> getPayParams()
  {
    addParams(addNecessaryParams());
    addParams(addOptionalParams());
    return this.payParamHashMap;
  }

  private void addParams(ArrayList<Param> necessary)
  {
    if (necessary != null)
    {
      Iterator  it = necessary.iterator();
      while (it.hasNext())
      {
        Param localParam = (Param)it.next();
        if (this.payParamHashMap.containsKey(localParam.getName()))
          return;
        this.payParamHashMap.put(localParam.getName(), localParam);
      }
    }
  }

  public int getPrice()
  {
    return ((Param)this.payParamHashMap.get("price")).getIntValue();
  }

  public void setPrice(int price)
  {
    ((Param)this.payParamHashMap.get("price")).setValue(Integer.toString(price));
  }

  public String getOrderNum()
  {
    return ((Param)this.payParamHashMap.get("orderNum")).getStringValue();
  }

  public void setOrderNum(String orderNum)
  {
    ((Param)this.payParamHashMap.get("orderNum")).setValue(orderNum);
  }

  public int getServerId()
  {
    return ((Param)this.payParamHashMap.get("serverId")).getIntValue();
  }

  public void setServerId(int serverId)
  {
    ((Param)this.payParamHashMap.get("serverId")).setValue(Integer.toString(serverId));
  }

  public String getProductName()
  {
    return ((Param)this.payParamHashMap.get("productName")).getStringValue();
  }

  public void setProductName(String productName)
  {
    ((Param)this.payParamHashMap.get("productName")).setValue(productName);
  }

  public String getProductDesc()
  {
    return ((Param)this.payParamHashMap.get("productDesc")).getStringValue();
  }

  public void setProductDesc(String productDesc)
  {
    ((Param)this.payParamHashMap.get("productDesc")).setValue(productDesc);
  }

  public String getExt()
  {
    return ((Param)this.payParamHashMap.get("ext")).getStringValue();
  }

  public void setExt(String ext)
  {
    if (ext != null)
      ((Param)this.payParamHashMap.get("ext")).setValue(ext);
  }

  public String toString()
  {
    return "OrderParams{payParamHashMap=" + this.payParamHashMap + '}';
  }

  public void validate()
  {
    if (TextUtils.isEmpty(getOrderNum()))
      throw new PayParameterLackException("lack param: orderNum");
    if (getPrice() < 0)
      throw new PayParameterLackException("price is: " + getPrice());
    if (getServerId() < 0)
      throw new PayParameterLackException("serverId is: " + getServerId());
    if (TextUtils.isEmpty(getProductName()))
      throw new PayParameterLackException("productName is empty");
    if (TextUtils.isEmpty(getProductDesc()))
      Log.d(TAG, "productDesc is empty");
    if (TextUtils.isEmpty(getExt()))
      Log.d(TAG, "ext is empty");
  }

  protected ArrayList<Param> addNecessaryParams()
  {
    return new ArrayList();
  }

  protected ArrayList<Param> addOptionalParams()
  {
    return new ArrayList();
  }
}