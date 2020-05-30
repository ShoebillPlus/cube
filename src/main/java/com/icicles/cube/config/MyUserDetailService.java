package com.icicles.cube.config;

import com.icicles.cube.entity.BaseUserDetail;
import com.icicles.cube.entity.SysUser;
import com.icicles.cube.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;

/**
 * description:auth鉴权service
 *
 * @author sp
 * @date 2018/7/19
 */
@Service("myUserDetailService")
public class MyUserDetailService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailService.class);
    @Autowired
    private PasswordEncoder passwordEncoder;
    private SysUserService sysUserService;

    @Autowired
    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser = sysUserService.findByAccount(username);
        if (sysUser == null) {
            logger.error("找不到该账号，账号：" + username);
            throw new UsernameNotFoundException("账号：" + username + "不存在！");
        }
        String password = passwordEncoder.encode(sysUser.getLoginPass());
        //String password = sysUser.getLoginPass();
        logger.debug(username);
        logger.debug(sysUser.getLoginPass());
        logger.debug(password);

        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        /* Iterator<String> iterator =  roleDao.getRolesByUserId(userEntity.getId()).iterator();
        while (iterator.hasNext()){
            collection.add(new SimpleGrantedAuthority(iterator.next()));
        }*/

        /*return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN"));*/
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(sysUser.getLoginAccount(),
                sysUser.getLoginPass(), isEnabled(sysUser.getIsValid()), true, true, true, collection);

        return new BaseUserDetail(sysUser, user);
    }

    private boolean isEnabled(int isValid) {
        return isValid == 1 ? true : false;
    }

}
