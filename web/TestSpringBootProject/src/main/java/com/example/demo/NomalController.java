package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NomalController {
	@RequestMapping(value="/hello/nomal", method=RequestMethod.GET)
	@ResponseBody
	public  MyClass home(@RequestParam(value="myval", required=false)String param){
		
		MyClass ret = new MyClass();
		ret.setAge(1);
		ret.setName("haha");
		ret.setSchool(param);
		return ret;
	}
	@RequestMapping(value="/hello/foward")
	public String foward(){
		return "redirect:http://www.naver.com";
	}
	@RequestMapping(value="/hello/thyme")
	public ModelAndView foward(@RequestParam(value="param", required=false)String param,@RequestParam(value="isTrue", required=false)boolean isTrue, ModelAndView mav){
		mav.addObject("myparam", param);
		mav.addObject("isTrue", isTrue);
		mav.addObject("arrayVal", new String[]{"A","B","C"});
		mav.setViewName("folder1/test");
		return mav;
	}
	@RequestMapping(value="/hello/jsp")
	public ModelAndView jspRequest(@RequestParam(value="param", required=false)String param, ModelAndView mav){
		mav.addObject("val", param);
		mav.setViewName("testjsp");
		return mav;
	}
}
