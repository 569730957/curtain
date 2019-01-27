/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tuser.web;

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
import com.thinkgem.jeesite.modules.tuser.entity.TUser;
import com.thinkgem.jeesite.modules.tuser.service.TUserService;

/**
 * 用户管理Controller
 * @author cq
 * @version 2018-12-30
 */
@Controller
@RequestMapping(value = "${adminPath}/tuser/tUser")
public class TUserController extends BaseController {

	@Autowired
	private TUserService tUserService;
	
	@ModelAttribute
	public TUser get(@RequestParam(required=false) String id) {
		TUser entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tUserService.get(id);
		}
		if (entity == null){
			entity = new TUser();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(TUser tUser, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TUser> page = tUserService.findPage(new Page<TUser>(request, response), tUser); 
		model.addAttribute("tUser", tUser);
		model.addAttribute("page", page);
		return "modules/tuser/tUserList";
	}

	@RequestMapping(value = "form")
	public String form(TUser tUser, Model model) {
		model.addAttribute("tUser", tUser);
		return "modules/tuser/tUserForm";
	}

	@RequestMapping(value = "save")
	public String save(TUser tUser, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tUser)){
			return form(tUser, model);
		}
		tUserService.save(tUser);
		addMessage(redirectAttributes, "保存用户管理成功");
		return "redirect:"+Global.getAdminPath()+"/tuser/tUser/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(TUser tUser, RedirectAttributes redirectAttributes) {
		tUserService.delete(tUser);
		addMessage(redirectAttributes, "删除用户管理成功");
		return "redirect:"+Global.getAdminPath()+"/tuser/tUser/?repage";
	}

}