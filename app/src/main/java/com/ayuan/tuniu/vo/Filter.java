package com.ayuan.tuniu.vo;

import java.util.ArrayList;

public class Filter {
	private String id;
	private String name;
	private ArrayList<Pros> pros;

	public Filter() {
	}

	public Filter(String id, String name, ArrayList<Pros> pros) {
		this.id = id;
		this.name = name;
		this.pros = pros;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Pros> getPros() {
		return pros;
	}

	public void setPros(ArrayList<Pros> pros) {
		this.pros = pros;
	}

	@Override
	public String toString() {
		return "Filter{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", pros=" + pros +
				'}';
	}
}
