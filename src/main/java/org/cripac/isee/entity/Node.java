package org.cripac.isee.entity;

import com.google.gson.annotations.SerializedName;

public class Node {

	private int id;
	
	private Attributes attributes;
	
	private String[] path;

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}

	public String[] getPath() {
		return path;
	}

	public void setPath(String[] path) {
		this.path = path;
	}
	
	
}
