package com.project.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseTProducts<M extends BaseTProducts<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setProductTypeCode(java.lang.String productTypeCode) {
		set("product_type_code", productTypeCode);
	}

	public java.lang.String getProductTypeCode() {
		return get("product_type_code");
	}

	public void setProductCode(java.lang.String productCode) {
		set("product_code", productCode);
	}

	public java.lang.String getProductCode() {
		return get("product_code");
	}

	public void setProductName(java.lang.String productName) {
		set("product_name", productName);
	}

	public java.lang.String getProductName() {
		return get("product_name");
	}

	public void setPrice(java.lang.Double price) {
		set("price", price);
	}

	public java.lang.Double getPrice() {
		return get("price");
	}

	public void setContents(java.lang.String contents) {
		set("contents", contents);
	}

	public java.lang.String getContents() {
		return get("contents");
	}

	public void setPostDate(java.util.Date postDate) {
		set("post_date", postDate);
	}

	public java.util.Date getPostDate() {
		return get("post_date");
	}

	public void setHits(java.util.Date hits) {
		set("hits", hits);
	}

	public java.util.Date getHits() {
		return get("hits");
	}

	public void setPicurl(java.lang.String picurl) {
		set("picurl", picurl);
	}

	public java.lang.String getPicurl() {
		return get("picurl");
	}

	public void setLevels(java.lang.Integer levels) {
		set("levels", levels);
	}

	public java.lang.Integer getLevels() {
		return get("levels");
	}

	public void setKeywords(java.lang.String keywords) {
		set("keywords", keywords);
	}

	public java.lang.String getKeywords() {
		return get("keywords");
	}

	public void setMenuOrder(java.lang.Integer menuOrder) {
		set("menu_order", menuOrder);
	}

	public java.lang.Integer getMenuOrder() {
		return get("menu_order");
	}

	public void setCreateUse(java.lang.String createUse) {
		set("create_use", createUse);
	}

	public java.lang.String getCreateUse() {
		return get("create_use");
	}

	public void setCreateDate(java.util.Date createDate) {
		set("create_date", createDate);
	}

	public java.util.Date getCreateDate() {
		return get("create_date");
	}

	public void setModifyUse(java.lang.String modifyUse) {
		set("modify_use", modifyUse);
	}

	public java.lang.String getModifyUse() {
		return get("modify_use");
	}

	public void setModifyDate(java.util.Date modifyDate) {
		set("modify_date", modifyDate);
	}

	public java.util.Date getModifyDate() {
		return get("modify_date");
	}

}