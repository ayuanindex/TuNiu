package com.ayuan.tuniu.vo;

public class AllTrainType_List {
	private String link;

	private int trainType;

	private String trainTypeCode;

	private String trainTypeName;

	public AllTrainType_List() {
	}

	public AllTrainType_List(String link, int trainType, String trainTypeCode, String trainTypeName) {
		this.link = link;
		this.trainType = trainType;
		this.trainTypeCode = trainTypeCode;
		this.trainTypeName = trainTypeName;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getLink() {
		return this.link;
	}

	public void setTrainType(int trainType) {
		this.trainType = trainType;
	}

	public int getTrainType() {
		return this.trainType;
	}

	public void setTrainTypeCode(String trainTypeCode) {
		this.trainTypeCode = trainTypeCode;
	}

	public String getTrainTypeCode() {
		return this.trainTypeCode;
	}

	public void setTrainTypeName(String trainTypeName) {
		this.trainTypeName = trainTypeName;
	}

	public String getTrainTypeName() {
		return this.trainTypeName;
	}

	@Override
	public String toString() {
		return "AllTrainType_List{" +
				"link='" + link + '\'' +
				", trainType=" + trainType +
				", trainTypeCode='" + trainTypeCode + '\'' +
				", trainTypeName='" + trainTypeName + '\'' +
				'}';
	}
}
