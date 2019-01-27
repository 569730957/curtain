/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tgoodscate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.tgoodscate.entity.TGoodsCate;
import com.thinkgem.jeesite.modules.tgoodscate.dao.TGoodsCateDao;

/**
 * 类目管理Service
 * @author cq
 * @version 2018-12-30
 */
@Service
@Transactional(readOnly = true)
public class TGoodsCateService extends CrudService<TGoodsCateDao, TGoodsCate> {

	@Autowired
	TGoodsCateDao dao;
	
	@Transactional(readOnly = false)
	public int deleteByGoodsid(String goodsid){
		return dao.deleteByGoodsid(goodsid);
	}
	
	public TGoodsCate get(String id) {
		return super.get(id);
	}
	
	public List<TGoodsCate> findList(TGoodsCate tGoodsCate) {
		return super.findList(tGoodsCate);
	}
	
	public Page<TGoodsCate> findPage(Page<TGoodsCate> page, TGoodsCate tGoodsCate) {
		return super.findPage(page, tGoodsCate);
	}
	
	@Transactional(readOnly = false)
	public void save(TGoodsCate tGoodsCate) {
		
		if(StringUtils.isEmpty(tGoodsCate.getGoodsid())){
			dao.insert(tGoodsCate);
		}else{
			dao.update(tGoodsCate);
		}
		
		
	}
	
	@Transactional(readOnly = false)
	public void delete(TGoodsCate tGoodsCate) {
		super.delete(tGoodsCate);
	}
	
}