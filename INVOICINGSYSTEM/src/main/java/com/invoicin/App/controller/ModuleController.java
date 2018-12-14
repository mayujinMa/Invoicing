package com.invoicin.App.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invoicin.App.dao.EmployeeDao;
import com.invoicin.App.dao.ModuleDao;
import com.invoicin.App.dao.RoleDao;
import com.invoicin.App.entity.Employee;
import com.invoicin.App.entity.EmployeeSerch;
import com.invoicin.App.entity.Module;
import com.invoicin.App.entity.Role;
import com.invoicin.App.service.EmployeeService;
import com.invoicin.App.service.ModuleService;


@CrossOrigin
@RestController
@RequestMapping("/Module")

public class ModuleController {
	@Autowired
	private ModuleDao dao;
	@Autowired
	private RoleDao rdao;
	@Autowired
	private EmployeeDao edao;
	@Autowired 
	private ModuleService mService;
	Map<String, Object> map = new HashMap<String, Object>();

	/**
	 * 员工添加or修改
	 * http://localhost:8090/Module/queryall
	 * @param e
	 * @return
	 */
	@RequestMapping("/queryall")
	public Object queryall(Integer employeeId) {
		System.out.println(employeeId+"45646464");
		Employee e = edao.findOne(employeeId);
		System.out.println(employeeId+"45646464");
		Set<Role> role = e.getRole();
		Set<Module> m = new HashSet();
		if(role.size()<=0) return m;
		for (Role role2 : role) {
			if(role2.getModule().size()<=0) break;
			for (Module module : role2.getModule()) {
				if(module.getParentId()==0) {
					m.add(module);
				}
			}
		}
		return m;
	}

	/**
	 * 员工添加or修改
	 * http://localhost:8090/Module/add
	 * @param e
	 * @return
	 */
	@RequestMapping("/add")
	public Object add(Module e) {
		if(e.getModuleId()==null) {
			if(e.getParentId()!=0) {
				Module m1 = dao.findOne(e.getParentId());
				m1.getChildren().add(e);
				dao.save(m1);	
			}
			Module m = dao.save(e);
			if (m != null) {
				map.put("boo", true);
			} else {
				map.put("boo", false);
				map.put("message", "添加失败!");
			}
		}else {
			e.setModuleLastUpdateTime(new Date());
			Module m = dao.save(e);
			if (m != null) {
				map.put("boo", true);
			} else {
				map.put("boo", false);
				map.put("message", "修改失败!");
			}
		}
		
		return map;
	}

	
	
	/**
	 * 删除员工
	 * http://localhost:8090/Module/delete
	 * @param employeeId
	 * @return
	 */
	@RequestMapping("/delete")
	public Object delete(Integer moduleId) {
		Module m = dao.findOne(moduleId);
		if (m != null) {
			m.setState(1);
			Module m1 = dao.save(m);
			if (m1 != null) {
				map.put("boo", true);
			} else {
				map.put("boo", false);
				map.put("message", "删除失败!");
			}
		} else {
			map.put("boo", false);
			map.put("message", "删除失败!");
		}
		return map;
	}

	/**
	 * 模块的带条件分页查询
	 * http://localhost:8090/Module/queryBylike
	 * @param employeeSerch
	 * @param page
	 * @param rows
	 * @return
	 */
/*	@RequestMapping("/queryBylike")
	public Map<String, Object> QueryBylike(String  moduleName, Integer page, Integer rows) {
		Page<Module> pa = mService.queryByDynamicSQLPage(moduleName, page - 1, rows);
		map.put("rows", pa.getContent());
		map.put("total", pa.getTotalElements());
		return map;
	}*/

	/**
	 * 给模块设置孩子
	 * http://localhost:8090/Module/SetRole
	 * @param角色id集合 roleids
	 * @param员工id employeeId
	 * @return
	 */
	@RequestMapping("/Setchildren")
	public Map<String, Object> SetRole(String moduleids, Integer moduleId) {
		Module m = dao.findOne(moduleId);
		List<Module> roles = new ArrayList();
		String a[] = moduleids.split(",");
		if (moduleids == "")
		  {
			m.setChildren(roles);
			Module r=dao.save(m);
			if (r != null) {
				map.put("boo", true);
			} else {
				map.put("boo", false);
				map.put("message", "设置失败");
			}  
		  }else {
			  for (int i = 0; i < a.length; i++)
				 {
					Module m1 = dao.findOne(Integer.parseInt(a[i]));
					roles.add(m);
				 }
				m.setChildren(roles);
				Module r = dao.save(m);
				if (r != null) {
					map.put("boo", true);
				} else {
					map.put("boo", false);
					map.put("message", "设置失败");
				}  
		  }
		return map;
	}
	
}
