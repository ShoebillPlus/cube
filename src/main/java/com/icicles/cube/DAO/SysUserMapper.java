package com.icicles.cube.DAO;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.icicles.cube.entity.SysUser;
import com.icicles.cube.entity.form.SysUserForm;

/**
 * <p>
 * 人员信息 Mapper 接口
 * </p>
 *
 * @author yanwei
 * @since 2020-03-09
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 自定义sql分页
     * @param page
     * @param
     * @return
     */
    IPage<SysUserForm> findPage(IPage<SysUserForm> page);

}
