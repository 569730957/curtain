/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tcollect.web;

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
import com.thinkgem.jeesite.modules.tcollect.entity.TCollect;
import com.thinkgem.jeesite.modules.tcollect.service.TCollectService;

/**
 * 用户收藏Controller
 * @author cq
 * @version 2019-01-14
 */
@Controller
@RequestMapping(value = "${adminPath}/tcollect/tCollect")
public class TCollectController extends BaseController {

	@Autowired
	private TCollectService tCollectService;
	
	@ModelAttribute
	public TCollect get(@RequestParam(required=false) String id) {
		TCollect entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = tCollectService.get(id);
		}
		if (entity == null){
			entity = new TCollect();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(TCollect tCollect, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TCollect> page = tCollectService.findPage(new Page<TCollect>(request, response), tCollect); 
		model.addAttribute("page", page);
		model.addAttribute("tCollect", tCollect);
		return "modules/tcollect/tCollectList";
	}

	@RequestMapping(value = "form")
	public String form(TCollect tCollect, Model model) {
		model.addAttribute("tCollect", tCollect);
		return "modules/tcollect/tCollectForm";
	}

	@RequestMapping(value = "save")
	public String save(TCollect tCollect, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tCollect)){
			return form(tCollect, model);
		}
		tCollectService.save(tCollect);
		addMessage(redirectAttributes, "保存用户收藏成功");
		return "redirect:"+Global.getAdminPath()+"/tcollect/tCollect/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(TCollect tCollect, RedirectAttributes redirectAttributes) {
		tCollectService.delete(tCollect);
		addMessage(redirectAttributes, "删除用户收藏成功");
		return "redirect:"+Global.getAdminPath()+"/tcollect/tCollect/?repage";
	}

}