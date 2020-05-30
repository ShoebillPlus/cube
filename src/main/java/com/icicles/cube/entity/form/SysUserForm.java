package com.icicles.cube.entity.form;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 人员信息
 * </p>
 *
 * @author yanwei
 * @since 2020-03-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "SysUserForm对象", description = "人员信息")
public class SysUserForm extends Model<SysUserForm> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "编号")
    private String id;

    @ApiModelProperty(name = "openid", value = "用户唯一标识")
    private String openid;

    @ApiModelProperty(name = "name", value = "姓名")
    private String name;

    @ApiModelProperty(name = "card_id", value = "身份证号")
    private String cardId;

    @ApiModelProperty(name = "birthday", value = "生日")
    private String birthday;

    @ApiModelProperty(name = "phone", value = "手机号")
    private String phone;

    @ApiModelProperty(name = "sex", value = "性别")
    private Integer sex;

    @ApiModelProperty(name = "type", value = "类型")
    private Integer type;

    @ApiModelProperty(name = "login_account", value = "登录账号")
    private String loginAccount;

    @ApiModelProperty(name = "login_pass", value = "登录密码")
    private String loginPass;

    @ApiModelProperty(name = "is_valid", value = "是否有效（0:否；1:是）")
    private Integer isValid;

    @ApiModelProperty(name = "account_non_expired", value = "过期性  1没过期0过期")
    private Integer accountNonExpired;

    @ApiModelProperty(name = "credentials_non_expired", value = "有效性  1有效0失效")
    private Integer credentialsNonExpired;

    @ApiModelProperty(name = "account_non_locked", value = "锁定性 1未锁定0锁定")
    private Integer accountNonLocked;

    @ApiModelProperty(name = "email", value = "邮箱")
    private String email;

    @ApiModelProperty(name = "update_user_id", value = "更新人")
    private String updateUserId;

    @ApiModelProperty(name = "update_time", value = "更新时间")
    private String updateTime;

    @ApiModelProperty(name = "create_user_id", value = "创建人")
    private String createUserId;

    @ApiModelProperty(name = "create_time", value = "创建时间")
    private String createTime;

    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @ApiModelProperty(name = "is_assess", value = "是否已评价")
    private Boolean isAssess;

    @ApiModelProperty(name = "total_score", value = "得分")
    private double totalScore;

    @ApiModelProperty(name = "ret", value = "结果")
    private String ret;

    @ApiModelProperty(name = "dept_id", value = "部门编号")
    private String deptId;

    @ApiModelProperty(name = "dept_name", value = "部门名称")
    private String deptName;

    @ApiModelProperty(name = "role_id", value = "角色编号")
    private String roleId;

    @ApiModelProperty(name = "role_name", value = "角色名称")
    private String roleName;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
