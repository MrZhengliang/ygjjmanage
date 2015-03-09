/**
 * 
 */
package com.sh.manage.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.sh.manage.entity.SysRoleMenu;


/**
 * 角色数据访问类
 * 
 * @author
 * 
 */
@Repository
public class SysRoleDao extends AbstractBaseDao<SysRoleMenu> {

	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(SysRoleDao.class);


	public void addSysRoleMenu(SysRoleMenu sRoleMenu) {
		this.save(sRoleMenu);
	}


	@Override
	public Integer addObject(SysRoleMenu clazz) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void updateObject(SysRoleMenu clazz) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void deleteObject(SysRoleMenu clazz) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public SysRoleMenu getObject(SysRoleMenu clazz) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
