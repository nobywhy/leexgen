package com.caipai.exp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.caipai.exp.service.DictService;
import com.caipai.annotation.RequiresPermissions;
import com.caipai.annotation.SysLog;
import com.caipai.common.controller.BaseController;
import com.caipai.common.pageutil.Page;
import com.caipai.common.utils.PasswordHelper;
import com.caipai.common.utils.StringUtil;
/**
 * 
 * @author liwei
 *
 */
@Controller
@RequestMapping("exp/dict")
public class DictController extends BaseController {

	private static Logger log = Logger.getLogger(DictController.class);
	
	@Autowired
	private DictService dictService;

	@RequiresPermissions("dict_list")
	@RequestMapping("list.do")
	public String list(Model model) {
		Map<String, Object> queryParams = getFormMap();
		Page<Map<String, Object>> page = dictService.getByConditionPage(queryParams);
		model.addAttribute("page", page);
		model.addAttribute("queryParams", queryParams);
		return "exp/dict/list";
	}

	@RequiresPermissions("dict_add")
	@RequestMapping("toAdd.do")
	public String toAdd(Model model,HttpServletRequest request) {
		Map<String, Object> queryParams = getFormMap();
		
		String id = request.getParameter("id");
		if(StringUtil.isNotBlank(id)) {
			Map<String, Object> dict = dictService.getById(Integer.parseInt(id));
			model.addAttribute("dict", dict);
		}
		
		model.addAttribute("queryParams", queryParams);
		return "exp/dict/add";
	}

	@RequiresPermissions("dict_add")
	@RequestMapping("add.do")
	@SysLog(module="数据字典管理",methods="新增/修改数据字典")
	public String add(Model model) {
		Map<String, Object> formParams = getFormMap();
		String id = formParams.get("id")+"";
		if(StringUtil.isBlank(id)) {
			String encryptPassword =  PasswordHelper.encryptPassword(formParams.get("password")+"");
			formParams.put("password",encryptPassword);
			dictService.create(formParams);
		} else {
			dictService.update(formParams);
		}
		
		return "redirect:list.do";
	}

	
	@RequiresPermissions("dict_delete")
	@ResponseBody
	@RequestMapping(value="delete.do")
	@SysLog(module="数据字典管理",methods="删除数据字典")
	public JSONObject delete(HttpServletRequest request){
		String id = request.getParameter("id");
		dictService.delete(Integer.parseInt(id));
		JSONObject jsonResult = getJsonResult("1000", "message", null);
		return jsonResult;
	}
	
	
}
