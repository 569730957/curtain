/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tcollect.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.tcollect.entity.TCollect;

/**
 * 用户收藏DAO接口
 * @author cq
 * @version 2019-01-14
 */
@MyBatisDao
public interface TCollectDao extends CrudDao<TCollect> {
	
}