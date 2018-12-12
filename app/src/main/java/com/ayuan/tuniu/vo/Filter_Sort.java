package com.ayuan.tuniu.vo;

import java.util.ArrayList;

public class Filter_Sort {
	private ArrayList<Filter> filters;
	private ArrayList<Sort> sorts;

	public Filter_Sort() {
	}

	public Filter_Sort(ArrayList<Filter> filters, ArrayList<Sort> sorts) {
		this.filters = filters;
		this.sorts = sorts;
	}

	public ArrayList<Filter> getFilters() {
		return filters;
	}

	public void setFilters(ArrayList<Filter> filters) {
		this.filters = filters;
	}

	public ArrayList<Sort> getSorts() {
		return sorts;
	}

	public void setSorts(ArrayList<Sort> sorts) {
		this.sorts = sorts;
	}

	@Override
	public String toString() {
		return "Filter_Sort{" +
				"filters=" + filters +
				", sorts=" + sorts +
				'}';
	}
}
