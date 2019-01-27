/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.tstore.entity.TStore;
import com.thinkgem.jeesite.modules.tstore.dao.TStoreDao;

/**
 * 店铺信息Service
 * @author cq
 * @version 2019-01-10
 */
@Service
@Transactional(readOnly = true)
public class TStoreService extends CrudService<TStoreDao, TStore> {

	@Autowired
	TStoreDao dao;
	
	public TStore get(String id) {
		return super.get(id);
	}
	
	public List<TStore> findList(TStore tStore) {
		return super.findList(tStore);
	}
	
	public Page<TStore> findPage(Page<TStore> page, TStore tStore) {
		return super.findPage(page, tStore);
	}
	
	@Transactional(readOnly = false)
	public void save(TStore tStore) {
		if(StringUtils.isEmpty(tStore.getStoreid())){
			
		}else{
			dao.update(tStore);
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(TStore tStore) {
		super.delete(tStore);
	}
	
}