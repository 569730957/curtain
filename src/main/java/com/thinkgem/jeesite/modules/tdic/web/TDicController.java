/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tdic.web;

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
import com.thinkgem.jeesite.common.utils.IdGen;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.tdic.entity.TDic;
import com.thinkgem.jeesite.modules.tdic.service.TDicService;

/**
 * 字典管理Controller
 * @author cq
 * @version 2018-12-30
 */
@Controller
@RequestMapping(value = "${adminPath}/tdic/tDic")
public class TDicController extends BaseController {

	@Autowired
	private TDicService tDicService;
	
	@ModelAttribute
	public TDic get(@RequestParam(required=false) String id) {
		TDic entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tDicService.get(id);
		}
		if (entity == null){
			entity = new TDic();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(TDic tDic, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TDic> page = tDicService.findPage(new Page<TDic>(request, response), tDic); 
		model.addAttribute("page", page);
		model.addAttribute("tDic", tDic);
		return "modules/tdic/tDicList";
	}

	@RequestMapping(value = "form")
	public String form(TDic tDic, Model model) {
		model.addAttribute("tDic", tDic);
		return "modules/tdic/tDicForm";
	}

	@RequestMapping(value = "save")
	public String save(TDic tDic, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tDic)){
			return form(tDic, model);
		}
		
		tDicService.save(tDic);
		addMessage(redirectAttributes, "保存字典成功");
		return "redirect:"+Global.getAdminPath()+"/tdic/tDic/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(TDic tDic, RedirectAttributes redirectAttributes) {
		tDicService.delete(tDic);
		addMessage(redirectAttributes, "删除字典成功");
		return "redirect:"+Global.getAdminPath()+"/tdic/tDic/?repage";
	}

}