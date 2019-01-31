package com.example.exo;

import java.io.Serializable;
import java.util.List;

public class Data implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Integer> listInt;
	private int splitSize;
	
	
	public List<Integer> getListInt() {
		return listInt;
	}
	public void setListInt(List<Integer> listInt) {
		this.listInt = listInt;
	}
	
	public int getSplitSize() {
		return splitSize;
	}
	public void setSplitSize(int splitSize) {
		this.splitSize = splitSize;
	}
}
