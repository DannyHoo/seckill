package com.danny.seckill.dao.mybatis.dao.goods;

import java.util.List;

import com.danny.seckill.dao.mybatis.data.goods.GoodsDO;
import com.danny.seckill.dao.mybatis.data.goods.GoodsDOExample;
import org.apache.ibatis.annotations.Param;

public interface GoodsDOMapper {
    long countByExample(GoodsDOExample example);

    int deleteByExample(GoodsDOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(GoodsDO record);

    int insertSelective(GoodsDO record);

    List<GoodsDO> selectByExample(GoodsDOExample example);

    GoodsDO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") GoodsDO record, @Param("example") GoodsDOExample example);

    int updateByExample(@Param("record") GoodsDO record, @Param("example") GoodsDOExample example);

    int updateByPrimaryKeySelective(GoodsDO record);

    int updateByPrimaryKey(GoodsDO record);
}