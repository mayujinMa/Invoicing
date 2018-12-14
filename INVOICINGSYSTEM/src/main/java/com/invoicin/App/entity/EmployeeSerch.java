package com.invoicin.App.entity;

import java.util.Date;



import lombok.Data;

@Data
public class EmployeeSerch {
	private String orderBy;//排序
	private String employeeName;//姓名
	//private Integer isdelete;//是否被删除
	private Integer employeeSex; // 员工性别
	private String  employeeCard;//卡号
}
