package net.koposw22.koposw22;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dbmonitor.domain.Criteria;
import com.dbmonitor.domain.PageMaker;
import com.dbmonitor.domain.boardVO;
import com.dbmonitor.persistance.boardDAO;

import org.junit.runner.RunWith;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class boardDAOTest {
	@Inject
	private boardDAO dao;
	
	@Ignore
	@Test
	public void read() throws Throwable{
		List<boardVO> list = dao.listAll(null);
		for(boardVO i:list)
		System.out.printf("%s\n",i);
	}
	
	
	@Test
	public void testCriteria() throws Throwable  {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(10);
	
		List <boardVO> list =  dao.listCriteria(cri);
	
		for (boardVO vo: list){
			System.out.println(vo.getBno()+vo.getTitle());
		}
	}
	
	
	@Test
	public void testlistPage() throws Throwable  {
		PageMaker mk = new PageMaker();
		Criteria cri = new Criteria();
		mk.setCri(cri); // 기본 설정값으로 시작
		mk.setTotalCount(111);	
		System.out.println(mk);
	}
	
	public boardDAOTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
