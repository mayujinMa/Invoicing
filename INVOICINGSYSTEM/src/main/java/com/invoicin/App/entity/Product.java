package com.invoicin.App.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "Product")
@JsonInclude(Include.NON_NULL)
public class Product {
	@Id
	@GeneratedValue
	private Integer productId; // 商品id
	private String productName; // 商品name
	private BigDecimal prodectSell;// 商品售价
	private String prodectdRemark;// 商品备注
	private Integer typeDataId; // 商品分类
	private Integer recipeId; // 原料表中配方id
	private Integer prodectState; // 是否下架
	private int isdelete; // 是否删除
	private Integer exct1;

	// 实现思路一个商品对应多个仓库
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@JoinTable(name = "productIdwithwarehouseid", joinColumns = {
			@JoinColumn(name = "productId") }, inverseJoinColumns = { @JoinColumn(name = "warehouseid") })
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Warehouse> pSet = new HashSet<Warehouse>();
}
