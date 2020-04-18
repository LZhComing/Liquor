package com.liquorcloud.liquor.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liquorcloud.liquor.common.model.entity.SysDept;
import com.liquorcloud.liquor.common.model.entity.SysDeptRelation;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zzc
 */
public interface SysDeptRelationService extends IService<SysDeptRelation> {

	/**
	 * 新建部门关系
	 *
	 * @param sysDept 部门
	 */
	void saveDeptRelation(SysDept sysDept);

	/**
	 * 通过ID删除部门关系
	 *
	 * @param id
	 */
	void removeDeptRelationById(Integer id);

	/**
	 * 更新部门关系
	 *
	 * @param relation
	 */
	void updateDeptRelation(SysDeptRelation relation);
}
