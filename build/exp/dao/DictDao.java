package com.caipai.exp.dao;

import org.springframework.stereotype.Repository;

import com.caipai.common.dao.BaseDAO;
import com.caipai.exp.model.DictModel;
/**
 * 
 * @author liwei
 *
 */
@Repository
public interface DictDao extends BaseDAO<DictModel<String, Object>>{

	
}