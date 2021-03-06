package com.sh.manage.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sh.manage.constants.Constants;
import com.sh.manage.constants.SessionConstants;
import com.sh.manage.entity.TOaGiffgaff;
import com.sh.manage.entity.TOaSetcar;
import com.sh.manage.module.page.Page;
import com.sh.manage.pojo.LoginUser;
import com.sh.manage.pojo.TOaGiffgaffDTO;
import com.sh.manage.pojo.TOaSetcarDTO;
import com.sh.manage.service.CourseService;
import com.sh.manage.service.OaService;
import com.sh.manage.service.UploadService;
import com.sh.manage.service.UserService;
import com.sh.manage.utils.TimeUtil;
import com.sh.manage.utils.WebUtils;

/**
 * 客服管理控制
 * @author 
 */

@Controller
public class OaController {
	
	private Logger logger = Logger.getLogger(OaController.class);


	/**
	 * 客服客服管理service
	 */
	@Autowired
	private OaService oaService;
	
	@Autowired
	private UserService userService;

	/**
	 * 客服管理service
	 */
	@Autowired
	private CourseService courseService;
	
	/**
	 * 上传管理service
	 */
	@Autowired
	private UploadService uploadService;
	

	/** 当前页 */
	private int initPageNo = 1;

	/** 页面大小 */
	private int pageSize = 5;

	/** Page对象 */
	private Page page;

	/**
	 * 跳转订车记录管理页面
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/oakfmanage.do")
	public ModelAndView oaKfManagePage(
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			
			@RequestParam(value = "sendDate", required = false, defaultValue = "") String sendDate,
			@RequestParam(value = "usecarDate", required = false, defaultValue = "") String usecarDate,
			@RequestParam(value = "useType", required = false, defaultValue = "") Integer useType,
			@RequestParam(value = "customerName", required = false, defaultValue = "") String customerName,
			@RequestParam(value = "telephone", required = false, defaultValue = "") String telephone,
			@RequestParam(value = "taobaoId", required = false, defaultValue = "") String taobaoId,
			@RequestParam(value = "weixinCode", required = false, defaultValue = "") String weixinCode,
			@RequestParam(value = "pickPeople", required = false, defaultValue = "") String pickPeople,
			@RequestParam(value = "remark", required = false, defaultValue = "") String remark,
			@RequestParam(value = "pageNo", required = false, defaultValue = "") Integer pageNo) {
		// 获取客服以及等级
		if (null == pageNo) {
			pageNo = initPageNo;
		}
		// 返回订车记录列表页
		ModelAndView model = new ModelAndView("/oa/kf_manage");
		model.addObject("sendDate", sendDate);
		model.addObject("usecarDate", usecarDate);
		model.addObject("useType", useType);
		model.addObject("customerName", customerName);
		model.addObject("telephone", telephone);
		model.addObject("taobaoId", taobaoId);
		model.addObject("weixinCode", weixinCode);
		model.addObject("pickPeople", pickPeople);
		model.addObject("remark", remark);
		
		// 返回的page对象
		
		page = oaService.findAllTOaSetcar(usecarDate==null?"":usecarDate.replaceAll("-", ""), useType, customerName,
				telephone, taobaoId, weixinCode, pickPeople, remark, pageNo,
				pageSize);

		// 订车记录列表
		List<TOaSetcar> oaSetcarList = (List<TOaSetcar>) page.getList();


		// 翻页带参数
		if(null != sendDate){
			page.addParam("sendDate",sendDate);
		}
		if(null != usecarDate){
			page.addParam("usecarDate",usecarDate);
		}
		if(null != useType){
			page.addParam("useType",""+useType);
		}
		if(null != customerName){
			page.addParam("customerName",customerName);
		}
		if(null != telephone){
			page.addParam("telephone",telephone);
		}
		if(null != taobaoId){
			page.addParam("taobaoId",taobaoId);
		}
		if(null != weixinCode){
			page.addParam("weixinCode",weixinCode);
		}
		if(null != pickPeople){
			page.addParam("pickPeople",pickPeople);
		}
		if(null != remark){
			page.addParam("remark",remark);
		}
		
		model.addObject("sendDate", sendDate);
		model.addObject("usecarDate", usecarDate);
		model.addObject("useType", useType);
		model.addObject("customerName", customerName);
		model.addObject("telephone", telephone);
		model.addObject("taobaoId", taobaoId);
		model.addObject("weixinCode", weixinCode);
		model.addObject("pickPeople", pickPeople);
		model.addObject("remark", remark);
		
		model.addObject("pageSize", pageSize);
		model.addObject("page", page);
		model.addObject("parentId", parentId);
		model.addObject("ownId", ownId);
		model.addObject("oaSetcarList", oaSetcarList);
		return model;
	}

	
	
	/**
	 * 跳转订车记录添加页面
	 */
	@RequestMapping(value="/toAddOaKf.do")
    public ModelAndView oaKfAddPage(
    		@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
    		HttpServletRequest req,HttpServletResponse resp) {
		HttpSession session = req.getSession();
		ModelAndView model = new ModelAndView("/oa/kf_add");
		
		//获取客服信息
    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
		if (null != _loginUser) {
			model.addObject("loginUser",_loginUser);
			model.addObject("parentId", parentId);
			model.addObject("ownId", ownId);
		}
        return model;
    }
	
	/**
	 * 客服订车记录添加
	 * @return
	 */
	@RequestMapping(value = "/doAddOaKf.do", method = RequestMethod.POST)
	public ResponseEntity<String> doAddOaKf(
			@RequestParam(value = "sendDate", required = false, defaultValue = "") String sendDate,
			@RequestParam(value = "usecarDate", required = false, defaultValue = "") String usecarDate,
			@RequestParam(value = "useType", required = false, defaultValue = "") Integer useType,
			@RequestParam(value = "flightNumber", required = false, defaultValue = "") String flightNumber,
			@RequestParam(value = "customerName", required = false, defaultValue = "") String customerName,
			@RequestParam(value = "peopleNumber", required = false, defaultValue = "") Integer peopleNumber,
			@RequestParam(value = "telephone", required = false, defaultValue = "") String telephone,
			@RequestParam(value = "taobaoId", required = false, defaultValue = "") String taobaoId,
			@RequestParam(value = "weixinCode", required = false, defaultValue = "") String weixinCode,
			@RequestParam(value = "qqCode", required = false, defaultValue = "") String qqCode,
			@RequestParam(value = "pickPeople", required = false, defaultValue = "") String pickPeople,
			@RequestParam(value = "memCode", required = false, defaultValue = "") String memCode,
			@RequestParam(value = "remark", required = false, defaultValue = "") String remark,
			@RequestParam(value = "uid", required = false, defaultValue = "") Integer uid,
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..订车记录添加!");
		String msg="";
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpSession session = request.getSession();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {

				//new TOaSetcar
				TOaSetcar car = new TOaSetcar();
				
				car.setUseType(useType);//类型
				car.setTargetDate(TimeUtil.nowDate());//咨询日期，预定日
				car.setOperateId(_loginUser.getId());//操作员id
				car.setCustomerName(customerName);//姓名
				car.setFlightNumber(flightNumber);//航班
				car.setMemCode(memCode);//会员号
				car.setTaobaoId(taobaoId);//淘宝
				car.setWeixinCode(weixinCode);//微信
				car.setQqCode(qqCode);//QQ
				car.setUsecarDate(usecarDate.replaceAll("-", ""));//接送日期
				car.setTelephone(telephone);//联系电话
				car.setPeopleNumber(peopleNumber);
				car.setPickPeople(pickPeople);
				car.setRemark(remark);
				car.setSendDate(sendDate);
				
				int result = oaService.addOaSetcar(car);
				if(result > 0){
					msg="订车记录添加成功!";
				}else{
					msg="订车记录添加失败!";
				}
			}
		}catch(Exception e){
			logger.error("controller:订车记录添加异常!"+customerName,e);
			msg="订车记录添加出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>alert('" + msg + "');location.href='" + WebUtils.formatURI(request, "/oakfmanage.do?parentId="+parentId+"&ownId="+ownId)+"'</script>",responseHeaders, HttpStatus.CREATED);
		}
		logger.info("controller:订车记录添加结束!");
		return new ResponseEntity<String>("<script>alert('" + msg + "');location.href='" + WebUtils.formatURI(request, "/oakfmanage.do?parentId="+parentId+"&ownId="+ownId)+"'</script>",responseHeaders, HttpStatus.CREATED);
		//return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/oakfmanage.do?parentId="+parentId+"&ownId="+ownId)+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	
	/**
	 * 订车记录编辑页面
	 * @return
	 */
	@RequestMapping(value = "/toEditOaKf.do", method = RequestMethod.GET)
	public ModelAndView oaKfEditPage(
			@RequestParam(value = "carId", required = false, defaultValue = "") Integer carId,
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			HttpServletRequest request,HttpServletResponse response) {
		logger.info("controller:..订车记录编辑页面!");
		ModelAndView model = new ModelAndView("/oa/kf_edit");
		HttpSession session = request.getSession();
		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new course
				TOaSetcarDTO car = oaService.findTOaSetcarDTO(carId);
				model.addObject("car", car);
			}
		}catch(Exception e){
			logger.error("controller:订车记录编辑页面异常!"+carId,e);
		}
		model.addObject("parentId", parentId);
		model.addObject("ownId", ownId);
        return model;
	}
	
	/**
	 * 订车记录修改
	 * @return
	 */
	@RequestMapping(value = "/doEditOaKf.do", method = RequestMethod.POST)
	public ResponseEntity<String> doEditOaKf(
			@RequestParam(value = "sendDate", required = false, defaultValue = "") String sendDate,
			@RequestParam(value = "usecarDate", required = false, defaultValue = "") String usecarDate,
			@RequestParam(value = "useType", required = false, defaultValue = "") Integer useType,
			@RequestParam(value = "flightNumber", required = false, defaultValue = "") String flightNumber,
			@RequestParam(value = "customerName", required = false, defaultValue = "") String customerName,
			@RequestParam(value = "peopleNumber", required = false, defaultValue = "") Integer peopleNumber,
			@RequestParam(value = "telephone", required = false, defaultValue = "") String telephone,
			@RequestParam(value = "taobaoId", required = false, defaultValue = "") String taobaoId,
			@RequestParam(value = "weixinCode", required = false, defaultValue = "") String weixinCode,
			@RequestParam(value = "qqCode", required = false, defaultValue = "") String qqCode,
			@RequestParam(value = "pickPeople", required = false, defaultValue = "") String pickPeople,
			@RequestParam(value = "memCode", required = false, defaultValue = "") String memCode,
			@RequestParam(value = "remark", required = false, defaultValue = "") String remark,
			@RequestParam(value = "uid", required = false, defaultValue = "") Integer uid,
			@RequestParam(value = "carId", required = false, defaultValue = "") Integer carId,
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..订车记录修改!");
		String msg="";
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpSession session = request.getSession();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
			
		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new car
				TOaSetcar car = oaService.findSetcar(carId);
				
				car.setUseType(useType);//类型
				car.setTargetDate(TimeUtil.nowDate());//咨询日期，预定日
				car.setOperateId(_loginUser.getId());//操作员id
				car.setCustomerName(customerName);//姓名
				car.setFlightNumber(flightNumber);//航班
				car.setMemCode(memCode);//会员号
				car.setTaobaoId(taobaoId);//淘宝
				car.setWeixinCode(weixinCode);//微信
				car.setQqCode(qqCode);//QQ
				car.setUsecarDate(usecarDate.replaceAll("-", ""));//接送日期
				car.setTelephone(telephone);//联系电话
				car.setPeopleNumber(peopleNumber);
				car.setPickPeople(pickPeople);
				car.setRemark(remark);
				car.setSendDate(sendDate);
				
				oaService.editOaSetcar(car);
				msg="订车记录修改成功!";
			}else{
				msg="用户未登录!";
			}
		}catch(Exception e){
			logger.error("controller:订车记录修改异常!"+carId,e);
			msg="订车记录修改出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>alert('" + msg + "');location.href='" + WebUtils.formatURI(request, "/oakfmanage.do?parentId="+parentId+"&ownId="+ownId)+"'</script>",responseHeaders, HttpStatus.CREATED);
		}
		logger.info("controller:订车记录修改结束!");
		return new ResponseEntity<String>("<script>alert('" + msg + "');location.href='" + WebUtils.formatURI(request, "/oakfmanage.do?parentId="+parentId+"&ownId="+ownId)+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	
	
	/**
	 * 订车记录删除页面
	 * @return
	 */
	@RequestMapping(value = "/toDelOaKf.do", method = RequestMethod.GET)
	public ModelAndView toDelOaKfPage(
			@RequestParam(value = "carId", required = false, defaultValue = "") Integer carId,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			HttpServletRequest request,HttpServletResponse response) {
		logger.info("controller:..订车记录删除面!");
		ModelAndView model = new ModelAndView("/oa/kf_del");
		HttpSession session = request.getSession();
		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new course
//				TOaSetcarDTO car = oaService.findTOaSetcarDTO(carId);
//				model.addObject("car", car);
				try {
					//get请求转换搜索的中文，防止出现乱码问题
					String applyMethod = request.getMethod();
					if(applyMethod.equalsIgnoreCase("get")){
						name = new String(name.getBytes("iso-8859-1"),Constants.CHARSET_UTF8);
					}
				} catch (UnsupportedEncodingException e) {
					name="";
					e.printStackTrace();
				}
			}
		}catch(Exception e){
			logger.error("controller:订车记录删除页面异常!"+carId,e);
		}
		model.addObject("parentId", parentId);
		model.addObject("ownId", ownId);
		model.addObject("name", name);
		model.addObject("carId", carId);
		
        return model;
	}
	/**
	 * 订车记录删除
	 * @return
	 */
	@RequestMapping(value = "/doDelOaKf.do", method = RequestMethod.POST)
	public ResponseEntity<String> doDeloaKf(
			@RequestParam(value = "carId", required = false, defaultValue = "") Integer carId,
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..订车记录删除!");
		String msg="";
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpSession session = request.getSession();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try{
			
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new car
				TOaSetcar car = oaService.findSetcar(carId);
				
				oaService.delOaSetcar(car);
				msg="订车记录删除成功!";
			}else{
				msg="用户未登录!";
			}
			
		}catch(Exception e){
			logger.error("controller:订车记录删除异常!"+carId,e);
			msg="订车记录删除出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>alert('" + msg + "');window.location.href='" + WebUtils.formatURI(request, "/oakfmanage.do?parentId="+parentId+"&ownId="+ownId)+"'</script>",responseHeaders, HttpStatus.CREATED);
		}
		logger.info("controller:订车记录删除结束!");
		return new ResponseEntity<String>("<script>alert('" + msg + "'); window.location.href='" + WebUtils.formatURI(request, "/oakfmanage.do?parentId="+parentId+"&ownId="+ownId)+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	
	
	/**
	 * 客服查看
	 * @return
	 */
	@RequestMapping(value = "/oaKfView.do", method = RequestMethod.GET)
	public ModelAndView oaKfView(
			@RequestParam(value = "id", required = false, defaultValue = "0") Integer id,
			@RequestParam(value = "status", required = false, defaultValue = "9") Integer status,
			HttpServletRequest request,HttpServletResponse response) {
		logger.info("controller:..客服查看!");
		ModelAndView model = new ModelAndView("/oa/kf_view");
		HttpSession session = request.getSession();
		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new course
//				MukeCourse course = courseService.findCourse(id);
//				
//				SysAttachment sysAttachment = new SysAttachment();
//				sysAttachment.setAid(course.getVideoId());//附件id
//				sysAttachment.setType(Constants.ATTACH_TYPE_VIDEO);//视频类型
//				SysAttachment attachment = uploadService.getFile(sysAttachment);
//				model.addObject("attachment", attachment);
//				model.addObject("course", course);
			}
		}catch(Exception e){
			logger.error("controller:客服查看异常!"+id,e);
		}
        return model;
	}
	
	
	
	
	
	
	
	
	
	/******************************激活码操作*********************/
	
	/**
	 * 跳转激活码记录管理页面
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/oajhmmanage.do")
	public ModelAndView oaJhmManagePage(
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			@RequestParam(value = "masterCard", required = false, defaultValue = "") String masterCard,
			@RequestParam(value = "username", required = false, defaultValue = "") String username,
			@RequestParam(value = "terminalId", required = false, defaultValue = "") String terminalId,
			@RequestParam(value = "taobaoId", required = false, defaultValue = "") String taobaoId,
			@RequestParam(value = "weixinCode", required = false, defaultValue = "") String weixinCode,
			@RequestParam(value = "deliverCode", required = false, defaultValue = "") String deliverCode,
			@RequestParam(value = "remark", required = false, defaultValue = "") String remark,
			
			@RequestParam(value = "pageNo", required = false, defaultValue = "") Integer pageNo) {
		// 获取激活码以及等级
		if (null == pageNo) {
			pageNo = initPageNo;
		}
		// 返回激活码列表页
		ModelAndView model = new ModelAndView("/oa/jhm_manage");
		model.addObject("masterCard", masterCard);
		
		// 返回的page对象
		page = oaService.findAllTOaGiffgaff(masterCard,username,terminalId,taobaoId,weixinCode,deliverCode,remark, pageNo, pageSize);
		// 激活码列表
		List<TOaGiffgaff> giffgaffList = (List<TOaGiffgaff>) page.getList();

		// 翻页带参数
		if(null != masterCard){
			page.addParam("masterCard",masterCard);
		}
		model.addObject("pageSize", pageSize);
		model.addObject("page", page);
		
		model.addObject("parentId", parentId);
		model.addObject("ownId", ownId);
		
		model.addObject("giffgaffList", giffgaffList);
		model.addObject("masterCard", masterCard);
		
		model.addObject("username", username);
		model.addObject("terminalId", terminalId);
		model.addObject("taobaoId", taobaoId);
		model.addObject("weixinCode", weixinCode);
		model.addObject("deliverCode", deliverCode);
		model.addObject("remark", remark);
		return model;
	}
	
	
	/**
	 * 跳转激活码添加页面
	 */
	@RequestMapping(value="/toAddOaJhm.do")
    public ModelAndView oaJhmAddPage(
    		@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			HttpServletRequest req,HttpServletResponse resp) {
		HttpSession session = req.getSession();
		ModelAndView model = new ModelAndView("/oa/jhm_add");
		logger.info("跳转激活码添加页面....");
		//获取登录用户信息
    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
		if (null != _loginUser) {
			// 登录用户
			model.addObject("loginUser",_loginUser);
			model.addObject("parentId", parentId);
			model.addObject("ownId", ownId);
		}
        return model;
    }
	
	
	/**
	 * 激活码添加
	 * @return
	 */
	@RequestMapping(value = "/doAddOaJhm.do", method = RequestMethod.POST)
	public ResponseEntity<String> doAddOaJhm(
			@RequestParam(value = "buyDate", required = false, defaultValue = "") String buyDate,
			@RequestParam(value = "packDate", required = false, defaultValue = "") String packDate,
			@RequestParam(value = "masterCard", required = false, defaultValue = "") String masterCard,
			@RequestParam(value = "sliverCard", required = false, defaultValue = "") String sliverCard,
			@RequestParam(value = "username", required = false, defaultValue = "") String username,
			@RequestParam(value = "terminalId", required = false, defaultValue = "") String terminalId,
			@RequestParam(value = "taobaoId", required = false, defaultValue = "") String taobaoId,
			@RequestParam(value = "weixinCode", required = false, defaultValue = "") String weixinCode,
			@RequestParam(value = "deliverCode", required = false, defaultValue = "") String deliverCode,
			@RequestParam(value = "remark", required = false, defaultValue = "") String remark,
			@RequestParam(value = "amount", required = false, defaultValue = "") String amount,
			@RequestParam(value = "uid", required = false, defaultValue = "") Integer uid,
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..激活码添加!");
		String msg="";
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpSession session = request.getSession();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {

				//new giffgaff
				TOaGiffgaff giffgaff = new TOaGiffgaff();
				
				giffgaff.setAmount(amount==null||amount==""?0.0:Double.valueOf(amount));
				giffgaff.setBuyDate(buyDate==null?"":buyDate.replaceAll("-", ""));
				giffgaff.setDeliverCode(deliverCode);//快递单
				giffgaff.setMasterCard(masterCard);//激活码
				giffgaff.setPackDate(packDate==null?"":packDate.replaceAll("-", ""));
				giffgaff.setRemark(remark);
				giffgaff.setSliverCard(sliverCard);
				giffgaff.setTaobaoId(taobaoId);
				giffgaff.setTerminalId(terminalId);
				giffgaff.setUsername(username);
				giffgaff.setWeixinCode(weixinCode);
				giffgaff.setOperateId(_loginUser.getId());
				
				int result = oaService.addOaGiffgaff(giffgaff);
				if(result > 0){
					msg="激活码记录添加成功!";
				}else{
					msg="激活码记录添加失败!";
				}
			
			}
		}catch(Exception e){
			e.printStackTrace();
			logger.error("controller:激活码添加异常!"+username+"--"+masterCard,e);
			msg="激活码添加出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>alert('" + msg + "');location.href='" + WebUtils.formatURI(request, "/oajhmmanage.do?parentId="+parentId+"&ownId="+ownId)+"'</script>",responseHeaders, HttpStatus.CREATED);
		}
		logger.info("controller:激活码添加结束!");
		return new ResponseEntity<String>("<script>alert('" + msg + "');location.href='" + WebUtils.formatURI(request, "/oajhmmanage.do?parentId="+parentId+"&ownId="+ownId)+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	
	/**
	 * 激活码编辑页面
	 * @return
	 */
	@RequestMapping(value = "/toEditOaJhm.do", method = RequestMethod.GET)
	public ModelAndView oaJhmEditPage(
			@RequestParam(value = "jhmId", required = false, defaultValue = "") Integer jhmId,
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			HttpServletRequest request,HttpServletResponse response) {
		logger.info("controller:..激活码编辑页面!");
		ModelAndView model = new ModelAndView("/oa/jhm_edit");
		HttpSession session = request.getSession();
		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new TOaGiffgaff
				TOaGiffgaffDTO giffgaff = oaService.findTOaGiffgaffDTO(jhmId);
				
				model.addObject("giffgaff", giffgaff);
				
			}
		}catch(Exception e){
			logger.error("controller:激活码编辑页面异常!"+jhmId,e);
		}
		model.addObject("parentId", parentId);
		model.addObject("ownId", ownId);
        return model;
	}
	
	/**
	 * 激活码修改
	 * @return
	 */
	@RequestMapping(value = "/doEditOaJhm.do", method = RequestMethod.POST)
	public ResponseEntity<String> oaJhmEdit(
			@RequestParam(value = "jhmId", required = false, defaultValue = "") Integer jhmId,
			@RequestParam(value = "buyDate", required = false, defaultValue = "") String buyDate,
			@RequestParam(value = "packDate", required = false, defaultValue = "") String packDate,
			@RequestParam(value = "masterCard", required = false, defaultValue = "") String masterCard,
			@RequestParam(value = "sliverCard", required = false, defaultValue = "") String sliverCard,
			@RequestParam(value = "username", required = false, defaultValue = "") String username,
			
			@RequestParam(value = "terminalId", required = false, defaultValue = "") String terminalId,
			@RequestParam(value = "taobaoId", required = false, defaultValue = "") String taobaoId,
			@RequestParam(value = "weixinCode", required = false, defaultValue = "") String weixinCode,
			@RequestParam(value = "deliverCode", required = false, defaultValue = "") String deliverCode,
			@RequestParam(value = "remark", required = false, defaultValue = "") String remark,
			@RequestParam(value = "amount", required = false, defaultValue = "") double amount,
			@RequestParam(value = "uid", required = false, defaultValue = "") Integer uid,
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..激活码修改!");
		String msg="";
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpSession session = request.getSession();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
			
		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new giffgaff
				TOaGiffgaff giffgaff = oaService.findGiffgaff(jhmId);
				
				giffgaff.setAmount(amount);
				giffgaff.setBuyDate(buyDate==null?"":buyDate.replaceAll("-", ""));
				giffgaff.setDeliverCode(deliverCode);//快递单
				giffgaff.setMasterCard(masterCard);//激活码
				giffgaff.setPackDate(packDate==null?"":packDate.replaceAll("-", ""));
				giffgaff.setRemark(remark);
				giffgaff.setSliverCard(sliverCard);
				giffgaff.setTaobaoId(taobaoId);
				giffgaff.setTerminalId(terminalId);
				giffgaff.setUsername(username);
				giffgaff.setWeixinCode(weixinCode);
				giffgaff.setOperateId(_loginUser.getId());
				
				oaService.editOaGiffgaff(giffgaff);
				msg="激活码修改成功!";
			}else{
				msg="用户未登录!";
			}
		}catch(Exception e){
			logger.error("controller:激活码修改异常!"+jhmId,e);
			msg="激活码修改出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>alert('" + msg + "');location.href='" + WebUtils.formatURI(request, "/oajhmmanage.do?parentId="+parentId+"&ownId="+ownId)+"'</script>",responseHeaders, HttpStatus.CREATED);
		}
		logger.info("controller:激活码修改结束!");
		return new ResponseEntity<String>("<script>alert('" + msg + "');location.href='" + WebUtils.formatURI(request, "/oajhmmanage.do?parentId="+parentId+"&ownId="+ownId)+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	/**
	 * 激活码删除页面
	 * @return
	 */
	@RequestMapping(value = "/toOaJhmDel.do", method = RequestMethod.GET)
	public ModelAndView toDelOaJhmPage(
			@RequestParam(value = "jhmId", required = false, defaultValue = "") Integer jhmId,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			HttpServletRequest request,HttpServletResponse response) {
		logger.info("controller:..激活码删除页面!");
		ModelAndView model = new ModelAndView("/oa/jhm_del");
		HttpSession session = request.getSession();
		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new TOaGiffgaff
				try {
					//get请求转换搜索的中文，防止出现乱码问题
					String applyMethod = request.getMethod();
					if(applyMethod.equalsIgnoreCase("get")){
						name = new String(name.getBytes("iso-8859-1"),Constants.CHARSET_UTF8);
					}
				} catch (UnsupportedEncodingException e) {
					name="";
					e.printStackTrace();
				}
			}
		}catch(Exception e){
			logger.error("controller:激活码删除页面异常!"+jhmId,e);
		}
		model.addObject("parentId", parentId);
		model.addObject("ownId", ownId);
		model.addObject("jhmId", jhmId);
		model.addObject("name", name);
        return model;
	}
	
	/**
	 * 激活码删除
	 * @return
	 */
	@RequestMapping(value = "/doOaJhmDel.do", method = RequestMethod.POST)
	public ResponseEntity<String> doDelOaJhm(
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			@RequestParam(value = "jhmId", required = false, defaultValue = "") Integer jhmId,
			@RequestParam(value = "status", required = false, defaultValue = "9") Integer status,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..激活码删除!");
		String msg="";
//		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpSession session = request.getSession();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try{
			
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new giffgaff
				TOaGiffgaff giffgaff = oaService.findGiffgaff(jhmId);
				
				oaService.delOaGiffgaff(giffgaff);
				msg="激活码删除成功!";
			}else{
				msg="用户未登录!";
			}
		}catch(Exception e){
			logger.error("controller:激活码删除异常!"+jhmId,e);
			msg="激活码删除出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>alert('" + msg + "');window.location.href='" + WebUtils.formatURI(request, "/oajhmmanage.do?parentId="+parentId+"&ownId="+ownId)+"'</script>",responseHeaders, HttpStatus.CREATED);			
		}
		logger.info("controller:激活码删除结束!");
		return new ResponseEntity<String>("<script>alert('" + msg + "');window.location.href='" + WebUtils.formatURI(request, "/oajhmmanage.do?parentId="+parentId+"&ownId="+ownId)+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	
	
	/**
	 * 激活码查看
	 * @return
	 */
	@RequestMapping(value = "/oaJhmView.do", method = RequestMethod.GET)
	public ModelAndView oaJhmView(
			@RequestParam(value = "id", required = false, defaultValue = "0") Integer id,
			@RequestParam(value = "status", required = false, defaultValue = "9") Integer status,
			HttpServletRequest request,HttpServletResponse response) {
		logger.info("controller:..客服查看!");
		ModelAndView model = new ModelAndView("/oa/kf_view");
		HttpSession session = request.getSession();
		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new course
//				MukeCourse course = courseService.findCourse(id);
//				
//				SysAttachment sysAttachment = new SysAttachment();
//				sysAttachment.setAid(course.getVideoId());//附件id
//				sysAttachment.setType(Constants.ATTACH_TYPE_VIDEO);//视频类型
//				SysAttachment attachment = uploadService.getFile(sysAttachment);
//				model.addObject("attachment", attachment);
//				model.addObject("course", course);
			}
		}catch(Exception e){
			logger.error("controller:客服查看异常!"+id,e);
		}
        return model;
	}
	
	
	
	
	
	/**********扩展页面***********/
	/**
	 * 跳转a卡记录管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/oaacardmanage.do")
	public ModelAndView oaAcardManagePage(
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			
			@RequestParam(value = "masterCard", required = false, defaultValue = "") String masterCard,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "startDate", required = false, defaultValue = "") String startDate,
			@RequestParam(value = "pageNo", required = false, defaultValue = "") Integer pageNo) {
		// 获取激活码以及等级
		if (null == pageNo) {
			pageNo = initPageNo;
		}
		// 返回激活码列表页
		ModelAndView model = new ModelAndView("/oa/acard_manage");
		model.addObject("masterCard", masterCard);
		masterCard = "A卡记录";
		
		model.addObject("pageSize", pageSize);
		model.addObject("page", page);
		
		model.addObject("parentId", parentId);
		model.addObject("ownId", ownId);
		
		model.addObject("masterCard", masterCard);
		
		return model;
	}
	/**
	 * 跳转b卡记录管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/oabcardmanage.do")
	public ModelAndView oaBcardManagePage(
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			
			@RequestParam(value = "masterCard", required = false, defaultValue = "") String masterCard,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "startDate", required = false, defaultValue = "") String startDate,
			@RequestParam(value = "pageNo", required = false, defaultValue = "") Integer pageNo) {
		// 获取激活码以及等级
		if (null == pageNo) {
			pageNo = initPageNo;
		}
		// 返回激活码列表页
		ModelAndView model = new ModelAndView("/oa/bcard_manage");
		model.addObject("masterCard", masterCard);
		masterCard = "B卡记录";
		
		model.addObject("pageSize", pageSize);
		model.addObject("page", page);
		
		model.addObject("parentId", parentId);
		model.addObject("ownId", ownId);
		
		model.addObject("masterCard", masterCard);
		
		return model;
	}
	/**
	 * 跳转c卡记录管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/oaccardmanage.do")
	public ModelAndView oaCcardManagePage(
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			
			@RequestParam(value = "masterCard", required = false, defaultValue = "") String masterCard,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "startDate", required = false, defaultValue = "") String startDate,
			@RequestParam(value = "pageNo", required = false, defaultValue = "") Integer pageNo) {
		// 获取激活码以及等级
		if (null == pageNo) {
			pageNo = initPageNo;
		}
		// 返回激活码列表页
		ModelAndView model = new ModelAndView("/oa/ccard_manage");
		model.addObject("masterCard", masterCard);
		masterCard = "C卡记录";
		
		model.addObject("pageSize", pageSize);
		model.addObject("page", page);
		
		model.addObject("parentId", parentId);
		model.addObject("ownId", ownId);
		
		model.addObject("masterCard", masterCard);
		
		return model;
	}
	/**
	 * 跳转d卡记录管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/oadcardmanage.do")
	public ModelAndView oaDcardManagePage(
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			
			@RequestParam(value = "masterCard", required = false, defaultValue = "") String masterCard,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "startDate", required = false, defaultValue = "") String startDate,
			@RequestParam(value = "pageNo", required = false, defaultValue = "") Integer pageNo) {
		// 获取激活码以及等级
		if (null == pageNo) {
			pageNo = initPageNo;
		}
		// 返回激活码列表页
		ModelAndView model = new ModelAndView("/oa/dcard_manage");
		model.addObject("masterCard", masterCard);
		masterCard = "D卡记录";
		
		model.addObject("pageSize", pageSize);
		model.addObject("page", page);
		
		model.addObject("parentId", parentId);
		model.addObject("ownId", ownId);
		
		model.addObject("masterCard", masterCard);
		
		return model;
	}
	/**
	 * 跳转e卡记录管理页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/oaecardmanage.do")
	public ModelAndView oaEcardManagePage(
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			
			@RequestParam(value = "masterCard", required = false, defaultValue = "") String masterCard,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "startDate", required = false, defaultValue = "") String startDate,
			@RequestParam(value = "pageNo", required = false, defaultValue = "") Integer pageNo) {
		// 获取激活码以及等级
		if (null == pageNo) {
			pageNo = initPageNo;
		}
		// 返回激活码列表页
		ModelAndView model = new ModelAndView("/oa/ecard_manage");
		model.addObject("masterCard", masterCard);
		masterCard = "E卡记录";
		
		model.addObject("pageSize", pageSize);
		model.addObject("page", page);
		
		model.addObject("parentId", parentId);
		model.addObject("ownId", ownId);
		
		model.addObject("masterCard", masterCard);
		
		return model;
	}
	
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Page getPage() {
		return page;
	}

	public int getInitPageNo() {
		return initPageNo;
	}

	public void setInitPageNo(int initPageNo) {
		this.initPageNo = initPageNo;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}
