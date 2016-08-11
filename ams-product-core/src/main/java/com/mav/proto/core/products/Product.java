package com.mav.proto.core.products;

import java.text.DecimalFormat;

/**
 * 
 * @author Michael Angelo Valencia
 *
 * Aug 11, 2016
 * 
 * Entity resource for Product
 */
public class Product {

	private String code;
	private String name;
	private String description;
	private double price;
	private int expiry;
	private boolean is_plan;
	private boolean is_unlimited;
	private int size_mb;
	private boolean is_4g;
	private boolean auto_renew;
	private String termsUrl;
	private String infoUrl;
	
	public Product(){
		
	}
	public Product(String code, String name, String description, double price, int expiry, boolean is_plan,
			boolean is_unlimited, int size_mb, boolean is_4g, boolean auto_renew, String termsUrl, String infoUrl) {
		super();
		this.code = code;
		this.name = name;
		this.description = description;
		this.price = price;
		this.expiry = expiry;
		this.is_plan = is_plan;
		this.is_unlimited = is_unlimited;
		this.size_mb = size_mb;
		this.is_4g = is_4g;
		this.auto_renew = auto_renew;
		this.termsUrl = termsUrl;
		this.infoUrl = infoUrl;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return  price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getExpiry() {
		return expiry;
	}
	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}
	public boolean isIs_plan() {
		return is_plan;
	}
	public void setIs_plan(boolean is_plan) {
		this.is_plan = is_plan;
	}
	public boolean isIs_unlimited() {
		return is_unlimited;
	}
	public void setIs_unlimited(boolean is_unlimited) {
		this.is_unlimited = is_unlimited;
	}
	public int getSize_mb() {
		return size_mb;
	}
	public void setSize_mb(int size_mb) {
		this.size_mb = size_mb;
	}
	public boolean isIs_4g() {
		return is_4g;
	}
	public void setIs_4g(boolean is_4g) {
		this.is_4g = is_4g;
	}
	public boolean isAuto_renew() {
		return auto_renew;
	}
	public void setAuto_renew(boolean auto_renew) {
		this.auto_renew = auto_renew;
	}
	public String getTermsUrl() {
		return termsUrl;
	}
	public void setTermsUrl(String termsUrl) {
		this.termsUrl = termsUrl;
	}
	public String getInfoUrl() {
		return infoUrl;
	}
	public void setInfoUrl(String infoUrl) {
		this.infoUrl = infoUrl;
	}
	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", expiry=" + expiry + ", is_plan=" + is_plan + ", is_unlimited=" + is_unlimited + ", size_mb="
				+ size_mb + ", is_4g=" + is_4g + ", auto_renew=" + auto_renew + ", termsUrl=" + termsUrl + ", infoUrl="
				+ infoUrl + "]";
	}

}
