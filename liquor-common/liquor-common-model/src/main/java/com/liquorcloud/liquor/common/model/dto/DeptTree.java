package com.liquorcloud.liquor.common.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zzc
 * 部门树
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptTree extends TreeNode {
	private String name;
}
