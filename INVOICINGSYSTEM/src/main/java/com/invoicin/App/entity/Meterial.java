package com.invoicin.App.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

//原材料表
@Entity
@Data
@Table(name = "Meterial")
@JsonInclude(Include.NON_NULL)
public class Meterial {
	@Id
	@GeneratedValue
	private Integer meterialId; // 原材料id
	@Column(length = 255)
	private String materialName; // 原材料name
	private Integer materialUnit;//原材料单位,统一规定单位为kg
	private String specification;//规格(袋,桶,罐等名词)
	private Integer materialNumber; // 原材料数量
	private Float materialoPenpRice; // 原材料进价
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	@Column(columnDefinition="timestamp DEfAULT NOW()")
	private Date materialCreateTime;//生产日期
	private Integer expirationDate; // 原材料保质期
	private Integer materialState; // 原材料状态
	private Integer typeDataId; // 原料类型
	private Integer wareHouseId; // 所属仓库id
	private Integer isdelete; // 是否删除
	private Integer exct1; // 预留字段
	// 实现原材料属于哪个仓库
	//@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER,cascade= { CascadeType.ALL })
	@JoinTable(name = "materialNamewithwarehouseid", joinColumns = {
			@JoinColumn(name = "meterialId") }, inverseJoinColumns = { @JoinColumn(name = "warehouseid") })
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Warehouse> warehouses = new HashSet<Warehouse>();
	
//	@JoinTable(name = "metrial_kind", joinColumns = {
//			@JoinColumn(name = "meterialId") }, inverseJoinColumns = { @JoinColumn(name = "kindId") })
//	@NotFound(action = NotFoundAction.IGNORE)
	
}
