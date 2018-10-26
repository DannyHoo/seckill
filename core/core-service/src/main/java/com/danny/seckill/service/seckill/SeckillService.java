package com.danny.seckill.service.seckill;

import com.danny.seckill.model.bean.goods.Goods;
import com.danny.seckill.model.param.seckill.SeckillParameter;
import com.danny.seckill.model.result.CommonResult;

/**
 * @author huyuyang@lxfintech.com
 * @Title: SeckillService
 * @Description:
 * @Created on 2018-06-14 17:21:26
 */
public interface SeckillService {

    CommonResult<Boolean> reduceGoodsStock(SeckillParameter seckillParameter);

}
