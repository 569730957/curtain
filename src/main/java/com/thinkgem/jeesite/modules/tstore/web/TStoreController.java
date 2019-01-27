/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tstore.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.tstore.entity.TStore;
import com.thinkgem.jeesite.modules.tstore.service.TStoreService;

/**
 * 店铺信息Controller
 * @author cq
 * @version 2019-01-10
 */
@Controller
@RequestMapping(value = "${adminPath}/tstore/tStore")
public class TStoreController extends BaseController {

	@Autowired
	private TStoreService tStoreService;
	
	@ModelAttribute
	public TStore get(@RequestParam(required=false) String id) {
		TStore entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tStoreService.get(id);
		}
		if (entity == null){
			entity = new TStore();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(TStore tStore, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TStore> page = tStoreService.findPage(new Page<TStore>(request, response), tStore); 
		model.addAttribute("page", page);
		return "modules/tstore/tStoreList";
	}

	@RequestMapping(value = "form")
	public String form(TStore tStore, Model model) {
		model.addAttribute("tStore", tStore);
		return "modules/tstore/tStoreForm";
	}

	@RequestMapping(value = "save")
	public String save(TStore tStore, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tStore)){
			return form(tStore, model);
		}
		tStoreService.save(tStore);
		addMessage(redirectAttributes, "保存成功");
		return "redirect:"+Global.getAdminPath()+"/tstore/tStore/form?id=1";
	}
	
	@RequestMapping(value = "delete")
	public String delete(TStore tStore, RedirectAttributes redirectAttributes) {
		tStoreService.delete(tStore);
		addMessage(redirectAttributes, "删除店铺信息成功");
		return "redirect:"+Global.getAdminPath()+"/tstore/tStore/?repage";
	}

}