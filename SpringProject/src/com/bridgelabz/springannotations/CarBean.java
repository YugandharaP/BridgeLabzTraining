package com.bridgelabz.springannotations;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Lazy
@Scope(value="prototype")
@Component(value = "carBean")
public class CarBean implements Serializable {
	private static final long serialVersionUID = 5286802296814258784L;
	@Value(value = "MH-07-2426")
	private String carNumber;
	@Value(value = "Swift")
	private String carModel;
	@Value(value = "Black")
	private String carColor;
	@Autowired
	private EngineBean engine;
	@Autowired
	@Qualifier("engine1")
	private EngineBean engine1;
	@Autowired
	private Vehical vehical;
	@Autowired
	public CarBean(EngineBean engine) {
		this.engine = engine;
		System.out.println("@Autowired used on contructor with arguement engine");
	}
	/*
	 * @Autowired public CarBean(Vehical vehical) { this.vehical = vehical;
	 * System.out.println("@Autowired used on contructor with arguement vehical"); }
	 */

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}

	public String getCarColor() {
		return carColor;
	}
@Required
	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public EngineBean getEngineBean() {
		return engine;
	}

	public void setEngineBean(EngineBean engine) {
		this.engine = engine;
	}

	public EngineBean getEngine() {
		return engine;
	}

	public Vehical getVehical() {
		return vehical;
	}

	public void setVehical(Vehical vehical) {
		this.vehical = vehical;
	}

	public void startCar() {
		System.out.println("This " + this.carModel + " starts when Car-Producers used " + this.engine.getEngineCompany()
				+ " company engine.");
	}

	@Override
	public String toString() {
		return "CarBean [carNumber=" + carNumber + ", carModel=" + carModel + ", carColor=" + carColor + ", engine="
				+ engine + ", vehical=" + vehical + "]";
	}
}
