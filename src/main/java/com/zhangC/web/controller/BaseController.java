package com.zhangC.web.controller;

import com.zhangC.common.utils.ReturnFormat;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Component
public class BaseController {


	public Map<String, Object> createResponse(HttpServletRequest request, String code, String message, Object data) {
		return ReturnFormat.createResponse(code, message, data);
	}



}
