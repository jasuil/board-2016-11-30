package com.dbmonitor.domain;

import java.util.Date;

public class orclVO {
	

	private String id;
	private String title;
	private String content;
	private String date;
	private Integer bno;
	private Integer rootid;
	private Integer nodeid;
	private Integer remainday;
	private String place;
	private String column01; 
	private String times;
	
	public String getTimes() {
		return times;
	}


	public void setTimes(String times) {
		this.times = times;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public Integer getRemainday() {
		return remainday;
	}


	public void setRemainday(Integer remainday) {
		this.remainday = remainday;
	}


	public String getColumn01() {
		return column01;
	}


	public void setColumn01(String column01) {
		this.column01 = column01;
	}


	public Integer getRootid() {
		return rootid;
	}


	public void setRootid(Integer rootid) {
		this.rootid = rootid;
	}


	public Integer getNodeid() {
		return nodeid;
	}


	public void setNodeid(Integer nodeid) {
		this.nodeid = nodeid;
	}




	private int viewcnt;
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Integer getBno() {
		return bno;
	}


	public void setBno(Integer bno) {
		this.bno = bno;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String day) {
		this.date = day;
	}


	public int getViewcnt() {
		return viewcnt;
	}


	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}


	
	
	@Override
	public String toString() {
		return "orclVO [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + ", bno=" + bno
				+ ", rootid=" + rootid + ", nodeid=" + nodeid + ", remainday=" + remainday + ", place=" + place
				+ ", column01=" + column01 + ", times=" + times + ", viewcnt=" + viewcnt + "]";
	}

}
