package com.invoicin.App.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Entity
@Table(name="kindtb")
@Data
public class MeterialKind {
	@Id
	@GeneratedValue
	private Integer kindId;
	private String kindName;
	private String meterialModel;//原材料型号,例:T45,T55,T65
	private Integer parentId;
	@JsonInclude(Include.NON_NULL)
	@Transient
	private List<MeterialKind> children;
	@Transient
	private Boolean setChecked;
	
	@ManyToMany
	@JoinTable(name = "metrial_kind", joinColumns = {
			@JoinColumn(name = "kindId") }, inverseJoinColumns = { @JoinColumn(name = "meterialId") })
	@NotFound(action = NotFoundAction.IGNORE)
	private List<Meterial> meterial;
	
}
