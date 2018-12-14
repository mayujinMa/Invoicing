package com.invoicin.App.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicin.App.dao.MetrialKindDao;
import com.invoicin.App.entity.MeterialKind;

@RestController
@RequestMapping("/kind")
@CrossOrigin
public class MetrialKindController {
	@Autowired
	private MetrialKindDao mdao;
	/**
	 * 原材料分类树
	 * localhost:8090/kind/querytree
	 */
	@RequestMapping("/querytree")
	public Object queryTree() {
		List<MeterialKind> tree = new ArrayList<MeterialKind>();
		List<Integer> modultid = new ArrayList<Integer>();
	 //所有父亲节点为0
		List<MeterialKind> prodlist = mdao.findAll();
		for (MeterialKind prodlista : prodlist) {
			// 获取用户拥有的模块父亲id
			if (prodlista.getParentId() == 0) {
				// 模块节点为0时候的模块
				tree.add(prodlista);
			}
	
		}
		this.setChilders(tree, modultid);
		return tree;
	}
	private void setChilders(List<MeterialKind> tree, List<Integer> kindid) {

		for (MeterialKind m : tree) {
			// 查询出子菜单
			List<MeterialKind> modulechiled = mdao.findByParentId(m.getKindId());

			if (modulechiled != null && !modulechiled.isEmpty()) {// 有子菜单
				// 设置子菜单
				m.setChildren(modulechiled);

				this.setChilders(modulechiled, kindid);
			}else{
				if (kindid.contains(m.getKindId())) {
					m.setSetChecked(true);;
				}
			}
		}

	}

}
