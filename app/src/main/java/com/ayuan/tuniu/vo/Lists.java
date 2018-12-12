package com.ayuan.tuniu.vo;

import java.util.ArrayList;

public class Lists {
	private String accessByIdcard;

	private int arrivalCityCode;

	private String arrivalCityName;

	private int canChooseSeat;

	private String departDepartTime;

	private int departStationId;

	private String departStationName;

	private int departStationType;

	private String departStationTypeName;

	private int departureCityCode;

	private String departureCityName;

	private String destArriveTime;

	private int destStationId;

	private String destStationName;

	private int destStationType;

	private String destStationTypeName;

	private int duration;

	private int durationDay;

	private String durationStr;

	private String memo;

	private ArrayList<Prices> prices;

	private int saleStatus;

	private int sellOut;

	private String startSaleTime;

	private int trainId;

	private String trainNum;

	private int trainType;

	private String trainTypeName;

	private int upOrDown;

	public Lists() {
	}

	public Lists(String accessByIdcard, int arrivalCityCode, String arrivalCityName, int canChooseSeat, String departDepartTime, int departStationId, String departStationName, int departStationType, String departStationTypeName, int departureCityCode, String departureCityName, String destArriveTime, int destStationId, String destStationName, int destStationType, String destStationTypeName, int duration, int durationDay, String durationStr, String memo, ArrayList<Prices> prices, int saleStatus, int sellOut, String startSaleTime, int trainId, String trainNum, int trainType, String trainTypeName, int upOrDown) {
		this.accessByIdcard = accessByIdcard;
		this.arrivalCityCode = arrivalCityCode;
		this.arrivalCityName = arrivalCityName;
		this.canChooseSeat = canChooseSeat;
		this.departDepartTime = departDepartTime;
		this.departStationId = departStationId;
		this.departStationName = departStationName;
		this.departStationType = departStationType;
		this.departStationTypeName = departStationTypeName;
		this.departureCityCode = departureCityCode;
		this.departureCityName = departureCityName;
		this.destArriveTime = destArriveTime;
		this.destStationId = destStationId;
		this.destStationName = destStationName;
		this.destStationType = destStationType;
		this.destStationTypeName = destStationTypeName;
		this.duration = duration;
		this.durationDay = durationDay;
		this.durationStr = durationStr;
		this.memo = memo;
		this.prices = prices;
		this.saleStatus = saleStatus;
		this.sellOut = sellOut;
		this.startSaleTime = startSaleTime;
		this.trainId = trainId;
		this.trainNum = trainNum;
		this.trainType = trainType;
		this.trainTypeName = trainTypeName;
		this.upOrDown = upOrDown;
	}

	public String getAccessByIdcard() {
		return accessByIdcard;
	}

	public void setAccessByIdcard(String accessByIdcard) {
		this.accessByIdcard = accessByIdcard;
	}

	public int getArrivalCityCode() {
		return arrivalCityCode;
	}

	public void setArrivalCityCode(int arrivalCityCode) {
		this.arrivalCityCode = arrivalCityCode;
	}

	public String getArrivalCityName() {
		return arrivalCityName;
	}

	public void setArrivalCityName(String arrivalCityName) {
		this.arrivalCityName = arrivalCityName;
	}

	public int getCanChooseSeat() {
		return canChooseSeat;
	}

	public void setCanChooseSeat(int canChooseSeat) {
		this.canChooseSeat = canChooseSeat;
	}

	public String getDepartDepartTime() {
		return departDepartTime;
	}

	public void setDepartDepartTime(String departDepartTime) {
		this.departDepartTime = departDepartTime;
	}

	public int getDepartStationId() {
		return departStationId;
	}

	public void setDepartStationId(int departStationId) {
		this.departStationId = departStationId;
	}

	public String getDepartStationName() {
		return departStationName;
	}

	public void setDepartStationName(String departStationName) {
		this.departStationName = departStationName;
	}

	public int getDepartStationType() {
		return departStationType;
	}

	public void setDepartStationType(int departStationType) {
		this.departStationType = departStationType;
	}

	public String getDepartStationTypeName() {
		return departStationTypeName;
	}

	public void setDepartStationTypeName(String departStationTypeName) {
		this.departStationTypeName = departStationTypeName;
	}

	public int getDepartureCityCode() {
		return departureCityCode;
	}

	public void setDepartureCityCode(int departureCityCode) {
		this.departureCityCode = departureCityCode;
	}

	public String getDepartureCityName() {
		return departureCityName;
	}

	public void setDepartureCityName(String departureCityName) {
		this.departureCityName = departureCityName;
	}

	public String getDestArriveTime() {
		return destArriveTime;
	}

	public void setDestArriveTime(String destArriveTime) {
		this.destArriveTime = destArriveTime;
	}

	public int getDestStationId() {
		return destStationId;
	}

	public void setDestStationId(int destStationId) {
		this.destStationId = destStationId;
	}

	public String getDestStationName() {
		return destStationName;
	}

	public void setDestStationName(String destStationName) {
		this.destStationName = destStationName;
	}

	public int getDestStationType() {
		return destStationType;
	}

	public void setDestStationType(int destStationType) {
		this.destStationType = destStationType;
	}

	public String getDestStationTypeName() {
		return destStationTypeName;
	}

	public void setDestStationTypeName(String destStationTypeName) {
		this.destStationTypeName = destStationTypeName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDurationDay() {
		return durationDay;
	}

	public void setDurationDay(int durationDay) {
		this.durationDay = durationDay;
	}

	public String getDurationStr() {
		return durationStr;
	}

	public void setDurationStr(String durationStr) {
		this.durationStr = durationStr;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public ArrayList<Prices> getPrices() {
		return prices;
	}

	public void setPrices(ArrayList<Prices> prices) {
		this.prices = prices;
	}

	public int getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(int saleStatus) {
		this.saleStatus = saleStatus;
	}

	public int getSellOut() {
		return sellOut;
	}

	public void setSellOut(int sellOut) {
		this.sellOut = sellOut;
	}

	public String getStartSaleTime() {
		return startSaleTime;
	}

	public void setStartSaleTime(String startSaleTime) {
		this.startSaleTime = startSaleTime;
	}

	public int getTrainId() {
		return trainId;
	}

	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

	public String getTrainNum() {
		return trainNum;
	}

	public void setTrainNum(String trainNum) {
		this.trainNum = trainNum;
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

	public int getUpOrDown() {
		return upOrDown;
	}

	public void setUpOrDown(int upOrDown) {
		this.upOrDown = upOrDown;
	}

	@Override
	public String toString() {
		return "Lists{" +
				"accessByIdcard='" + accessByIdcard + '\'' +
				", arrivalCityCode=" + arrivalCityCode +
				", arrivalCityName='" + arrivalCityName + '\'' +
				", canChooseSeat=" + canChooseSeat +
				", departDepartTime='" + departDepartTime + '\'' +
				", departStationId=" + departStationId +
				", departStationName='" + departStationName + '\'' +
				", departStationType=" + departStationType +
				", departStationTypeName='" + departStationTypeName + '\'' +
				", departureCityCode=" + departureCityCode +
				", departureCityName='" + departureCityName + '\'' +
				", destArriveTime='" + destArriveTime + '\'' +
				", destStationId=" + destStationId +
				", destStationName='" + destStationName + '\'' +
				", destStationType=" + destStationType +
				", destStationTypeName='" + destStationTypeName + '\'' +
				", duration=" + duration +
				", durationDay=" + durationDay +
				", durationStr='" + durationStr + '\'' +
				", memo='" + memo + '\'' +
				", prices=" + prices +
				", saleStatus=" + saleStatus +
				", sellOut=" + sellOut +
				", startSaleTime='" + startSaleTime + '\'' +
				", trainId=" + trainId +
				", trainNum='" + trainNum + '\'' +
				", trainType=" + trainType +
				", trainTypeName='" + trainTypeName + '\'' +
				", upOrDown=" + upOrDown +
				'}';
	}
}
