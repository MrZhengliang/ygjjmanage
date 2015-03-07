package com.sh.manage.pojo;

// default package




/**
 * TOaGiffgaff entity. @author MyEclipse Persistence Tools
 */

public class TOaGiffgaffDTO  implements java.io.Serializable {


    // Fields    

     /**
	 * 
	 */
	private static final long serialVersionUID = 1834934215694604308L;
	private Integer id;
     private String buyDate;
     private String packDate;
     private String masterCard;
     private String sliverCard;
     private String username;
     private String terminalId;
     private Integer usetimeLimit;
     private double amount;
     private String taobaoId;
     private String weixinNickname;
     private String weixinCode;
     private String deliverCode;
     private String remark;
     private Integer operateId;

     private String operateName;
    // Constructors

    /** default constructor */
    public TOaGiffgaffDTO() {
    }

    
    /** full constructor */
    public TOaGiffgaffDTO(String buyDate, String packDate, String masterCard, String username, String terminalId, Integer usetimeLimit, double amount, String taobaoId, String weixinNickname, String weixinCode, String deliverCode, String remark, Integer operateId) {
        this.buyDate = buyDate;
        this.packDate = packDate;
        this.masterCard = masterCard;
        this.username = username;
        this.terminalId = terminalId;
        this.usetimeLimit = usetimeLimit;
        this.amount = amount;
        this.taobaoId = taobaoId;
        this.weixinNickname = weixinNickname;
        this.weixinCode = weixinCode;
        this.deliverCode = deliverCode;
        this.remark = remark;
        this.operateId = operateId;
    }

   
    // Property accessors

    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    

    public String getBuyDate() {
        return this.buyDate;
    }
    
    public void setBuyDate(String buyDate) {
        this.buyDate = buyDate;
    }
    

    public String getPackDate() {
        return this.packDate;
    }
    
    public void setPackDate(String packDate) {
        this.packDate = packDate;
    }
    

    public String getMasterCard() {
        return this.masterCard;
    }
    
    public void setMasterCard(String masterCard) {
        this.masterCard = masterCard;
    }
    

    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    

    public String getTerminalId() {
        return this.terminalId;
    }
    
    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }
    

    public Integer getUsetimeLimit() {
        return this.usetimeLimit;
    }
    
    public void setUsetimeLimit(Integer usetimeLimit) {
        this.usetimeLimit = usetimeLimit;
    }
    

    public double getAmount() {
        return this.amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    

    public String getTaobaoId() {
        return this.taobaoId;
    }
    
    public void setTaobaoId(String taobaoId) {
        this.taobaoId = taobaoId;
    }
    

    public String getWeixinNickname() {
        return this.weixinNickname;
    }
    
    public void setWeixinNickname(String weixinNickname) {
        this.weixinNickname = weixinNickname;
    }
    

    public String getWeixinCode() {
        return this.weixinCode;
    }
    
    public void setWeixinCode(String weixinCode) {
        this.weixinCode = weixinCode;
    }
    

    public String getDeliverCode() {
        return this.deliverCode;
    }
    
    public void setDeliverCode(String deliverCode) {
        this.deliverCode = deliverCode;
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
	
	public String getSliverCard() {
		return sliverCard;
	}


	public void setSliverCard(String sliverCard) {
		this.sliverCard = sliverCard;
	}
}