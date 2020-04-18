package com.liquorcloud.liquor.common.model.dto;

import com.liquorcloud.liquor.common.model.entity.SysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zzc
 * 角色Dto
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleDTO extends SysRole {
	/**
	 * 角色部门Id
	 */
	private Integer roleDeptId;

	/**
	 * 部门名称
	 */
	private String deptName;
}
