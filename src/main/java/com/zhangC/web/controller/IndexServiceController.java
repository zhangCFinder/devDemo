package com.zhangC.web.controller;

import com.zhangC.common.exception.ExceptionConstants;
import com.zhangC.common.utils.DateUtil;
import com.zhangC.db.DynamicDSContext;
import com.zhangC.db.SystemVersionDao;
import com.zhangC.service.IndexService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/Index")
@Scope("prototype")
public class IndexServiceController extends BaseController {

	@Autowired
	private IndexService indexService;
	@Autowired
	private SystemVersionDao systemVersionDao;


	/**
	 * 测试通过request.getInputStream()拿到http请求中的body数据
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping("/getMobileIdInfo.action")
	public Map<String, Object> getMobileIdInfo(HttpServletRequest request) {
		String code = "";
		String msg = "";
		JSONObject json = new JSONObject();
		//切换数据源
		DynamicDSContext.set(systemVersionDao.getSwitchDataSource());

		String jsonStr = "";
		BufferedReader reader = null;
		try {
			StringBuffer sb = new StringBuffer();
			request.setCharacterEncoding("UTF-8");
			reader = new BufferedReader(new InputStreamReader(
					request.getInputStream(), "UTF-8"));
			String s = "";
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
				sb.append(s);
			}
			jsonStr = sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			jsonStr = "";
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("jsonStr--------"+jsonStr);
		String mobileId = request.getParameter("mobileId");
		System.out.println("mobileId-------------" + mobileId);
		List<Map<String, String>> dataidInfo = indexService.getDataIdInfo(mobileId);
		if (null != dataidInfo && dataidInfo.size() > 0) {
			json.put("dataidInfo", dataidInfo);
			code = ExceptionConstants.CODE_API_SUCCESS;
			msg = ExceptionConstants.MSG_API_SUCCESS;
		} else {
			code = ExceptionConstants.CODE_API_FAIL;
			msg = ExceptionConstants.MSG_API_ERROR;
		}
		return createResponse(request, code, msg, json);
	}


	/**
	 * 测试@ResponseBody和@RequestBody
	 *
	 * @return
	 */
	@RequestMapping("/getSysTime.action")
	public Map getSysTime(HttpServletRequest request) {
		System.out.println("接收到参数\n");


//		System.out.println("用户名--------------" + user.getUserName());
//		System.out.println("用户年龄------------" + user.getUserAge());
		System.out.println("中文");
//		System.out.println("deviceId------------" + request.getParameter("deviceId"));
		String code = ExceptionConstants.CODE_API_SUCCESS;
		String msg = ExceptionConstants.MSG_API_SUCCESS;
		Map returnMap = new HashMap();
		returnMap.put("code", code);
		returnMap.put("msg", msg);
		returnMap.put("SysTime", DateUtil.getCurrDateTime());
		return returnMap;
	}


}
