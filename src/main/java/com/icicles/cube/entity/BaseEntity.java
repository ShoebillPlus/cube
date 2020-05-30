package com.icicles.cube.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 基础实体类
 *
 * @author yanwei
 * @date 2020/3/20 17:37
 */
@Data
@EqualsAndHashCode(callSuper=true)
public class BaseEntity extends Model<BaseEntity>  implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "id", value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "创建用户ID")
    @TableField(value = "create_user_id", fill = FieldFill.INSERT)
    private String createUserId;

    @ApiModelProperty(value = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private String createTime;

    @ApiModelProperty(value = "更新用户ID")
    @TableField(value = "update_user_id", fill = FieldFill.INSERT_UPDATE)
    private String updateUserId;

    @ApiModelProperty(value = "更新时间")
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private String updateTime;

    @ApiModelProperty(name = "remark", value = "备注")
    @TableField(value = "remark", fill = FieldFill.INSERT_UPDATE)
    private String remark;
}
