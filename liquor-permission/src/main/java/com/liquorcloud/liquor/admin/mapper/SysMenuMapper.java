package com.liquorcloud.liquor.admin.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liquorcloud.liquor.common.model.entity.SysMenu;
import com.liquorcloud.liquor.common.model.vo.MenuVO;

import java.util.List;

/**
 * @author zzc
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

	/**
	 * 通过角色编号查询菜单
	 *
	 * @param roleId 角色ID
	 * @return
	 */
	List<MenuVO> listMenusByRoleId(Integer roleId);

	/**
	 * 通过角色ID查询权限
	 *
	 * @param roleIds Ids
	 * @return
	 */
	List<String> listPermissionsByRoleIds(String roleIds);
}
