package com.danny.seckill.service.goods;

import com.danny.seckill.model.bean.goods.Goods;
import com.danny.seckill.model.param.goods.GoodsParameter;
import com.danny.seckill.model.result.CommonResult;

/**
 * @author huyuyang@lxfintech.com
 * @Title: GoodsService
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-14 17:45:26
 */
public interface GoodsService {

    /**
     * 根据商品编号查询商品信息
     *
     * @param goodsParameter
     * @return
     */
    CommonResult<Goods> findByGoodsNo(GoodsParameter goodsParameter);
}
