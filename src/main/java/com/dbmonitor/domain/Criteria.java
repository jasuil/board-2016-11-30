package com.dbmonitor.domain;

public class Criteria {

  private int page;
  private int perPageNum;
  private int totalCount;

  public int getTotalCount() {
	  return totalCount;
  }

  public void setTotalCount(int totalCount) {
	  this.totalCount = totalCount;
  }

  public Criteria() {
	  this.page = 1;
	  this.perPageNum = 10;
  }

  public void setPage(int page) {

    if (page <= 0) { //if page < 0, then ...
      this.page = 1; 
      return;
    }

    this.page = page;
  }

  public void setPerPageNum(int perPageNum) {// page가 100개 = pagelist 10개, 너무 목록길이가 길 때 자른다

    if (perPageNum <= 0 || perPageNum > 100) {
      this.perPageNum = 10;
      return;
    }

    this.perPageNum = perPageNum;
  }
  
 

  public int getPage() {
    return page;
  }

  // method for MyBatis SQL Mapper -
  public int getPageStart() {

    return (this.page - 1) * perPageNum;
  }

  // method for MyBatis SQL Mapper
  public int getPerPageNum() {

    return this.perPageNum;
  }

  @Override
public String toString() {
	return "Criteria [page=" + page + ", perPageNum=" + perPageNum + ", totalCount=" + totalCount + ","
			+ "getPerPagenum="+getPerPageNum()+"getPageStart="+getPageStart()+"]";
}
}
