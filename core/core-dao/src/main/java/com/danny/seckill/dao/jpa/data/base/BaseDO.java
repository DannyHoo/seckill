package com.danny.seckill.dao.jpa.data.base;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseDO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-01-19 22:31:24
 */
@MappedSuperclass
public abstract class BaseDO implements Serializable {
    protected static final long serialVersionUID = 2429073401643038863L;

    /** 主键 **/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    /** 备注 **/
    @Column
    protected String comment;

    /** 创建时间 **/
    @Column(insertable = false,updatable = false)
    protected Date createTime;

    /** 最后修改时间 **/
    @Column(insertable = false, updatable = false)
    protected Date updateTime;

    public Long getId() {
        return id;
    }

    public BaseDO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public BaseDO setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public BaseDO setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public BaseDO setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    /**
     * @return
     *
     * @see Object#toString()
     */
    public String toString() {
        try {
            return ToStringBuilder.reflectionToString(this,
                    ToStringStyle.SHORT_PREFIX_STYLE);
        } catch (Exception e) {
            // NOTICE: 这样做的目的是避免由于toString()的异常导致系统异常终止
            // 大部分情况下，toString()用在日志输出等调试场景
            return super.toString();
        }
    }
}
