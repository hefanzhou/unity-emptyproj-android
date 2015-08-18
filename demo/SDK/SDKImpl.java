package com.zulong.sdk.core.open;

import com.zulong.sdk.core.param.OrderParams;


public abstract class SDKImpl extends SDKFoundation
{
  protected abstract void initImpl();

  protected abstract void doLoginImpl();

  protected abstract void doPayImpl(OrderParams paramOrderParams);

  protected abstract void doLogoutImpl();
}