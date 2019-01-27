/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tcate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.tcate.entity.TCate;
import com.thinkgem.jeesite.modules.tcate.dao.TCateDao;

/**
 * 类目Service
 * @author cq
 * @version 2018-12-31
 */
@Service
@Transactional(readOnly = true)
public class TCateService extends CrudService<TCateDao, TCate> {

	@Autowired
	TCateDao dao;
	
	@Transactional(readOnly = false)
	public int updateState(TCate t){
		return dao.updateState(t);
	}
	
	
	public TCate get(String id) {
		return super.get(id);
	}
	
	public List<TCate> findList(TCate tCate) {
		return super.findList(tCate);
	}
	
	public Page<TCate> findPage(Page<TCate> page, TCate tCate) {
		return super.findPage(page, tCate);
	}
	
	@Transactional(readOnly = false)
	public void save(TCate tCate) {
		
		if(StringUtils.isEmpty(tCate.getCateid())){
			tCate.setCateid(IdGen.uuid());
			dao.insert(tCate);
		}else{
			dao.update(tCate);
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(TCate tCate) {
		super.delete(tCate);
	}
	
}