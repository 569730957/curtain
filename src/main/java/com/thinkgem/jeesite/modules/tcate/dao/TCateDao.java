/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tcate.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.tcate.entity.TCate;

/**
 * 类目DAO接口
 * @author cq
 * @version 2018-12-31
 */
@MyBatisDao
public interface TCateDao extends CrudDao<TCate> {
	
	int updateState(TCate t);
}