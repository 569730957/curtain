/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tcollect.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.tcollect.entity.TCollect;
import com.thinkgem.jeesite.modules.tcollect.dao.TCollectDao;

/**
 * 用户收藏Service
 * @author cq
 * @version 2019-01-14
 */
@Service
@Transactional(readOnly = true)
public class TCollectService extends CrudService<TCollectDao, TCollect> {

	public TCollect get(String id) {
		return super.get(id);
	}
	
	public List<TCollect> findList(TCollect tCollect) {
		return super.findList(tCollect);
	}
	
	public Page<TCollect> findPage(Page<TCollect> page, TCollect tCollect) {
		return super.findPage(page, tCollect);
	}
	
	@Transactional(readOnly = false)
	public void save(TCollect tCollect) {
		super.save(tCollect);
	}
	
	@Transactional(readOnly = false)
	public void delete(TCollect tCollect) {
		super.delete(tCollect);
	}
	
}