package com.liquorcloud.liquor.common.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zzc
 */
@Data
public class TreeNode {
	protected int id;
	protected int parentId;
	protected List<TreeNode> children = new ArrayList<TreeNode>();

	public void add(TreeNode node) {
		children.add(node);
	}
}
