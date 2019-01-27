/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tdic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.tdic.entity.TDic;
import com.thinkgem.jeesite.modules.tdic.dao.TDicDao;

/**
 * 字典管理Service
 * @author cq
 * @version 2018-12-30
 */
@Service
@Transactional(readOnly = true)
public class TDicService extends CrudService<TDicDao, TDic> {

	@Autowired
	TDicDao dao;
	
	public TDic get(String id) {
		return super.get(id);
	}
	
	public List<TDic> findList(TDic tDic) {
		return super.findList(tDic);
	}
	
	public Page<TDic> findPage(Page<TDic> page, TDic tDic) {
		return super.findPage(page, tDic);
	}
	
	@Transactional(readOnly = false)
	public void save(TDic tDic) {
		//add
		if(StringUtils.isEmpty(tDic.getDicid())){
			tDic.setDicid(IdGen.uuid());
			dao.insert(tDic);
		}else{
			dao.update(tDic);
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(TDic tDic) {
		super.delete(tDic);
	}
	
}