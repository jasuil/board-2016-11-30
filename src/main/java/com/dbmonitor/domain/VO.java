// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   VO.java

package com.dbmonitor.domain;


public class VO
{

    public VO()
    {
    }

    public void VO()
    {
    }

    public String getTimeDiff()
    {
        return timeDiff;
    }

    public void setTimeDiff(String timeDiff)
    {
        this.timeDiff = timeDiff;
    }

    public double getDelta()
    {
        return delta;
    }

    public void setDelta(double delta)
    {
        this.delta = delta;
    }

    public int getThreadTime()
    {
        return ThreadTime;
    }

    public void setThreadTime(int threadTime)
    {
        ThreadTime = threadTime;
    }

    public int getDate()
    {
        return date;
    }

    public void setDate(int date)
    {
        this.date = date;
    }

    public String getRuleNm()
    {
        return ruleNm;
    }

    public void setRuleNm(String ruleNm)
    {
        this.ruleNm = ruleNm;
    }

    public String getTimes()
    {
        return times;
    }

    public void setTimes(String times)
    {
        this.times = times;
    }

    public double getValue()
    {
        return value;
    }

    public void setValue(double value)
    {
        this.value = value;
    }

    public String getSqls()
    {
        return sqls;
    }

    public void setSqls(String sqls)
    {
        this.sqls = sqls;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public String toString()
    {
        return (new StringBuilder("VO [times=")).append(times).append(", timeDiff=").append(timeDiff).append(", sqls=").append(sqls).append(", ruleNm=").append(ruleNm).append(", number=").append(number).append(", value=").append(value).append(", delta=").append(delta).append(", date=").append(date).append(", ThreadTime=").append(ThreadTime).append("]").toString();
    }

    private String times;
    private String timeDiff;
    private String sqls;
    private String ruleNm;
    private int number;
    private double value;
    private double delta;
    private int date;
    private int ThreadTime;
}
