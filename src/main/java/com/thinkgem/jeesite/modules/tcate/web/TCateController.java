/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tcate.web;

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
import com.thinkgem.jeesite.modules.tcate.entity.TCate;
import com.thinkgem.jeesite.modules.tcate.service.TCateService;
import com.thinkgem.jeesite.modules.tgoods.entity.TGoods;

/**
 * 类目Controller
 * @author cq
 * @version 2018-12-31
 */
@Controller
@RequestMapping(value = "${adminPath}/tcate/tCate")
public class TCateController extends BaseController {

	@Autowired
	private TCateService tCateService;
	
	@ModelAttribute
	public TCate get(@RequestParam(required=false) String cateid) {
		TCate entity = null;
		if (StringUtils.isNotBlank(cateid)){
			entity = tCateService.get(cateid);
		}
		if (entity == null){
			entity = new TCate();
		}
		return entity;
	}
	
	@RequestMapping(value = {"list", ""})
	public String list(TCate tCate, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TCate> page = tCateService.findPage(new Page<TCate>(request, response), tCate); 
		model.addAttribute("page", page);
		return "modules/tcate/tCateList";
	}

	@RequestMapping(value = "form")
	public String form(TCate tCate, Model model) {
		model.addAttribute("tCate", tCate);
		return "modules/tcate/tCateForm";
	}
	
	@RequestMapping(value = "toadd")
	public String toadd(TCate tCate, Model model) {
		model.addAttribute("tCate", tCate);
		return "modules/tcate/tCateForm";
	}

	@RequestMapping(value = "save")
	public String save(TCate tCate, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tCate)){
			return form(tCate, model);
		}
		
		tCateService.save(tCate);
		addMessage(redirectAttributes, "保存类目成功");
		return "redirect:"+Global.getAdminPath()+"/tcate/tCate/?repage";
	}
	
	@RequestMapping(value = "delete")
	public String delete(TCate tCate, RedirectAttributes redirectAttributes) {
		tCateService.delete(tCate);
		addMessage(redirectAttributes, "删除类目成功");
		return "redirect:"+Global.getAdminPath()+"/tcate/tCate/?repage";
	}
	
	@RequestMapping(value = "updateState")
	public String updateState(HttpServletRequest req){
		
		String cateid=req.getParameter("cateid");
		String state=req.getParameter("state");
		
		TCate t=new TCate();
		t.setCateid(cateid);
		t.setState(state);
		tCateService.updateState(t);
		return "redirect:" + Global.getAdminPath() + "/tcate/tCate/?repage";
	}
}