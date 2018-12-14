package com.invoicin.App.controller;

import static org.mockito.Matchers.anyString;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.apache.catalina.filters.AddDefaultCharsetFilter;
import org.hibernate.hql.internal.ast.tree.FromElement;
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
import com.invoicin.App.service.RoleService;


@CrossOrigin
@RestController
@RequestMapping("/Role")

public class RoleController {
	@Autowired
	private RoleDao rdao;
	@Autowired
	private ModuleDao mdao;
	@Autowired
	private RoleService RoleService;
	Map<String, Object> map = new HashMap<String, Object>();
	
	
	/**
	 * 角色的添加和修改
	 * http://localhost:8090/Role/add
	 * @param r
	 * @return
	 */
	
	@RequestMapping("/add")
	public Map<String , Object> AddOrUpdate(Role r) {
		String roleName = r.getRoleName();
		 Role role = RoleService.findByRoleName(r.getRoleName());
		 if(r.getRoleId()==null) {
		 	if(role!=null) {
		 		map.put("boo", false);
		 		map.put("message", "角色名重复");
		 	}else {
		 		Role role1 = rdao.save(r);
		 		if(role1!=null) {
		 			map.put("boo", true);
		 		}else { 
		 			map.put("boo", false);
		 			map.put("message", "添加失败");
			    }
		 	}
		 }else {
			 if(role!=null) {
			 		map.put("boo", false);
			 		map.put("message", "角色名重复");
			 	}else {
			 		r.setRoleUpdateTime(new Date());
			 		Role role1 = rdao.save(r);
			 		if(role1!=null) {
			 			map.put("boo", true);
			 		}else { 
			 			map.put("boo", false);
			 			map.put("message", "修改失败");
				    }
			 	}
		 }
		return map;
	}
	
    /**
     * 角色的删除
     * http://localhost:8090/Role/delete
     * @param roleId
     * @return
     */
	@RequestMapping("/delete")
    public Object delete(Integer roleId) {
		if(RoleService.QueryByroleId(roleId)<=0) {
			rdao.delete(roleId);
    		Role role = rdao.findOne(roleId);
    		if(role==null) {
    			map.put("boo", true);
    			return  map;
    		}
		}
		map.put("boo", false);
		map.put("message", "该角色正在被使用");	
 		return  map;
	}
	 /**
     * 批量角色的删除
     * http://localhost:8090/Role/deleteRoles
     * @param roleId
     * @return
     */
	
	@RequestMapping("/deleteRoles")
    public Object deleteRoles(String roleIds ) {
		int sum = 0;
		int count = 0;
		String a[]  = roleIds.split(",");
		for (int i = 0; i < a.length; i++) {
			rdao.delete(Integer.parseInt(a[i]));
			Role role = rdao.findOne(Integer.parseInt(a[i]));
			if(role!=null) {
				count++;
			}else {
				sum++;
			}
		}
		return map.put("message", "成功"+sum+"条,失败"+count+"条");
	}
	/**
	 * 给角色设置模块
	 * http://localhost:8090/Role/SetMoule
	 * @param角色id集合 roleids
	 * @param员工id employeeId
	 * @return
	 */
	@RequestMapping("/SetMoule")
	public Map<String, Object> SetMoule(String moduleIds, Integer roleId) {
		Role role = rdao.findOne(roleId);
		Set<Module> modules = new HashSet();
		String a[] = moduleIds.split(",");
		if (moduleIds == "")
		  {
			role.setModule(modules);
			Role r = rdao.save(role);
			if (r != null) {
				map.put("boo", true);
			} else {
				map.put("boo", false);
				map.put("message", "设置失败");
			}  
		  }else {
			  for (int i = 0; i < a.length; i++)
				 {
					Module m = mdao.findOne(Integer.parseInt(a[i]));
					modules.add(m);
				 }
			  role.setModule(modules);;
			  Role r = rdao.save(role);
			  
				if (r != null) {
					map.put("boo", true);
				} else {
					map.put("boo", false);
					map.put("message", "设置失败");
				}  
		  }
		
		return map;
	}
	
	/**
	 * 角色的分页查询
	 * http://localhost:8090/Role/RoleQueryBylike
	 * @param roleName
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/RoleQueryBylike")
	public Map<String, Object> QueryBylike(String roleName, Integer page, Integer limit) {
		Page<Role> pa = RoleService.queryByDynamicSQLPage(roleName, page - 1, limit);
		map.put("data", pa.getContent());
		map.put("count", pa.getTotalElements());
		map.put("code", 0);
		return map;
	}

}
