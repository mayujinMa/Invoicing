package com.invoicin.App.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.Data;

@Entity
@Table(name = "company")
@Data
public class CompanyInfo {

	@Id
	@GeneratedValue
	private Integer companyId; // 公司id
	@Column(length = 50)
	private String companyName; // 公司名称
	private String dutyparagraph;// 公司税号
	private int isdelete; // 是否删除

	// @JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "company_city", joinColumns = { @JoinColumn(name = "companyId") }, inverseJoinColumns = {
			@JoinColumn(name = "cId") })
	@NotFound(action = NotFoundAction.IGNORE)
	List<City> city = new ArrayList<City>();

}
