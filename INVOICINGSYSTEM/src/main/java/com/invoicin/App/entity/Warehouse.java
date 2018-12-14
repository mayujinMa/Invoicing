package com.invoicin.App.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Entity
@Data
@Table(name = "Warehouse")
@JsonInclude(Include.NON_NULL)
public class Warehouse {
	@Id
	@GeneratedValue
	private Integer warehouseid; // 仓库id
	private String warehousename; // 仓库名称
	private Integer warehouseparentid;// 仓库父类id
	private String warehouseurl; // 仓库页面地址
	private int isdelete; // 是否删除
	private Integer exct1;
	// 实现思路一个仓库对应多个商品
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@JoinTable(name = "warehouseidwithproductId", joinColumns = {
			@JoinColumn(name = "warehouseid") }, inverseJoinColumns = { @JoinColumn(name = "productId") })
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Product> products = new HashSet<Product>();
	
	// 实现仓库对应哪些原材料
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@JoinTable(name = "warehouseidwithmaterialName", joinColumns = {
			@JoinColumn(name = "warehouseid") }, inverseJoinColumns = { @JoinColumn(name = "meterialId") })
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Meterial> meterials = new HashSet<Meterial>();
}
