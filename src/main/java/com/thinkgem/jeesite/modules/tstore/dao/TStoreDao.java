/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tstore.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.tstore.entity.TStore;

/**
 * 店铺信息DAO接口
 * @author cq
 * @version 2019-01-10
 */
@MyBatisDao
public interface TStoreDao extends CrudDao<TStore> {
	
}