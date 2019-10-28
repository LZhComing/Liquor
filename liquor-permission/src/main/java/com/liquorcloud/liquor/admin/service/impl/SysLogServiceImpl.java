package com.liquorcloud.liquor.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liquorcloud.liquor.common.model.entity.SysLog;
import com.liquorcloud.liquor.admin.service.SysLogService;
import com.liquorcloud.liquor.admin.mapper.SysLogMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志表 服务实现类
 * </p>
 *
 * @author lengleng
 * @since 2019/2/1
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements SysLogService {

}
