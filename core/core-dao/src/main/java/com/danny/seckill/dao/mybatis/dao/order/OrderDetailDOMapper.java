package com.danny.seckill.dao.mybatis.dao.order;

import com.danny.seckill.dao.mybatis.data.order.OrderDetailDO;
import com.danny.seckill.dao.mybatis.data.order.OrderDetailDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderDetailDOMapper {
    long countByExample(OrderDetailDOExample example);

    int deleteByExample(OrderDetailDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderDetailDO record);

    int insertSelective(OrderDetailDO record);

    List<OrderDetailDO> selectByExample(OrderDetailDOExample example);

    OrderDetailDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderDetailDO record, @Param("example") OrderDetailDOExample example);

    int updateByExample(@Param("record") OrderDetailDO record, @Param("example") OrderDetailDOExample example);

    int updateByPrimaryKeySelective(OrderDetailDO record);

    int updateByPrimaryKey(OrderDetailDO record);
}