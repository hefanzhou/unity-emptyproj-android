package com.zulong.sdk.core.ui.floatview;

public class FloatViewItem
{
  private String iconName;
  private String text;
  private Runnable runnable;

  public String getIconName()
  {
    return this.iconName;
  }

  public void setIconName(String iconName)
  {
    this.iconName = iconName;
  }

  public String getText()
  {
    return this.text;
  }

  public void setText(String text)
  {
    this.text = text;
  }

  public Runnable getRunnable()
  {
    return this.runnable;
  }

  public void setRunnable(Runnable runnable)
  {
    this.runnable = runnable;
  }

  public void run()
  {
    if (this.runnable != null)
      this.runnable.run();
  }
}