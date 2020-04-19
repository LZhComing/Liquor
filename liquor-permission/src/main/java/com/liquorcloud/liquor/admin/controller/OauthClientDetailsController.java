package com.liquorcloud.liquor.admin.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liquorcloud.liquor.common.model.entity.OauthClientDetails;
import com.liquorcloud.liquor.admin.service.SysOauthClientDetailsService;
import com.liquorcloud.liquor.common.core.util.R;
import com.liquorcloud.liquor.common.core.log.annotation.SysLog;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author zzc
 */
@RestController
@AllArgsConstructor
@RequestMapping("/client")
public class OauthClientDetailsController {
	private final SysOauthClientDetailsService sysOauthClientDetailsService;

	/**
	 * 通过ID查询
	 *
	 * @param id ID
	 * @return SysOauthClientDetails
	 */
	@GetMapping("/{id}")
	public R getById(@PathVariable Integer id) {
		return R.ok(sysOauthClientDetailsService.getById(id));
	}


	/**
	 * 简单分页查询
	 *
	 * @param page                  分页对象
	 * @param oauthClientDetails 系统终端
	 * @return
	 */
	@GetMapping("/page")
	public R getOauthClientDetailsPage(Page page, OauthClientDetails oauthClientDetails) {
		return R.ok(sysOauthClientDetailsService.page(page, Wrappers.query(oauthClientDetails)));
	}

	/**
	 * 添加
	 *
	 * @param oauthClientDetails 实体
	 * @return success/false
	 */
	@SysLog("添加终端")
	@PostMapping
	@PreAuthorize("@pms.hasPermission('sys_client_add')")
	public R add(@Valid @RequestBody OauthClientDetails oauthClientDetails) {
		return R.ok(sysOauthClientDetailsService.save(oauthClientDetails));
	}

	/**
	 * 删除
	 *
	 * @param id ID
	 * @return success/false
	 */
	@SysLog("删除终端")
	@DeleteMapping("/{id}")
	@PreAuthorize("@pms.hasPermission('sys_client_del')")
	public R removeById(@PathVariable String id) {
		return R.ok(sysOauthClientDetailsService.removeClientDetailsById(id));
	}

	/**
	 * 编辑
	 *
	 * @param oauthClientDetails 实体
	 * @return success/false
	 */
	@SysLog("编辑终端")
	@PutMapping
	@PreAuthorize("@pms.hasPermission('sys_client_edit')")
	public R update(@Valid @RequestBody OauthClientDetails oauthClientDetails) {
		return R.ok(sysOauthClientDetailsService.updateClientDetailsById(oauthClientDetails));
	}
}
