package com.zulong.sdk.core.param;

public class Param
{
  private String name;
  private String value;
  private boolean notNull;

  public Param(String name, String value, boolean notNull)
  {
    this.name = name;
    this.value = value;
    this.notNull = notNull;
  }

  public String getName()
  {
    return this.name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getStringValue()
  {
    return String.valueOf(this.value);
  }

  public short getShortValue()
  {
    return Short.valueOf(this.value).shortValue();
  }

  public int getIntValue()
  {
    return Integer.valueOf(this.value).intValue();
  }

  public long getLongValue()
  {
    return Long.valueOf(this.value).longValue();
  }

  public float getFloatValue()
  {
    return Float.valueOf(this.value).floatValue();
  }

  public double getDoubleValue()
  {
    return Double.valueOf(this.value).doubleValue();
  }

  public boolean getBooleanValue()
  {
    return Boolean.valueOf(this.value).booleanValue();
  }

  public void setValue(String value)
  {
    this.value = value;
  }

  public boolean isNotNull()
  {
    return this.notNull;
  }

  public void setNotNull(boolean notNull)
  {
    this.notNull = notNull;
  }

  public Object getValue()
  {
    return this.value;
  }
}