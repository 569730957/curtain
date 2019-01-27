/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tgoods.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.tgoods.entity.TGoods;
import com.thinkgem.jeesite.modules.tgoodscate.dao.TGoodsCateDao;
import com.thinkgem.jeesite.modules.tgoodscate.entity.TGoodsCate;
import com.thinkgem.jeesite.modules.tgoods.dao.TGoodsDao;

/**
 * 商品管理Service
 * @author cq
 * @version 2018-12-30
 */
@Service
@Transactional(readOnly = true)
public class TGoodsService extends CrudService<TGoodsDao, TGoods> {

	@Autowired
	TGoodsDao dao;
	@Autowired
	TGoodsCateDao tGoodsCateDao;
	
	@Transactional(readOnly = false)
	public int updateState(TGoods t){
		return dao.updateState(t);
	}
	
	
	public TGoods get(String id) {
		return super.get(id);
	}
	
	public List<TGoods> findList(TGoods tGoods) {
		return super.findList(tGoods);
	}
	
	public Page<TGoods> findPage(Page<TGoods> page, TGoods tGoods) {
		return super.findPage(page, tGoods);
	}
	
	@Transactional(readOnly = false)
	public void save(TGoods tGoods) {
		
		if (StringUtils.isEmpty(tGoods.getGoodsid())) {
			tGoods.setGoodsid(IdGen.uuid());
			dao.insert(tGoods);
		}else{
			dao.update(tGoods);
		}
		// 保存商品类目信息
		String[] cateids = tGoods.getCateid();
		for (String cateid : cateids) {
			// 保存
			TGoodsCate cate = new TGoodsCate();
			cate.setCategoodsid(IdGen.uuid());
			cate.setCateid(cateid);
			cate.setGoodsid(tGoods.getGoodsid());
			tGoodsCateDao.insert(cate);
		}
		
	}
	
	@Transactional(readOnly = false)
	public void delete(TGoods tGoods) {
		super.delete(tGoods);
	}
	
}