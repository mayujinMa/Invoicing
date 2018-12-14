package com.invoicin.App.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
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
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Entity
@Data
@Table(name = "Role")
@JsonInclude(Include.NON_NULL)
public class Role {
	@Id
	@GeneratedValue
	private Integer roleId; // 角色id
	@Column(length = 255)
	private String roleName; // 角色name

	@CreatedDate             //jpa自动创建时间
	@Column(name = "roleCreateTime",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date roleCreateTime; // 角色创建时间

	@LastModifiedDate             //jpa自动修改时间
	@Column(name = "roleUpdateTime")
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
	private Date roleUpdateTime; // 角色修改时间
	
	private String roleexPlain; // 角色备注
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	@JoinTable(name = "RolewithModule", joinColumns = { @JoinColumn(name = "roleId") }, inverseJoinColumns = {@JoinColumn(name = "moduleId") })
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<Module> module = new HashSet<Module>();
	private Integer exct1; // 预留字段
}
