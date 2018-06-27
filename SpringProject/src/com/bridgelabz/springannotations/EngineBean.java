package com.bridgelabz.springannotations;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Scope("prototype")
@Component
public class EngineBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Value(value = "E1-00RC2")
	private String enineId;
	@Value(value = "1000kW")
	private String engineCapacity;
	@Value(value = "tata")
	private String engineCompany;

	public String getEnineId() {
		return enineId;
	}

	public void setEnineId(String enineId) {
		this.enineId = enineId;
	}

	public String getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(String engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public String getEngineCompany() {
		return engineCompany;
	}

	public void setEngineCompany(String engineCompany) {
		this.engineCompany = engineCompany;
	}

	@Override
	public String toString() {
		return "EngineBean [enineId=" + enineId + ", engineCapacity=" + engineCapacity + ", engineCompany="
				+ engineCompany + "]";
	}
}
