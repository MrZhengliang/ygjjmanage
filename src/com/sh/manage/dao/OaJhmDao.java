package com.sh.manage.dao;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import com.sh.manage.entity.TOaGiffgaff;
import com.sh.manage.module.page.Page;
import com.sh.manage.pojo.TOaGiffgaffDTO;

/**
 * 激活码dao持久化操作
 * @author 
 *
 */
@Repository
public class OaJhmDao extends AbstractBaseDao<TOaGiffgaff>{

	@Override
	public Integer addObject(TOaGiffgaff clazz) {
		// TODO Auto-generated method stub
		return (Integer) this.getCurrentSession().save(clazz);
	}

	@Override
	public void updateObject(TOaGiffgaff clazz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObject(TOaGiffgaff clazz) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TOaGiffgaff getObject(TOaGiffgaff clazz) {
		return this.get("from TOaGiffgaff s where s.id = ? ", new Object[]{clazz.getId()});
	}

	/**
	 * 根据id查找激活码记录
	 * @param uid
	 * @return
	 */
	public List<TOaGiffgaff> findTOaSetcar(Integer id) {
		String hql = "from TOaGiffgaff where id = ";
		hql += id;
		return this.find(hql);
	}

	/**
	 * 获取全部激活码记录
	 * @param username
	 * @param startDate
	 * @param endDate
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Page getAllTOaGiffgaff(String masterCard,Integer pageNo, int pageSize) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select rt.* from (select s.id,s.buy_date buyDate,s.pack_date packDate,s.master_card masterCard,s.sliver_card sliverCard,s.username,s.terminal_id terminalId,"
				+ "s.usetime_limit usetimeLimit,s.amount,s.taobao_id taobaoId,s.weixin_nickname weixinNickname,s.weixin_code weixinCode,"
				+ "s.deliver_code deliverCode,s.remark,u.name operateName"
				+ " from t_oa_giffgaff s join t_sys_user u on s.operate_id=u.uid  ");
		
		Object[] params = new Object[]{};
		
		if(!StringUtils.isEmpty(masterCard)){
			params = ArrayUtils.add(params, masterCard);
			sbf.append(" and s.master_card = ?");
		}
		

		sbf.append(") as rt");
		return this.queryModelDTOListByPage(sbf.toString(), params, pageNo, pageSize, TOaGiffgaffDTO.class);
	}

	

	/**
	 * 查询激活码记录其他信息
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<TOaGiffgaffDTO> findTOaGiffgaffDTO(Integer id) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("select rt.* from (select s.id,s.buy_date buyDate,s.pack_date packDate,s.master_card masterCard,s.sliver_card sliverCard,s.username,s.terminal_id terminalId,"
				+ "s.usetime_limit usetimeLimit,s.amount,s.taobao_id taobaoId,s.weixin_nickname weixinNickname,s.weixin_code weixinCode,"
				+ "s.deliver_code deliverCode,s.remark,u.name operateName"
				+ " from t_oa_giffgaff s join t_sys_user u on s.operate_id=u.uid  ");
		sbf.append(" where 1 = 1 ");
		
		Object[] params = new Object[]{};
		
		if(id > 0){
			params = ArrayUtils.add(params, id);
			sbf.append(" and s.id = ? ");
		}
	
		sbf.append(") as rt");
		return (List<TOaGiffgaffDTO>) this.querysqlDTOList(sbf.toString(), params, TOaGiffgaffDTO.class);
	}
}
