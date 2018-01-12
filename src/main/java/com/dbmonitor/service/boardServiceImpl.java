package com.dbmonitor.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.dbmonitor.domain.Criteria;
import com.dbmonitor.domain.SearchCriteria;
import com.dbmonitor.domain.boardVO;
import com.dbmonitor.persistance.boardDAO;

@Service
public class boardServiceImpl implements boardService {
	
	@Inject
	boardDAO dao;

	@Override
	public List<boardVO> showListAll(SearchCriteria cri) {
		// TODO Auto-generated method stub
		List<boardVO>list=null;
		try {
			return dao.listAll(cri);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		}
	}

	@Override
	public boardVO readList() {
		// TODO Auto-generated method stub
		boardVO vo =null;
		try {
			return dao.read(11);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return vo;
		}
	}
	
	@Override
	public boardVO readOne(Integer bno) throws Exception {
		return dao.read(bno);
	}
	
	@Override
	public String insertList(boardVO vo) {
		// TODO Auto-generated method stub
		System.out.println(vo);
		try {
			dao.create(vo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void modifyList(boardVO vo) throws Exception  {
		// TODO Auto-generated method stub
	
			dao.update(vo);

	}

	@Override
	public String deleteList(boardVO vo) {
		// TODO Auto-generated method stub
		try {
			dao.delete(vo.getBno());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<boardVO> listCriteria(Criteria cri) throws Exception{
		System.out.println("serv cri");
		return dao.listCriteria(cri);
	}
	
	public int CountCriteria() throws Exception{
		return dao.countPaging();
	}
	
	public int searchCountCriteria(SearchCriteria cri) throws Exception{
		return dao.searchCountPaging(cri);
	}
}
