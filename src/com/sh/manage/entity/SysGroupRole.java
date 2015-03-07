package com.sh.manage.entity;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author
 * 
 */

@Entity
@Table(name = "t_sys_group_role")
public class SysGroupRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7488904616028381006L;

	@Id
	@GeneratedValue(generator="sgroupGenerator",strategy = GenerationType.AUTO)
    @GenericGenerator(name = "sgroupGenerator", strategy = "native")
	@Column(name = "id", length = 8)
	private int id;

	@Column(name = "group_id", length = 8)
	private int groupId;
	@Column(name = "role_id", length = 8)
	private int roleId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	
}
