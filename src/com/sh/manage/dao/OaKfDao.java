package com.sh.manage.dao;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.sh.manage.entity.MukeCourseType;
import com.sh.manage.entity.TOaSetcar;
import com.sh.manage.module.page.Page;
import com.sh.manage.pojo.TOaSetcarDTO;

/**
 * 客服订车dao持久化操作
 * @author 
 *
 */
@Repository
public class OaKfDao extends AbstractBaseDao<TOaSetcar>{

	@Override
	public Integer addObject(TOaSetcar clazz) {
		// TODO Auto-generated method stub
		return (Integer) this.getCurrentSession().save(clazz);
	}

	@Override
	public void updateObject(TOaSetcar clazz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObject(TOaSetcar clazz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TOaSetcar getObject(TOaSetcar clazz) {
		return this.get("from TOaSetcar s where s.id = ? ", new Object[]{clazz.getId()});
	}

	/**
	 * 根据id查找订车记录
	 * @param uid
	 * @return
	 */
	public List<TOaSetcar> findTOaSetcar(Integer id) {
		String hql = "from TOaSetcar where id = ";
		hql += id;
		return this.find(hql);
	}

	/**
	 * 获取全部订车记录
	 * @param username
	 * @param startDate
	 * @param endDate
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getAllTOaSetcar(String usecarDate,Integer useType,String customerName, String telephone,String taobaoId, String weixinCode,String pickPeople, String remark,Integer pageNo, int pageSize) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select rt.* from (select s.id,s.target_date targetDate,s.usecar_date usecarDate,s.flight_number flightNumber ,s.use_type useType,s.customer_name customerName,"
				+ "s.people_number peopleNumber,s.telephone,s.taobao_id taobaoId,s.weixin_code weixinCode,s.qq_code qqCode,s.pick_people pickPeople,u.name operateName from t_oa_setcar s join t_sys_user u on s.operate_id=u.uid  ");
		sbf.append(" where 1 = 1 ");//有效的用户and s.status = 1
		
//		sbf.append("select rt.* from (select s.*,u.*,t.* from muke_course s join t_sys_user u on s.sys_user_id=u.uid left join muke_course_type t on s.type_id = t.id ");
//		sbf.append(" where 1 = 1 ");//有效的用户and s.status = 1
		Object[] params = new Object[]{};
		if(!StringUtils.isEmpty(usecarDate)){
			params = ArrayUtils.add(params, usecarDate);
			sbf.append(" and s.usecar_date >= ?");
		}
		if(null!=useType && useType > 0){
			params = ArrayUtils.add(params, useType);
			sbf.append(" and s.use_type = ?");
		}
		if(!StringUtils.isEmpty(remark)){
			//params = ArrayUtils.add(params, remark);
			sbf.append(" and s.remark like '%"+remark+"%'");
		}
		if(!StringUtils.isEmpty(customerName)){
			//params = ArrayUtils.add(params, customerName);
			sbf.append(" and s.customer_name like '%"+customerName+"%'");
		}
		if(!StringUtils.isEmpty(telephone)){
			//params = ArrayUtils.add(params, telephone);
			sbf.append(" and s.telephone like '%"+telephone+"%'");
		}
		if(!StringUtils.isEmpty(taobaoId)){
			//params = ArrayUtils.add(params, taobaoId);
			sbf.append(" and s.taobao_id like '%"+taobaoId+"%'");
		}
		if(!StringUtils.isEmpty(weixinCode)){
			//params = ArrayUtils.add(params, weixinCode);
			sbf.append(" and s.weixin_code like '%"+weixinCode+"%'");
		}
		if(!StringUtils.isEmpty(pickPeople)){
			params = ArrayUtils.add(params, pickPeople);
			sbf.append(" and s.pick_people = ?");
		}

		sbf.append(") as rt order by rt.id desc");
		return this.queryModelDTOListByPage(sbf.toString(), params, pageNo, pageSize, TOaSetcarDTO.class);
	}

	/**
	 * 所有订车记录类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<MukeCourseType> getAllCourseType() {
		String sql = "select id,name,number,remark,img from muke_course_type ";
		Object[] params = new Object[]{};
		return (List<MukeCourseType>) this.queryModelSqlList(sql,params,MukeCourseType.class);
	}

	/**
	 * 查询订车记录其他信息
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TOaSetcarDTO> findTOaSetcarDTO(Integer id) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select rt.* from (select s.id,s.target_date targetDate,s.usecar_date usecarDate,s.flight_number flightNumber ,s.use_type useType,s.customer_name customerName,"
				+ "s.people_number peopleNumber,s.telephone,s.taobao_id taobaoId,s.weixin_code weixinCode,s.qq_code qqCode,s.pick_people pickPeople,s.remark,u.name operateName from t_oa_setcar s join t_sys_user u on s.operate_id=u.uid  ");
		sbf.append(" where 1 = 1 ");//有效的用户and s.status = 1

		Object[] params = new Object[]{};
		
		if(id > 0){
			params = ArrayUtils.add(params, id);
			sbf.append(" and s.id = ? ");
		}
	

		sbf.append(") as rt order by rt.id desc");
		return (List<TOaSetcarDTO>) this.querysqlDTOList(sbf.toString(), params, TOaSetcarDTO.class);
	}
}
