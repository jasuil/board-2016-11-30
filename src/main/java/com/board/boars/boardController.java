/**
 * 
 */
package com.board.boars;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dbmonitor.domain.Criteria;
import com.dbmonitor.domain.PageMaker;
import com.dbmonitor.domain.SearchCriteria;
import com.dbmonitor.domain.boardVO;
import com.dbmonitor.service.boardService;

/**
 * @author home
 *
 */
@Controller
@RequestMapping("/board/*")
public class boardController {

	private static final Logger logger = LoggerFactory.getLogger(boardController.class);
	@Inject
	boardService service;
	  @Inject
	  private SqlSession session;
	
	  @RequestMapping(value = "/listAll", method = {RequestMethod.GET, RequestMethod.POST})
	  public String listAll(SearchCriteria cri, Model model,RedirectAttributes rttr) throws Exception {

	    logger.info("list get ...........");
	    int count=0;
	    if(cri.getSearchType() == null)
	    	count = service.CountCriteria();
	    else
	    	count = service.searchCountCriteria(cri);
	    
	    System.out.println("hi");
	    cri.setTotalCount(count); //목록을 불러오려면 먼저 갯수를 파악해야 한다.
	    System.out.println("count-"+count);
	    System.out.println("before cri-"+cri);
	    List <boardVO>list = service.showListAll(cri); 
	    System.out.println("after cri-"+cri);
	    
	    model.addAttribute("list",list);	 
	
	    System.out.println("homec-"+list);
	    
	    PageMaker pageMaker = new PageMaker();
	    pageMaker.setCri(cri);
	    pageMaker.setTotalCount(count);
	    
	    model.addAttribute("pageMaker", pageMaker);
	    
	    rttr.addFlashAttribute("msg", "success");
	    return "/board/listAll";
	  }
	  
	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public String registerGET(boardVO vo, Model model,RedirectAttributes rttr) throws Exception {

	    logger.info("register get ...........");

	    rttr.addFlashAttribute("msg", "success");
	    return "/board/register";
	  }
	  
	  @RequestMapping(value = "/register", method = RequestMethod.POST)
	  public String registerPOST(boardVO vo, Model model,RedirectAttributes rttr) throws Exception {

	    logger.info("register post ...........");
	    service.insertList(vo);
	    rttr.addFlashAttribute("msg", "success");
	    return "redirect:/board/listAll";
	  }
	   
	  @RequestMapping(value = "/delete", method = RequestMethod.POST)
	  public String delete(boardVO vo, Model model,RedirectAttributes rttr) throws Exception {

	    logger.info("delete ..........."+vo);
	    service.deleteList(vo);
	    rttr.addFlashAttribute("msg", "success");
	    return "redirect:/board/listAll";
	  }
	   	  
	  @RequestMapping(value = "/read", method = RequestMethod.GET)
	  public void readList(@RequestParam("bno") int bno, Model model,RedirectAttributes rttr) throws Exception {

	    logger.info("readList ..........."+bno);	    	    
	    model.addAttribute(service.readOne(bno));
	    rttr.addFlashAttribute("msg", "success");	    
	  }
	  
	  @RequestMapping(value = "/modify", method = RequestMethod.GET)
	  public void modifyList(@RequestParam("bno") int bno, Model model,RedirectAttributes rttr) throws Exception {

	    logger.info("modifyList get ..........."+bno);	    	    
	    model.addAttribute(service.readOne(bno));
	    rttr.addFlashAttribute("msg", "success");	    
	  }
	  
	  @RequestMapping(value = "/modify", method = RequestMethod.POST)
	  public String modifyPagingPOST(boardVO vo, SearchCriteria cri, RedirectAttributes rttr) throws Exception {

		logger.info("modifyList post ...........");
	    logger.info(cri.toString());
	    service.modifyList(vo);

	    rttr.addAttribute("page", cri.getPage());
	    rttr.addAttribute("perPageNum", cri.getPerPageNum());
	    rttr.addAttribute("searchType", cri.getSearchType());
	    rttr.addAttribute("keyword", cri.getKeyword());

	    rttr.addFlashAttribute("msg", "SUCCESS");

	    logger.info(rttr.toString());

	    return "redirect:/board/listAll";
	  }
	  
	  @RequestMapping(value = "/listCri", method = RequestMethod.GET)
	  public void creteria(Criteria cri, Model model,RedirectAttributes rttr) throws Exception {

	    logger.info("criteria get ..........."+cri);
	  //  service.listCriteria(cri);
	    //session.selectList("oracleDb2.listCriteria", cri);
	    model.addAttribute("list", service.listCriteria(cri));
	    rttr.addFlashAttribute("msg", "success");	    
	  }
		
	  @RequestMapping(value = "/listPage", method = RequestMethod.GET)
	  public void listPage(SearchCriteria cri, Model model) throws Throwable  {
			PageMaker mk = new PageMaker();
			cri.setTotalCount(service.searchCountCriteria(cri));
			model.addAttribute("list", service.listCriteria(cri)); //목록으로 출력하는 부분
			
			mk.setCri(cri);		
			mk.setTotalCount(service.searchCountCriteria(cri));
			model.addAttribute("pageMaker", mk);
		}
	  
	/**
	 * 
	 */
	public boardController() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
