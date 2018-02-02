package com.project.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseTContentsType<M extends BaseTContentsType<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public void setTypeCode(java.lang.String typeCode) {
		set("type_code", typeCode);
	}

	public java.lang.String getTypeCode() {
		return get("type_code");
	}

	public void setTypeName(java.lang.String typeName) {
		set("type_name", typeName);
	}

	public java.lang.String getTypeName() {
		return get("type_name");
	}

}
