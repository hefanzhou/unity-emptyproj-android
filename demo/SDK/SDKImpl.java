package com.zulong.sdk.core.open;

public abstract class SDKImpl extends SDKFoundation
{
  protected abstract void initImpl();

  protected abstract void doLoginImpl();

  //protected abstract void doPayImpl(OrderParams paramOrderParams);

  protected abstract void doLogoutImpl();
}