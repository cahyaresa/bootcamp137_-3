package com.xsis.batch137.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.sun.istack.NotNull;

@Entity
@Table(name = "OUTLET")
public class Outlet {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private long id;

	@NotNull
	@NotEmpty
	@Size(max = 50)
	@Column(nullable=false)
	private String name;

	private String address;

	@Email
	@Size(max = 50)
	private String email;

	@Size(max = 16)
	private String phone;

	@ManyToOne
	@JoinColumn(name = "province_id", nullable=false)
	private Province province;

	@ManyToOne
	@JoinColumn(name = "region_id", nullable=false)
	private Region region;

	@ManyToOne
	@JoinColumn(name = "district_id", nullable=false)
	private District district;

	@Column(name = "postal_code")
	@Size(max = 6)
	private String postalCode;

	@ManyToOne
	@JoinColumn(name = "created_by")
	private User createdBy;

	@Column(name = "created_on")
	private Date createdOn;

	@ManyToOne
	@JoinColumn(name = "modified_by")
	private User modifiedBy;

	@Column(name = "modified_on")
	private Date modifiedOn;

	@NotNull
	@Column(nullable=false)
	private boolean active;

	// relasi ke emp outlet
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "outlet", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EmployeeOutlet> empOutlet;

	// relate to itemInveroty
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "outlet", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemInventory> itemInventories;
	
	// relate to adjustment
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "outlet", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Adjustment> adjustments;
	
	

	public List<Adjustment> getAdjustments() {
		return adjustments;
	}

	public void setAdjustments(List<Adjustment> adjustments) {
		this.adjustments = adjustments;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<ItemInventory> getItemInventories() {
		return itemInventories;
	}

	public void setItemInventories(List<ItemInventory> itemInventories) {
		this.itemInventories = itemInventories;
	}

	public List<EmployeeOutlet> getEmpOutlet() {
		return empOutlet;
	}

	public void setEmpOutlet(List<EmployeeOutlet> empOutlet) {
		this.empOutlet = empOutlet;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}


}
