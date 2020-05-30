package com.icicles.cube.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.icicles.cube.DAO.SysUserMapper;
import com.icicles.cube.entity.SysUser;
import com.icicles.cube.entity.form.SysUserForm;
import com.icicles.cube.exception.ApiException;
import com.icicles.cube.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 人员信息 服务实现类
 * </p>
 *
 * @author yanwei
 * @since 2020-03-09
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private static final Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Resource
    SysUserMapper sysUserMapper;

    /*private SysParamService sysParamService;

    @Autowired
    public void setSysParamService(SysParamService sysParamService) {
        this.sysParamService = sysParamService;
    }
*/

    @Override
    public IPage<SysUserForm> findPage(Pageable pageable) throws ApiException {
        IPage<SysUser> retPage;
        IPage<SysUserForm> sysUserFormIPage;
        try {
            Page<SysUserForm> page = new Page<>(pageable.getPageNumber(), pageable.getPageSize());
            sysUserFormIPage = sysUserMapper.findPage(page);
            /*Page<SysUser> page = new Page<>(pageable.getPageNumber(), pageable.getPageSize());
            sysUserFormIPage = this.page(page).convert(SysUser::selectAll);
            List<SysUserForm> collect = retPage.getRecords().stream().map(SysUser -> SysUserForm).collect(toList());
            IPage<SysUserForm> sysUserFormIPage =  ((IPage<SysUserForm>) this).setRecords(collect);*/

            logger.debug("查询人员信息列表成功");
        } catch (Exception e) {
            logger.error("查询人员信息列表异常", e);
            e.printStackTrace();
            throw new ApiException("查询人员信息列表异常", HttpStatus.BAD_REQUEST);
        }
        return sysUserFormIPage;
   }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(SysUser sysUser) throws ApiException {
        try {
            if(StringUtils.isBlank(sysUser.getLoginAccount())){
                throw new ApiException("登录账号不能为空", HttpStatus.BAD_REQUEST);
            }
            if(this.findByAccount(sysUser.getLoginAccount())!=null){
                throw new ApiException("登录账号重复", HttpStatus.BAD_REQUEST);
            }
            // 密码加盐储存
            BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
            /*SysParam sysParam = null;*/
            String password = "111111";//sysParam==null?"111111":sysParam.getConfigValue();
            sysUser.setLoginPass(bcryptPasswordEncoder.encode(password));
            sysUser.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
            this.save(sysUser);
            logger.debug("添加人员信息成功" + sysUser.getId());
        } catch (ApiException e) {
            logger.error("添加人员信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("添加人员信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("添加人员信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) throws ApiException {
        try {
            this.removeById(id);
            logger.debug("删除人员信息成功" + id);
        } catch (Exception e) {
            logger.error("删除人员信息异常", e);
            e.printStackTrace();
            throw new ApiException("删除人员信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void refresh(SysUser sysUser) throws ApiException {
        try {
            if (sysUser.getId()==null) {
                throw new ApiException("编号不能为空", HttpStatus.BAD_REQUEST);
            }
            UpdateWrapper<SysUser> wrapper = new UpdateWrapper();
            wrapper.eq("id",sysUser.getId());
            this.update(sysUser,wrapper);
            logger.debug("更新人员信息成功" + sysUser.getId());
        } catch (ApiException e) {
            logger.error("更新人员信息错误:" + e.getMessage(), e);
            throw e;
        } catch (Exception e1) {
            logger.error("更新人员信息异常", e1);
            e1.printStackTrace();
            throw new ApiException("更新人员信息异常", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public SysUser findByAccount(String account) throws ApiException {
        SysUser sysUser;
        try {
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("login_account",account);
            sysUser = this.getOne(queryWrapper);
            logger.debug("查询人员信息成功");
        } catch (Exception e) {
            logger.error("查询人员信息异常", e);
            e.printStackTrace();
            throw new ApiException("查询人员信息异常", HttpStatus.BAD_REQUEST);
        }
        return sysUser;
    }

    @Override
    public SysUser findByPhone(String phone) throws ApiException {
        SysUser sysUser;
        try {
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("phone",phone);
            sysUser = this.getOne(queryWrapper);
            logger.debug("查询人员信息成功");
        } catch (Exception e) {
            logger.error("查询人员信息异常", e);
            e.printStackTrace();
            throw new ApiException("查询人员信息异常", HttpStatus.BAD_REQUEST);
        }
        return sysUser;
    }

    @Override
    public SysUser findByOpenid(String openid) throws ApiException {
        SysUser sysUser;
        try {
            QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("openid",openid);
            sysUser = this.getOne(queryWrapper);
            logger.debug("查询人员信息成功");
        } catch (Exception e) {
            logger.error("查询人员信息异常", e);
            e.printStackTrace();
            throw new ApiException("查询人员信息异常", HttpStatus.BAD_REQUEST);
        }
        return sysUser;
    }

}
