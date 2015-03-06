package com.sh.manage.pojo;

import java.math.BigInteger;

// default package

/**
 * TOaSetcar entity. @author MyEclipse Persistence Tools
 */
public class TOaSetcarDTO  implements java.io.Serializable {


    // Fields    
     /**
	 * 
	 */
	private static final long serialVersionUID = 7565604865491715421L;
	private BigInteger id;
     private String targetDate;
     private String usecarDate;
     private String flightNumber;
     private Integer useType;
     private String customerName;
     private Integer peopleNumber;
     private String telephone;
     private String destAddress;
     private String taobaoId;
     private String weixinCode;
     private String qqCode;
     private String carType;
     private String pickPeople;
     private double totalPrice;
     private double chinaPay;
     private double ukDriverPay;
     private Integer giffgaff;
     private Integer isSmoke;
     private Integer isSendUk;
     private String sendDate;
     private String remark;
     private Integer operateId;

     /**
      * 操作员名称
      */
     private String operateName;
    // Constructors

    /** default constructor */
    public TOaSetcarDTO() {
    }

    
    /** full constructor */
    public TOaSetcarDTO(String targetDate, String usecarDate, String flightNumber, Integer useType, String customerName, Integer peopleNumber, String telephone, String destAddress, String taobaoId, String weixinCode, String carType,String pickPeople, double totalPrice, double chinaPay, double ukDriverPay, Integer giffgaff, Integer isSmoke, Integer isSendUk, String sendDate, String remark, Integer operateId) {
        this.targetDate = targetDate;
        this.usecarDate = usecarDate;
        this.flightNumber = flightNumber;
        this.useType = useType;
        this.customerName = customerName;
        this.peopleNumber = peopleNumber;
        this.telephone = telephone;
        this.destAddress = destAddress;
        this.taobaoId = taobaoId;
        this.weixinCode = weixinCode;
        this.carType = carType;
        this.pickPeople = pickPeople;
        this.totalPrice = totalPrice;
        this.chinaPay = chinaPay;
        this.ukDriverPay = ukDriverPay;
        this.giffgaff = giffgaff;
        this.isSmoke = isSmoke;
        this.isSendUk = isSendUk;
        this.sendDate = sendDate;
        this.remark = remark;
        this.operateId = operateId;
    }

   
    // Property accessors

    public BigInteger getId() {
        return this.id;
    }
    
    public void setId(BigInteger id) {
        this.id = id;
    }
    

    public String getTargetDate() {
        return this.targetDate;
    }
    
    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }
    

    public String getUsecarDate() {
        return this.usecarDate;
    }
    
    public void setUsecarDate(String usecarDate) {
        this.usecarDate = usecarDate;
    }
    

    public String getFlightNumber() {
        return this.flightNumber;
    }
    
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    

    public Integer getUseType() {
        return this.useType;
    }
    
    public void setUseType(Integer useType) {
        this.useType = useType;
    }
    

    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    

    public Integer getPeopleNumber() {
        return this.peopleNumber;
    }
    
    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }
    

    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    
    public String getPickPeople() {
		return pickPeople;
	}


	public void setPickPeople(String pickPeople) {
		this.pickPeople = pickPeople;
	}



    public String getDestAddress() {
        return this.destAddress;
    }
    
    public void setDestAddress(String destAddress) {
        this.destAddress = destAddress;
    }
    

    public String getTaobaoId() {
        return this.taobaoId;
    }
    
    public void setTaobaoId(String taobaoId) {
        this.taobaoId = taobaoId;
    }
    

    public String getWeixinCode() {
        return this.weixinCode;
    }
    
    public void setWeixinCode(String weixinCode) {
        this.weixinCode = weixinCode;
    }
    
    public String getQqCode() {
		return qqCode;
	}


	public void setQqCode(String qqCode) {
		this.qqCode = qqCode;
	}
    public String getCarType() {
        return this.carType;
    }
    
    public void setCarType(String carType) {
        this.carType = carType;
    }
    

    public double getTotalPrice() {
        return this.totalPrice;
    }
    
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    

    public double getChinaPay() {
        return this.chinaPay;
    }
    
    public void setChinaPay(double chinaPay) {
        this.chinaPay = chinaPay;
    }
    

    public double getUkDriverPay() {
        return this.ukDriverPay;
    }
    
    public void setUkDriverPay(double ukDriverPay) {
        this.ukDriverPay = ukDriverPay;
    }
    

    public Integer getGiffgaff() {
        return this.giffgaff;
    }
    
    public void setGiffgaff(Integer giffgaff) {
        this.giffgaff = giffgaff;
    }
    

    public Integer getIsSmoke() {
        return this.isSmoke;
    }
    
    public void setIsSmoke(Integer isSmoke) {
        this.isSmoke = isSmoke;
    }
    

    public Integer getIsSendUk() {
        return this.isSendUk;
    }
    
    public void setIsSendUk(Integer isSendUk) {
        this.isSendUk = isSendUk;
    }
    

    public String getSendDate() {
        return this.sendDate;
    }
    
    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }
    

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    

    public Integer getOperateId() {
        return this.operateId;
    }
    
    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }


	public String getOperateName() {
		return operateName;
	}


	public void setOperateName(String operateName) {
		this.operateName = operateName;
	}

}