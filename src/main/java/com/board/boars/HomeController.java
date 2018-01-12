package com.board.boars;

import java.text.DateFormat;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dbmonitor.domain.boardVO;
import com.dbmonitor.service.boardService;

/**
 * Handles requests for the application home page.
 */
@Controller //auto JSON return
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	boardService service;
	private boardVO vo;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		vo = service.readList();
	
		model.addAttribute("serverTime", vo );
		
		return "home";
	}
	
	@RequestMapping(value="/test/json")
	public String json(){		
		// go directly json.jsp
		System.out.println("json");
		return "test/json";
	}
	
	 @RequestMapping(value = "/test/tt/{bno}", method = RequestMethod.GET)
	  public void readList(@PathVariable("bno") int bno, Model model,RedirectAttributes rttr) throws Exception {

	    logger.info("readList ..........."+bno);	    	    
	    //model.addAttribute(service.readOne(bno));
	    rttr.addFlashAttribute("msg", "success");	    
	  }

}
