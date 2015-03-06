package com.sh.manage.entity;

// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * TOaSetcar entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="t_oa_setcar"
    ,catalog="ygjj"
)

public class TOaSetcar  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 7565604865491715421L;
	private long id;
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
     private String memCode;
     private double totalPrice;
     private double chinaPay;
     private double ukDriverPay;
     private Integer giffgaff;
     private Integer isSmoke;
     private Integer isSendUk;
     private String sendDate;
     private String remark;
     private Integer operateId;


    // Constructors

    /** default constructor */
    public TOaSetcar() {
    }

    
    /** full constructor */
    public TOaSetcar(String targetDate, String usecarDate, String flightNumber, Integer useType, String customerName, Integer peopleNumber, String telephone, String destAddress, String taobaoId, String weixinCode,String qqCode, String carType,String pickPeople, double totalPrice, double chinaPay, double ukDriverPay, Integer giffgaff, Integer isSmoke, Integer isSendUk, String sendDate, String remark, Integer operateId) {
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
        this.qqCode = qqCode;
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
    @Id @GeneratedValue
    
    @Column(name="id", unique=true, nullable=false)

    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(name="target_date", length=18)

    public String getTargetDate() {
        return this.targetDate;
    }
    
    public void setTargetDate(String targetDate) {
        this.targetDate = targetDate;
    }
    
    @Column(name="usecar_date", length=18)

    public String getUsecarDate() {
        return this.usecarDate;
    }
    
    public void setUsecarDate(String usecarDate) {
        this.usecarDate = usecarDate;
    }
    
    @Column(name="flight_number")

    public String getFlightNumber() {
        return this.flightNumber;
    }
    
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
    
    @Column(name="use_type")

    public Integer getUseType() {
        return this.useType;
    }
    
    public void setUseType(Integer useType) {
        this.useType = useType;
    }
    
    @Column(name="customer_name", length=50)

    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    @Column(name="people_number")

    public Integer getPeopleNumber() {
        return this.peopleNumber;
    }
    
    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }
    
    @Column(name="telephone", length=11)

    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    
    @Column(name="pick_people", length=50)
    public String getPickPeople() {
		return pickPeople;
	}


	public void setPickPeople(String pickPeople) {
		this.pickPeople = pickPeople;
	}


	@Column(name="dest_address", length=100)

    public String getDestAddress() {
        return this.destAddress;
    }
    
    public void setDestAddress(String destAddress) {
        this.destAddress = destAddress;
    }
    
    @Column(name="taobao_id", length=40)

    public String getTaobaoId() {
        return this.taobaoId;
    }
    
    public void setTaobaoId(String taobaoId) {
        this.taobaoId = taobaoId;
    }
    
    @Column(name="weixin_code", length=40)

    public String getWeixinCode() {
        return this.weixinCode;
    }
    
    
    
    public void setWeixinCode(String weixinCode) {
        this.weixinCode = weixinCode;
    }
    
    @Column(name="qq_code", length=40)

    public String getQqCode() {
		return qqCode;
	}


	public void setQqCode(String qqCode) {
		this.qqCode = qqCode;
	}
    
    @Column(name="car_type", length=40)

    public String getCarType() {
        return this.carType;
    }
    
    


	public void setCarType(String carType) {
        this.carType = carType;
    }
    
    @Column(name="total_price", precision=8)

    public double getTotalPrice() {
        return this.totalPrice;
    }
    
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    @Column(name="china_pay", precision=8)

    public double getChinaPay() {
        return this.chinaPay;
    }
    
    public void setChinaPay(double chinaPay) {
        this.chinaPay = chinaPay;
    }
    
    @Column(name="uk_driver_pay", precision=8)

    public double getUkDriverPay() {
        return this.ukDriverPay;
    }
    
    public void setUkDriverPay(double ukDriverPay) {
        this.ukDriverPay = ukDriverPay;
    }
    
    @Column(name="giffgaff")

    public Integer getGiffgaff() {
        return this.giffgaff;
    }
    
    public void setGiffgaff(Integer giffgaff) {
        this.giffgaff = giffgaff;
    }
    
    @Column(name="is_smoke")

    public Integer getIsSmoke() {
        return this.isSmoke;
    }
    
    public void setIsSmoke(Integer isSmoke) {
        this.isSmoke = isSmoke;
    }
    
    @Column(name="is_send_uk")

    public Integer getIsSendUk() {
        return this.isSendUk;
    }
    
    public void setIsSendUk(Integer isSendUk) {
        this.isSendUk = isSendUk;
    }
    
    @Column(name="send_date", length=18)

    public String getSendDate() {
        return this.sendDate;
    }
    
    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }
    
    @Column(name="remark", length=65535)

    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    @Column(name="operate_id")

    public Integer getOperateId() {
        return this.operateId;
    }
    
    public void setOperateId(Integer operateId) {
        this.operateId = operateId;
    }
    @Column(name="mem_code")
	public String getMemCode() {
		return memCode;
	}

	public void setMemCode(String memCode) {
		this.memCode = memCode;
	}
}