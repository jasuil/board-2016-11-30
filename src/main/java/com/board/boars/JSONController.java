package com.board.boars;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dbmonitor.domain.boardVO;
import com.dbmonitor.service.boardService;

/**
 * Handles requests for the application home page.
 */
@RestController //auto JSON return
public class JSONController {
	
	private static final Logger logger = LoggerFactory.getLogger(JSONController.class);
	@Inject
	boardService service;
	private boardVO vo;
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	
	
	@RequestMapping(value="/test/do", method = {RequestMethod.GET, RequestMethod.POST})
	public List<boardVO> nemo(@RequestBody boardVO vo){
		List<boardVO> list = service.showListAll(null);
		System.out.println(vo);
		return list;
	}
	
	@RequestMapping(value="/test/do", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public String doPatch(@RequestBody boardVO vo){
		List<boardVO> list = service.showListAll(null);
		System.out.println("put"+vo);
		boardVO vo2= new boardVO();
		vo.setContent("¾È³ç");
		List <String>s = new ArrayList<>(); 
				s.add(vo.getContent());
				System.out.println(s+"--");
		return "¾È³ç";
	}
	
	@RequestMapping(value="/test/jasuil")
	public Map<String,String> map(){
		Map<String,String> map = new HashMap<String,String>();
		String k=null;
		for(int i=0;i<5;i++){
			k="you"+i;
		map.put("you"+i, k);
		}
		return map;
	}
	
	@RequestMapping(value = "/test/user", method = RequestMethod.POST)
	public HashMap<String, Object> checkId(@RequestParam HashMap<String, Object> param) {
	     
	    System.out.println(param);
	    System.out.println("id is "+param.get("id"));
	 
	    //your logic
	 
	    HashMap<String, Object> hashmap = new HashMap<String, Object>();
	    hashmap.put("KEY", "YES");
	     
	    return hashmap;
	}
	
	@RequestMapping(value="/test/replies")
	public String json(@RequestBody boardVO vo){		
		// go directly json.jsp
		System.out.println(vo);
		return "success";
	}
	
}
