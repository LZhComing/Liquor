package com.liquorcloud.liquor.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liquorcloud.liquor.common.model.entity.SysDeptRelation;

/**
 * @author zzc
 */
public interface SysDeptRelationMapper extends BaseMapper<SysDeptRelation> {
	/**
	 * 删除部门关系表数据
	 *
	 * @param id 部门ID
	 */
	void deleteDeptRelationsById(Integer id);

	/**
	 * 更改部分关系表数据
	 *
	 * @param deptRelation
	 */
	void updateDeptRelations(SysDeptRelation deptRelation);

}
