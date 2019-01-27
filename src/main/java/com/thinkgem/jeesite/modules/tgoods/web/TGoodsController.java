/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.tgoods.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringEscapeUtils;
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
import com.thinkgem.jeesite.modules.tdic.entity.TDic;
import com.thinkgem.jeesite.modules.tdic.service.TDicService;
import com.thinkgem.jeesite.modules.tgoods.entity.TGoods;
import com.thinkgem.jeesite.modules.tgoods.service.TGoodsService;
import com.thinkgem.jeesite.modules.tgoodscate.entity.TGoodsCate;
import com.thinkgem.jeesite.modules.tgoodscate.service.TGoodsCateService;

/**
 * 商品管理Controller
 * 
 * @author cq
 * @version 2018-12-30
 */
@Controller
@RequestMapping(value = "${adminPath}/tgoods/tGoods")
public class TGoodsController extends BaseController {

	@Autowired
	private TGoodsService tGoodsService;
	@Autowired
	private TCateService tCateService;
	@Autowired
	private TDicService tDicService;
	@Autowired
	private TGoodsCateService tGoodsCateService;

	@ModelAttribute
	public TGoods get(@RequestParam(required = false) String goodsid) {
		TGoods entity = null;
		if (StringUtils.isNotBlank(goodsid)) {
			entity = tGoodsService.get(goodsid);
		}
		if (entity == null) {
			entity = new TGoods();
		}
		return entity;
	}

	@RequestMapping(value = { "list", "" })
	public String list(TGoods tGoods, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<TGoods> page = tGoodsService.findPage(new Page<TGoods>(request, response), tGoods);
		model.addAttribute("page", page);
		model.addAttribute("tGoods", tGoods);

		return "modules/tgoods/tGoodsList";
	}

	@RequestMapping(value = "toadd")
	public String toadd(TGoods tGoods, Model model) {
		model.addAttribute("tGoods", tGoods);
		// 查询4个属性 和 类目
		TDic dic = new TDic();

		dic.setDictype("style");
		List<TDic> listStyle = tDicService.findList(dic);
		dic.setDictype("color");
		List<TDic> listColor = tDicService.findList(dic);
		dic.setDictype("fabric");
		List<TDic> listFabric = tDicService.findList(dic);
		dic.setDictype("technology");
		List<TDic> listTechnology = tDicService.findList(dic);

		// 查询所有的类目
		TCate tCate = new TCate();
		List<TCate> listCate = tCateService.findList(tCate);

		model.addAttribute("listStyle", listStyle);
		model.addAttribute("listColor", listColor);
		model.addAttribute("listFabric", listFabric);
		model.addAttribute("listTechnology", listTechnology);
		model.addAttribute("listCate", listCate);
		return "modules/tgoods/tGoodsAdd";
	}

	@RequestMapping(value = "form")
	public String form(TGoods tGoods, Model model) {
		tGoods.setGoodsdetail(StringEscapeUtils.escapeHtml(tGoods.getGoodsdetail()));
		model.addAttribute("tGoods", tGoods);

		// 查询4个属性 和 类目
		TDic dic = new TDic();

		dic.setDictype("style");
		List<TDic> listStyle = tDicService.findList(dic);
		dic.setDictype("color");
		List<TDic> listColor = tDicService.findList(dic);
		dic.setDictype("fabric");
		List<TDic> listFabric = tDicService.findList(dic);
		dic.setDictype("technology");
		List<TDic> listTechnology = tDicService.findList(dic);

		// 查询所有的类目
		TCate tCate = new TCate();
		List<TCate> listCate = tCateService.findList(tCate);

		model.addAttribute("listStyle", listStyle);
		model.addAttribute("listColor", listColor);
		model.addAttribute("listFabric", listFabric);
		model.addAttribute("listTechnology", listTechnology);
		model.addAttribute("listCate", listCate);
		
		//循环遍历所有的类目 和 当前商品所在的类目，返回勾选
		
		TGoodsCate tGoodsCate=new TGoodsCate();
		tGoodsCate.setGoodsid(tGoods.getGoodsid());
		List<TGoodsCate> mycate = tGoodsCateService.findList(tGoodsCate);
		String str="";
		// 1, 2, 3, 4,
		for(TCate c : listCate){
			// 2, 3
			boolean isexist=false;
			for(TGoodsCate tc : mycate){
				if(tc.getCateid().equals(c.getCateid())){
					isexist=true;break;
				}
			}
			
			if(isexist){
				str+="<input type='checkbox' name='cateid' checked value='"+c.getCateid()+"' />"+c.getCatename();
			}else{
				str+="<input type='checkbox' name='cateid' value='"+c.getCateid()+"' />"+c.getCatename();
			}
		}
		model.addAttribute("str", str);
		return "modules/tgoods/tGoodsForm";
	}

	@RequestMapping(value = "save")
	public String save(TGoods tGoods, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, tGoods)) {
			return form(tGoods, model);
		}
		
		if (StringUtils.isEmpty(tGoods.getGoodsid())) {
			//tGoods.setGoodsid(IdGen.uuid());
			//tGoods.setIsNewRecord(true);
		}else{
			// 修改前删除之前的类目
			tGoodsCateService.deleteByGoodsid(tGoods.getGoodsid());
		}
		//html转义处理保存
		String detail = StringEscapeUtils.unescapeHtml(tGoods.getGoodsdetail());
		tGoods.setGoodsdetail(detail);
		// 保存商品信息
		tGoodsService.save(tGoods);
		addMessage(redirectAttributes, "保存商品成功");
		return "redirect:" + Global.getAdminPath() + "/tgoods/tGoods/?repage";
	}

	@RequestMapping(value = "delete")
	public String delete(TGoods tGoods, RedirectAttributes redirectAttributes) {
		tGoodsService.delete(tGoods);
		addMessage(redirectAttributes, "删除商品成功");
		return "redirect:" + Global.getAdminPath() + "/tgoods/tGoods/?repage";
	}
	
	@RequestMapping(value = "updateState")
	public String updateState(HttpServletRequest req){
		
		String goodsid=req.getParameter("goodsid");
		String state=req.getParameter("state");
		
		TGoods tGoods=new TGoods();
		tGoods.setGoodsid(goodsid);
		tGoods.setState(state);
		
		tGoodsService.updateState(tGoods);
		
		return "redirect:" + Global.getAdminPath() + "/tgoods/tGoods/?repage";
	}

}