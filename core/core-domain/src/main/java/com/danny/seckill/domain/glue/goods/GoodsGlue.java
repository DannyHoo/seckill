package com.danny.seckill.domain.glue.goods;

import com.danny.seckill.dao.mybatis.dao.goods.GoodsDOMapper;
import com.danny.seckill.dao.mybatis.data.goods.GoodsDO;
import com.danny.seckill.dao.mybatis.data.goods.GoodsDOExample;
import com.danny.seckill.domain.glue.base.BaseGlue;
import com.danny.seckill.framework.util.ListUtil;
import com.danny.seckill.model.bean.goods.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: GoodsGlue
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-14 17:18:29
 */
@Component
public class GoodsGlue extends BaseGlue {

    @Autowired
    private GoodsDOMapper goodsDOMapper;


    /**
     * 根据商品编号查询商品信息
     *
     * @param goodsno
     * @return
     */
    public Goods findByGoodsNo(String goodsno) {
        GoodsDOExample goodsDOExample = new GoodsDOExample();
        List<GoodsDO> goodsDOList = goodsDOMapper.selectByExample(goodsDOExample);
        if (ListUtil.isNotEmpty(goodsDOList)) {
            return convertIgnoreNullProperty(ListUtil.getFirst(goodsDOList),Goods.class);
        }
        return null;
    }
}
