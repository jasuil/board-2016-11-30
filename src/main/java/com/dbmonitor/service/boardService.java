package com.dbmonitor.service;

import java.util.List;

import com.dbmonitor.domain.Criteria;
import com.dbmonitor.domain.SearchCriteria;
import com.dbmonitor.domain.boardVO;

public interface boardService {
	public List<boardVO> showListAll(SearchCriteria cri);
	public boardVO readList();
	public boardVO readOne(Integer bno) throws Exception;
	public String insertList(boardVO vo);
	public void modifyList(boardVO vo) throws Exception;
	public String deleteList(boardVO vo);
	public List<boardVO> listCriteria(Criteria cri) throws Exception;
	public int CountCriteria() throws Exception;
	public int searchCountCriteria(SearchCriteria cri) throws Exception;
}
