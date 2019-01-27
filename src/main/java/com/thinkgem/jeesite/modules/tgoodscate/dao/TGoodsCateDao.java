/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tgoodscate.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.tgoodscate.entity.TGoodsCate;

/**
 * 类目管理DAO接口
 * @author cq
 * @version 2018-12-30
 */
@MyBatisDao
public interface TGoodsCateDao extends CrudDao<TGoodsCate> {
	int deleteByGoodsid(String goodsid);
}