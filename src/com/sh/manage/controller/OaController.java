package com.sh.manage.controller;

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
import com.sh.manage.entity.MukeCourse;
import com.sh.manage.entity.MukeCourseType;
import com.sh.manage.entity.SysAttachment;
import com.sh.manage.entity.TOaSetcar;
import com.sh.manage.module.page.Page;
import com.sh.manage.pojo.LoginUser;
import com.sh.manage.pojo.MukeCourseDTO;
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
	 * 跳转客服记录管理页面
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
		// 返回客服列表页
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

		// 客服列表
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
	 * 跳转客服添加页面
	 */
	@RequestMapping(value="/toAddOaKf.do")
    public ModelAndView oaKfAddPage(HttpServletRequest req,
			HttpServletResponse resp) {
		HttpSession session = req.getSession();
		ModelAndView model = new ModelAndView("/oa/kf_add");
		
		//获取客服信息
    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
		if (null != _loginUser) {
			// 客服类型

			model.addObject("loginUser",_loginUser);
		}
        return model;
    }
	
	
	/**
	 * 客服订车记录添加
	 * @return
	 */
	@RequestMapping(value = "/doAddOaKf.do", method = RequestMethod.POST)
	public ResponseEntity<String> oaKfAdd(
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
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..客服添加!");
		String msg="";
		boolean isCorrect = true;
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
				car.setTargetDate(TimeUtil.now());//咨询日期，预定日
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
					msg="客服订车记录添加成功!";
				}else{
					msg="客服订车记录添加失败!";
				}
			
			}
		}catch(Exception e){
			logger.error("controller:客服订车记录添加异常!"+customerName,e);
			msg="客服订车记录添加出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/oakfmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
		}
		logger.info("controller:客服订车记录添加结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/oakfmanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	
	/**
	 * 客服编辑页面
	 * @return
	 */
	@RequestMapping(value = "/toEditOaKf.do", method = RequestMethod.POST)
	public ModelAndView oaKfEditPage(
			@RequestParam(value = "courseId", required = false, defaultValue = "") Integer courseId,
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			HttpServletRequest request,HttpServletResponse response) {
		logger.info("controller:..客服编辑页面!");
		ModelAndView model = new ModelAndView("/course/course_edit");
		HttpSession session = request.getSession();
		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new course
				MukeCourseDTO course = courseService.findCourseDTO(courseId);
				if(null!= course.getVideoId() && course.getVideoId() > 0){
					SysAttachment sysAttachment = new SysAttachment();
					sysAttachment.setAid(course.getVideoId());//附件id
					sysAttachment.setType(Constants.ATTACH_TYPE_VIDEO);//视频类型
					SysAttachment attachment = uploadService.getFile(sysAttachment);
					model.addObject("attachment", attachment);
				}
				model.addObject("course", course);
				
			}
		}catch(Exception e){
			logger.error("controller:客服编辑页面异常!"+courseId,e);
		}
		model.addObject("parentId", parentId);
		model.addObject("ownId", ownId);
        return model;
	}
	
	/**
	 * 客服修改
	 * @return
	 */
	@RequestMapping(value = "/doEditOaKf.do", method = RequestMethod.POST)
	public ResponseEntity<String> oaKfEdit(
			@RequestParam(value = "id", required = false, defaultValue = "0") Integer id,
			@RequestParam(value = "typeId", required = false, defaultValue = "0") Integer typeId,
			@RequestParam(value = "img", required = false, defaultValue = "") String img,
			@RequestParam(value = "info", required = false, defaultValue = "") String info,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "uid", required = false, defaultValue = "") Integer uid,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..客服修改!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpSession session = request.getSession();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
			
		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new course
				MukeCourse course = courseService.findCourse(id);
				course.setImg(img);
				course.setInfo(info);
				course.setName(name);
				course.setTitle(title);
				course.setTypeId(typeId);
				course.setUid(_loginUser.getId());
				
				courseService.editCourse(course);
				msg="客服修改成功!";
			}else{
				msg="用户未登录!";
			}
		}catch(Exception e){
			logger.error("controller:客服修改异常!"+name,e);
			msg="客服修改出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/coursemanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:客服修改结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/coursemanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	/**
	 * 客服删除
	 * @return
	 */
	@RequestMapping(value = "/oaKfDel.do", method = RequestMethod.POST)
	public ResponseEntity<String> oaKfDel(
			@RequestParam(value = "id", required = false, defaultValue = "0") Integer id,
			@RequestParam(value = "status", required = false, defaultValue = "9") Integer status,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..客服删除!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpSession session = request.getSession();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try{
			
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new course
				MukeCourse course = courseService.findCourse(id);
				
				courseService.delCourse(course);
				msg="客服删除成功!";
			}else{
				msg="用户未登录!";
			}
			
//			SysUser sUser 
//			= userService.findSysUser(uid);
//			
//			// get|new role
//			SysRole role = roleService.findSysRole(suRoleId);
//			
//			sUser.setStatus(status);//默认失效
//			sUser.getRoleList().add(null);//添加关联关系
//			
//			//role.getUserList().add(sUser);//添加关联关系
//			
//			userService.editSysUser(sUser);//删除是逻辑删除，仅仅是失效，客服;
			
		}catch(Exception e){
			logger.error("controller:客服删除异常!"+id,e);
			msg="客服删除出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/coursemanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:客服删除结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/coursemanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
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
				MukeCourse course = courseService.findCourse(id);
				
				SysAttachment sysAttachment = new SysAttachment();
				sysAttachment.setAid(course.getVideoId());//附件id
				sysAttachment.setType(Constants.ATTACH_TYPE_VIDEO);//视频类型
				SysAttachment attachment = uploadService.getFile(sysAttachment);
				model.addObject("attachment", attachment);
				model.addObject("course", course);
			}
		}catch(Exception e){
			logger.error("controller:客服查看异常!"+id,e);
		}
        return model;
	}
	
	
	
	
	
	
	
	
	
	/******************************激活码操作*********************/
	
	/**
	 * 跳转客服记录管理页面
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/oajhmmanage.do")
	public ModelAndView oaJhmManagePage(
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "startDate", required = false, defaultValue = "") String startDate,
			@RequestParam(value = "pageNo", required = false, defaultValue = "") Integer pageNo) {
		// 获取客服以及等级
		if (null == pageNo) {
			pageNo = initPageNo;
		}
		// 返回客服列表页
		ModelAndView model = new ModelAndView("/course/course_manage");
		model.addObject("name", name);
		model.addObject("startDate", startDate);
		// 返回的page对象
		page = courseService.findAllMukeCourse(
				name, startDate.replaceAll("-", ""),
				pageNo, pageSize);
		// 客服列表
		List<MukeCourse> courseList = (List<MukeCourse>) page.getList();

		// 客服类型
		List<MukeCourseType> courseTypeList = courseService.findAllCourseType();
		
		// 翻页带参数
		if(null != name){
			page.addParam("name",name);
		}
		if(null != startDate){
			page.addParam("startDate",startDate);
		}
		model.addObject("startDate", startDate);
		model.addObject("name", name);
		model.addObject("pageSize", pageSize);
		model.addObject("page", page);
		model.addObject("parentId", parentId);
		model.addObject("ownId", ownId);
		model.addObject("courseList", courseList);
		model.addObject("courseTypeList", courseTypeList);
		//model.addObject("roleList", roleList);
		return model;
	}
	
	
	/**
	 * 跳转客服添加页面
	 */
	@RequestMapping(value="/toAddOaJhm.do")
    public ModelAndView oaJhmAddPage(HttpServletRequest req,
			HttpServletResponse resp) {
		HttpSession session = req.getSession();
		ModelAndView model = new ModelAndView("/oa/kf_add");
		
		//获取客服信息
    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
		if (null != _loginUser) {
			// 客服类型
			List<MukeCourseType> courseTypeList = courseService.findAllCourseType();
			model.addObject("courseTypeList", courseTypeList);
			model.addObject("loginUser",_loginUser);
			logger.info("courseTypeList.size:"+courseTypeList.size());
		}
        return model;
    }
	
	
	/**
	 * 客服添加
	 * @return
	 */
	@RequestMapping(value = "/doAddOaJhm.do", method = RequestMethod.POST)
	public ResponseEntity<String> oaJhmAdd(
			@RequestParam(value = "typeId", required = false, defaultValue = "0") Integer typeId,
			@RequestParam(value = "img", required = false, defaultValue = "") String img,
			@RequestParam(value = "info", required = false, defaultValue = "") String info,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "uid", required = false, defaultValue = "") Integer uid,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..客服添加!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpSession session = request.getSession();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {

				//new course
				MukeCourse course = new MukeCourse();
				
				// get|new role
				//SysGroup group = groupService.findSysGroup(suGroupId);
				course.setCreateTime(TimeUtil.now());
				course.setImg(img);
				course.setInfo(info);
				course.setName(name);
				course.setTitle(title);
				course.setTypeId(typeId);
				course.setUid(_loginUser.getId());
				course.setStatus(Constants.COURSE_STATUS_INIT);//状态 0待审核  1已审核  2 已下线 ;默认为0
								
				int result = courseService.addCourse(course);
				if(result > 0){
					msg="客服添加成功!";
				}else{
					msg="客服添加失败!";
				}
			
			}
		}catch(Exception e){
			logger.error("controller:客服添加异常!"+name,e);
			msg="客服添加出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/coursemanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
		}
		logger.info("controller:客服添加结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/coursemanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	
	
	/**
	 * 激活码编辑页面
	 * @return
	 */
	@RequestMapping(value = "/toEditOaJhm.do", method = RequestMethod.POST)
	public ModelAndView oaJhmEditPage(
			@RequestParam(value = "courseId", required = false, defaultValue = "") Integer courseId,
			@RequestParam(value = "parentId", required = false, defaultValue = "") Integer parentId,
			@RequestParam(value = "ownId", required = false, defaultValue = "") Integer ownId,
			HttpServletRequest request,HttpServletResponse response) {
		logger.info("controller:..客服编辑页面!");
		ModelAndView model = new ModelAndView("/course/course_edit");
		HttpSession session = request.getSession();
		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new course
				MukeCourseDTO course = courseService.findCourseDTO(courseId);
				if(null!= course.getVideoId() && course.getVideoId() > 0){
					SysAttachment sysAttachment = new SysAttachment();
					sysAttachment.setAid(course.getVideoId());//附件id
					sysAttachment.setType(Constants.ATTACH_TYPE_VIDEO);//视频类型
					SysAttachment attachment = uploadService.getFile(sysAttachment);
					model.addObject("attachment", attachment);
				}
				model.addObject("course", course);
				
			}
		}catch(Exception e){
			logger.error("controller:客服编辑页面异常!"+courseId,e);
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
			@RequestParam(value = "id", required = false, defaultValue = "0") Integer id,
			@RequestParam(value = "typeId", required = false, defaultValue = "0") Integer typeId,
			@RequestParam(value = "img", required = false, defaultValue = "") String img,
			@RequestParam(value = "info", required = false, defaultValue = "") String info,
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "title", required = false, defaultValue = "") String title,
			@RequestParam(value = "uid", required = false, defaultValue = "") Integer uid,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..客服修改!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpSession session = request.getSession();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
			
		try{
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new course
				MukeCourse course = courseService.findCourse(id);
				course.setImg(img);
				course.setInfo(info);
				course.setName(name);
				course.setTitle(title);
				course.setTypeId(typeId);
				course.setUid(_loginUser.getId());
				
				courseService.editCourse(course);
				msg="客服修改成功!";
			}else{
				msg="用户未登录!";
			}
		}catch(Exception e){
			logger.error("controller:客服修改异常!"+name,e);
			msg="客服修改出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/coursemanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:客服修改结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/coursemanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
	}
	/**
	 * 激活码删除
	 * @return
	 */
	@RequestMapping(value = "/oaJhmDel.do", method = RequestMethod.POST)
	public ResponseEntity<String> oaJhmDel(
			@RequestParam(value = "id", required = false, defaultValue = "0") Integer id,
			@RequestParam(value = "status", required = false, defaultValue = "9") Integer status,
			HttpServletRequest request,HttpServletResponse response,
			Model model) {
		logger.info("controller:..客服删除!");
		String msg="";
		boolean isCorrect = true;
		HttpHeaders responseHeaders = new HttpHeaders();
		HttpSession session = request.getSession();
		responseHeaders.set("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		try{
			
			//获取客服信息
	    	LoginUser _loginUser = (LoginUser) session.getAttribute(SessionConstants.LOGIN_USER);
			if (null != _loginUser) {
				//get/new course
				MukeCourse course = courseService.findCourse(id);
				
				courseService.delCourse(course);
				msg="客服删除成功!";
			}else{
				msg="用户未登录!";
			}
			
//			SysUser sUser 
//			= userService.findSysUser(uid);
//			
//			// get|new role
//			SysRole role = roleService.findSysRole(suRoleId);
//			
//			sUser.setStatus(status);//默认失效
//			sUser.getRoleList().add(null);//添加关联关系
//			
//			//role.getUserList().add(sUser);//添加关联关系
//			
//			userService.editSysUser(sUser);//删除是逻辑删除，仅仅是失效，客服;
			
		}catch(Exception e){
			logger.error("controller:客服删除异常!"+id,e);
			msg="客服删除出现异常";
			model.addAttribute("msg", msg);
			return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/coursemanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
			
		}
		logger.info("controller:客服删除结束!");
		return new ResponseEntity<String>("<script>parent.callBack('msgdiv','" + msg + "'," + isCorrect + ");parent.close(); parent.location.href='" + WebUtils.formatURI(request, "/coursemanage.do")+"'</script>",responseHeaders, HttpStatus.CREATED);
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
				MukeCourse course = courseService.findCourse(id);
				
				SysAttachment sysAttachment = new SysAttachment();
				sysAttachment.setAid(course.getVideoId());//附件id
				sysAttachment.setType(Constants.ATTACH_TYPE_VIDEO);//视频类型
				SysAttachment attachment = uploadService.getFile(sysAttachment);
				model.addObject("attachment", attachment);
				model.addObject("course", course);
			}
		}catch(Exception e){
			logger.error("controller:客服查看异常!"+id,e);
		}
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
