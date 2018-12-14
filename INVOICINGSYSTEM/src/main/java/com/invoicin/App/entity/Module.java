package com.invoicin.App.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;
@Data
@Entity
@Table(name = "module")
@GenericGenerator(name="moduleId", strategy="increment")
public class Module {
		@JsonIgnore
		@Id
		@GeneratedValue
		@Column(columnDefinition=" int unsigned NOT NULL comment '备注：模块自动增长主键'")
		private Integer moduleId;
		@JsonIgnore
		private Integer parentId;
		@JsonProperty("title")
		@Column(length=50)
		private String moduleName;
		@Column(length=50)
		@JsonProperty("href")
		private String moduleUrl;
		private String icon;
		@JsonIgnore
		@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
		private Date moduleCreateTime;
		@JsonIgnore
		private Date moduleLastUpdateTime;
		@JsonIgnore
		@Column(columnDefinition = "int default 0")
		private Integer state;
		@JsonIgnore
		@Transient
		private boolean checked;
		@OneToMany
		private List<Module> children;
		
	}

