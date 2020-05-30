package com.icicles.cube.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.icicles.cube.entity.SysUser;
import com.icicles.cube.entity.form.SysUserForm;
import com.icicles.cube.exception.ApiException;
import org.springframework.data.domain.Pageable;

/**
 * <p>
 * 人员信息 服务类
 * </p>
 *
 * @author yanwei
 * @since 2020-03-09
 */
public interface SysUserService extends IService<SysUser> {
      /**
       * 根据条件分页查询人员信息
       *
       * @param pageable 分页对象
       * @return IPage<SysUser>   人员信息列表（分页）
       */
       IPage<SysUserForm> findPage(Pageable pageable) throws ApiException;

      /**
       * 增加人员信息
       *
       * @param sysUser 人员信息
       * @throws ApiException 异常信息
       */
      void add(SysUser sysUser) throws ApiException;

      /**
      * 删除人员信息
      *
      * @param id 编号
      * @throws ApiException 异常信息
      */
      void delete(String id) throws ApiException;

      /**
      * 更新人员信息
      *
      * @param sysUser 人员信息
      * @throws ApiException 异常信息
      */
      void refresh(SysUser sysUser) throws ApiException;

      /**
       * 根据账号查询用户信息
       *
       * @param account 账号
       * @return SysUser   用户信息
       */
      SysUser findByAccount(String account) throws ApiException;

      /**
       * 根据手机号查询用户信息
       *
       * @param phone 手机号
       * @return SysUser   用户信息
       */
      SysUser findByPhone(String phone) throws ApiException;

      /**
       * 根据openid查询用户信息
       *
       * @param openid openid
       * @return SysUser   用户信息
       */
      SysUser findByOpenid(String openid) throws ApiException;


}
