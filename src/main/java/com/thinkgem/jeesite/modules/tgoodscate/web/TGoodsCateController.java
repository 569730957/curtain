/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tgoodscate.web;

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
import com.thinkgem.jeesite.modules.tgoodscate.entity.TGoodsCate;
import com.thinkgem.jeesite.modules.tgoodscate.service.TGoodsCateService;

/**
 * 类目管理Controller
 * @author cq
 * @version 2018-12-30
 */
@Controller
@RequestMapping(value = "${adminPath}/tgoodscate/tGoodsCate")
public class TGoodsCateController extends BaseController {

	@Autowired
	private TGoodsCateService tGoodsCateService;
	
	@ModelAttribute
	public TGoodsCate get(@RequestParam(required=false) String id) {
		TGoodsCate entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tGoodsCateService.get(id);
		}
		if (entity == null){
			entity = new TGoodsCate();
		}
		return entity;
	}
	
	@RequiresPermissions("tgoodscate:tGoodsCate:view")
	@RequestMapping(value = {"list", ""})
	public String list(TGoodsCate tGoodsCate, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TGoodsCate> page = tGoodsCateService.findPage(new Page<TGoodsCate>(request, response), tGoodsCate); 
		model.addAttribute("page", page);
		return "modules/tgoodscate/tGoodsCateList";
	}

	@RequiresPermissions("tgoodscate:tGoodsCate:view")
	@RequestMapping(value = "form")
	public String form(TGoodsCate tGoodsCate, Model model) {
		model.addAttribute("tGoodsCate", tGoodsCate);
		return "modules/tgoodscate/tGoodsCateForm";
	}

	@RequiresPermissions("tgoodscate:tGoodsCate:edit")
	@RequestMapping(value = "save")
	public String save(TGoodsCate tGoodsCate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tGoodsCate)){
			return form(tGoodsCate, model);
		}
		tGoodsCateService.save(tGoodsCate);
		addMessage(redirectAttributes, "保存类目管理成功");
		return "redirect:"+Global.getAdminPath()+"/tgoodscate/tGoodsCate/?repage";
	}
	
	@RequiresPermissions("tgoodscate:tGoodsCate:edit")
	@RequestMapping(value = "delete")
	public String delete(TGoodsCate tGoodsCate, RedirectAttributes redirectAttributes) {
		tGoodsCateService.delete(tGoodsCate);
		addMessage(redirectAttributes, "删除类目管理成功");
		return "redirect:"+Global.getAdminPath()+"/tgoodscate/tGoodsCate/?repage";
	}

}