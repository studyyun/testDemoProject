package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

/**
 * <p>
 * 
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class LfMonDbopr extends Model {

    private static final long serialVersionUID = 2L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    
    @TableField("CREATETIME")
    private Timestamp createTime;
    
    @TableField("PROCENODE")
    private Integer proceNode;
    
    @TableField("VERSION")
    private Integer version;


}
