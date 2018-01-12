package com.dbmonitor.persistance;

import java.util.List;

import com.dbmonitor.domain.Criteria;
import com.dbmonitor.domain.SearchCriteria;
import com.dbmonitor.domain.boardVO;



public interface boardDAO {
	 public void create(boardVO vo) throws Exception;

	  public boardVO read(Integer id) throws Exception;

	  public void update(boardVO vo) throws Exception;

	  public void delete(Integer bno) throws Exception;

	  public List<boardVO> listAll(SearchCriteria cri) throws Exception;

	  public List<boardVO> listPage(int page) throws Exception;
	  
	
	  public List<boardVO> listCriteria(Criteria cri) throws Exception;

	    public int countPaging() throws Exception;
	    
	    public int searchCountPaging(SearchCriteria cri) throws Exception;
	  
	  //use for dynamic sql
	  
	/*  public List<boardVO> listSearch(SearchCriteria cri)throws Exception;
	  
	  public int listSearchCount(SearchCriteria cri)throws Exception; */

}
