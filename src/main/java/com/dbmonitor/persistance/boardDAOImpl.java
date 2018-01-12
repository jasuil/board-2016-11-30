package com.dbmonitor.persistance;

import java.util.HashMap;
import java.util.List;


import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dbmonitor.domain.Criteria;
import com.dbmonitor.domain.SearchCriteria;
import com.dbmonitor.domain.boardVO;



@Repository
public class boardDAOImpl implements boardDAO {

	@Autowired
	@Resource(name="sqlSession")
	 private SqlSession session;
	private static String namespace = "oracleDb2";
	
	public boardDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(boardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".insert_list", vo);

	}

	@Override
	public boardVO read(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace +".read", id);
	}

	@Override
	public void update(boardVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.update(namespace+".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(bno);
		session.delete(namespace+".delete", bno);
	}

	@Override
	public List<boardVO> listAll(SearchCriteria cri) throws Exception {
		// TODO Auto-generated method stub	
	List <boardVO> li = session.selectList("oracleDb2.showlistAll", cri);
	System.out.println("dao-"+li);
	System.out.println();
		return session.selectList("oracleDb2.showlistAll", cri);
	}

	@Override
	public List<boardVO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	  public List<boardVO> listCriteria(Criteria cri) throws Exception{
		  System.out.println("dao cri");
		return session.selectList("oracleDb2.listCriteria", cri);		  
	  }

	  public int countPaging() throws Exception{		
		  System.out.println("search dao");
		  return session.selectOne(namespace+".countPaging");
	  }
	  
	    public int searchCountPaging(SearchCriteria cri) throws Exception{
	    	return session.selectOne(namespace+".countPaging_search", cri);
	    }
	  //use for dynamic sql
	  
	 	 /*  public List<boardVO> listSearch(SearchCriteria cri)throws Exception{
		  
	  }
	  
	  public int listSearchCount(SearchCriteria cri)throws Exception{
		  
	  }
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}*/

}
