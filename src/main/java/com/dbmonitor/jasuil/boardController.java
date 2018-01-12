package com.dbmonitor.jasuil;

/**
 * 
 */


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	  public String registerGET(boardVO vo, Model model,RedirectAttributes rttr) throws Exception {

	    logger.info("list get ...........");

	    
	    List <boardVO>list = session.selectList("oracleDb2.showlistAll");
	  //  List<boardVO> list = service.showListAll();
	 //   Thread.sleep(5000);
	    model.addAllAttributes(list);
	    rttr.addFlashAttribute("msg", "success");
	    return "/board/listAll";
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
