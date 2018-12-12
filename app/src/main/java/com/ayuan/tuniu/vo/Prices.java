package com.ayuan.tuniu.vo;

public class Prices {
	private Integer leftNumber;
	private double price;
	private double promotionPrice;
	private Integer resId;
	private Integer seat;
	private String seatName;
	private String seatStatus;

	public Prices() {
	}

	public Prices(Integer leftNumber, double price, double promotionPrice, Integer resId, Integer seat, String seatName, String seatStatus) {
		this.leftNumber = leftNumber;
		this.price = price;
		this.promotionPrice = promotionPrice;
		this.resId = resId;
		this.seat = seat;
		this.seatName = seatName;
		this.seatStatus = seatStatus;
	}

	public Integer getLeftNumber() {
		return leftNumber;
	}

	public void setLeftNumber(Integer leftNumber) {
		this.leftNumber = leftNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(double promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public Integer getSeat() {
		return seat;
	}

	public void setSeat(Integer seat) {
		this.seat = seat;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}

	@Override
	public String toString() {
		return "Prices{" +
				"leftNumber=" + leftNumber +
				", price=" + price +
				", promotionPrice=" + promotionPrice +
				", resId=" + resId +
				", seat=" + seat +
				", seatName='" + seatName + '\'' +
				", seatStatus='" + seatStatus + '\'' +
				'}';
	}
}
