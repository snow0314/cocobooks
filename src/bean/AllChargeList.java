package bean;

import java.util.Date;

public class AllChargeList {
	int chargeNum;
	String chargeId;
	int chargePrice;
	Date ChargeDate;
	public int getChargeNum() {
		return chargeNum;
	}
	public void setChargeNum(int chargeNum) {
		this.chargeNum = chargeNum;
	}
	public String getChargeId() {
		return chargeId;
	}
	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}
	public int getChargePrice() {
		return chargePrice;
	}
	public void setChargePrice(int chargePrice) {
		this.chargePrice = chargePrice;
	}
	public Date getChargeDate() {
		return ChargeDate;
	}
	public void setChargeDate(Date chargeDate) {
		ChargeDate = chargeDate;
	}
}
