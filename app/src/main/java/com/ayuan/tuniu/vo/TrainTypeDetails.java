package com.ayuan.tuniu.vo;

public class TrainTypeDetails {
	private int number;
	private int trainType;
	private String trainTypeName;

	public TrainTypeDetails() {
	}

	public TrainTypeDetails(int number, int trainType, String trainTypeName) {
		this.number = number;
		this.trainType = trainType;
		this.trainTypeName = trainTypeName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getTrainType() {
		return trainType;
	}

	public void setTrainType(int trainType) {
		this.trainType = trainType;
	}

	public String getTrainTypeName() {
		return trainTypeName;
	}

	public void setTrainTypeName(String trainTypeName) {
		this.trainTypeName = trainTypeName;
	}

	@Override
	public String toString() {
		return "TrainTypeDetails{" +
				"number=" + number +
				", trainType=" + trainType +
				", trainTypeName='" + trainTypeName + '\'' +
				'}';
	}
}
