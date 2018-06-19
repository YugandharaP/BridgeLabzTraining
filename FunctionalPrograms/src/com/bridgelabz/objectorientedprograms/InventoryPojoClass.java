package com.bridgelabz.objectorientedprograms;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class InventoryPojoClass<T> implements Serializable{
	 
	private ArrayList <Products> listRice=new ArrayList<Products>();
	private ArrayList<Products>listPulse=new ArrayList<Products>();
	private ArrayList<Products>listWheat=new ArrayList<Products>();
	
	public ArrayList<Products> getListRice() {
		return listRice;
	}
	public void setListRice(ArrayList<Products> listRice) {
		this.listRice = listRice;
	}
	public ArrayList<Products> getListPulse() {
		return listPulse;
	}
	public void setListPulse(ArrayList<Products> listPulse) {
		this.listPulse = listPulse;
	}
	public ArrayList<Products> getListWheat() {
		return listWheat;
	}
	public void setListWheat(ArrayList<Products> listWheat) {
		this.listWheat = listWheat;
	}
	

}
