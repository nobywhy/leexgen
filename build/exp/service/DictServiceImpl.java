package com.caipai.exp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caipai.common.dao.BaseDAO;
import com.caipai.common.service.BaseServiceImpl;
import com.caipai.exp.dao.DictDao;
import com.caipai.exp.service.DictService;
import com.caipai.exp.model.DictModel;
/**
 * 
 * @author liwei
 *
 */
@Service
public class DictServiceImpl extends BaseServiceImpl<DictModel<String, Object>> implements DictService {
	//@Autowired
	private DictDao dao = null;

	@Resource(name="dictDao")
	public void setDAO(DictDao dao) {
		super.setDAO(dao);
		this.dao = dao;
	}


}
