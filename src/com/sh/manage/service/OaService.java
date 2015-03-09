/**
 * 
 */
package com.sh.manage.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.manage.dao.OaJhmDao;
import com.sh.manage.dao.OaKfDao;
import com.sh.manage.entity.TOaGiffgaff;
import com.sh.manage.entity.TOaSetcar;
import com.sh.manage.exception.SPlatformServiceException;
import com.sh.manage.module.page.Page;
import com.sh.manage.pojo.TOaGiffgaffDTO;
import com.sh.manage.pojo.TOaSetcarDTO;

/**
 * 
 * 客服管理service
 * @author
 * 
 */
@Service
public class OaService extends BaseService {

	private Logger logger = Logger.getLogger(OaService.class);
	
	@Autowired
	private OaKfDao oaKfDao;
	
	
	@Autowired
	private OaJhmDao oaJhmDao;
	
	
	
	/**
	 * 查找订车记录
	 * @param course
	 */
	public TOaSetcar findSetcar(Integer id)throws SPlatformServiceException {
		try {
			List<TOaSetcar> setCarList = oaKfDao.findTOaSetcar(id);
			//找到了订车记录
			if(null != setCarList){
				return setCarList.get(0);
			}
			//找不到订车记录
			return new TOaSetcar();
		} catch (Exception e) {
			logger.error("service:查询订车记录信息出现异常", e);
			throw new SPlatformServiceException("查询订车记录信息出现异常");
		}
	}
	
	/**
	 * 订车记录管理页
	 * @param name
	 * @param replaceAll
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page findAllTOaSetcar(String usecarDate,Integer useType,String customerName, String telephone,String taobaoId, String weixinCode,String pickPeople, String remark,Integer pageNo, int pageSize) {
		return oaKfDao.getAllTOaSetcar(usecarDate, useType, customerName, telephone, taobaoId, weixinCode, pickPeople, remark, pageNo, pageSize);
	}
	
	
	
	/**
	 * 查找订车记录其他信息
	 * @param course
	 */
	public TOaSetcarDTO findTOaSetcarDTO(Integer id)throws SPlatformServiceException {
		try {
			List<TOaSetcarDTO> setcarDTOList = oaKfDao.findTOaSetcarDTO(id);
			//找到了订车记录
			if(null != setcarDTOList){
				return setcarDTOList.get(0);
			}
			//找不到订车记录
			return new TOaSetcarDTO();
		} catch (Exception e) {
			logger.error("service:查询订车记录信息出现异常", e);
			throw new SPlatformServiceException("查询订车记录信息出现异常");
		}
	}
	
	/**
	 * 订车记录添加
	 * @param course
	 */
	public Integer addOaSetcar(TOaSetcar oaSetcar) {
		return (Integer) oaKfDao.save(oaSetcar);
	}
	
	
	/**
	 * 订车记录修改
	 * @param course
	 */
	public void editOaSetcar(TOaSetcar oaSetcar) {
		oaKfDao.update(oaSetcar);
	}
	/**
	 * 订车记录删除
	 * @param course
	 */
	public void delOaSetcar(TOaSetcar oaSetcar) {
		oaKfDao.delete(oaSetcar);
	}
	
	
	/**********************************以下是激活码操作***********************/
	/**
	 * 激活码记录管理页
	 * @param name
	 * @param replaceAll
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page findAllTOaGiffgaff(String masterCard,String username,String terminalId,String taobaoId,String weixinCode,String deliverCode,String remark,Integer pageNo, int pageSize) {
		return oaJhmDao.getAllTOaGiffgaff(masterCard,username,terminalId,taobaoId,weixinCode,deliverCode,remark, pageNo, pageSize);
	}
	/**
	 * 查找激活码记录其他信息
	 * @param course
	 */
	public TOaGiffgaffDTO findTOaGiffgaffDTO(Integer id)throws SPlatformServiceException {
		try {
			List<TOaGiffgaffDTO> giffgaffDTOList = oaJhmDao.findTOaGiffgaffDTO(id);
			//找到了激活码记录
			if(null != giffgaffDTOList){
				return giffgaffDTOList.get(0);
			}
			//找不到激活码记录
			return new TOaGiffgaffDTO();
		} catch (Exception e) {
			logger.error("service:查询激活码记录信息出现异常", e);
			throw new SPlatformServiceException("查询激活码记录信息出现异常");
		}
	}
	
	/**
	 * 查找激活码记录
	 * @param course
	 */
	public TOaGiffgaff findGiffgaff(Integer id)throws SPlatformServiceException {
		try {
			List<TOaGiffgaff> giffgaffList = oaJhmDao.findTOaGiffgaff(id);
			//找到了激活码记录
			if(null != giffgaffList){
				return giffgaffList.get(0);
			}
			//找不到激活码记录
			return new TOaGiffgaff();
		} catch (Exception e) {
			logger.error("service:查询激活码记录信息出现异常", e);
			throw new SPlatformServiceException("查询激活码记录信息出现异常");
		}
	}
	
	
	/**
	 * 激活码记录添加
	 * @param course
	 */
	public Integer addOaGiffgaff(TOaGiffgaff oaGiffgaff) {
		return (Integer) oaJhmDao.save(oaGiffgaff);
	}
	
	
	/**
	 * 激活码记录修改
	 * @param course
	 */
	public void editOaGiffgaff(TOaGiffgaff oaGiffgaff) {
		oaJhmDao.update(oaGiffgaff);
	}
	/**
	 * 激活码记录删除
	 * @param course
	 */
	public void delOaGiffgaff(TOaGiffgaff oaGiffgaff) {
		oaJhmDao.delete(oaGiffgaff);
	}
}
