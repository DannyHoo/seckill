package com.danny.seckill.service.seckill;

import com.danny.seckill.model.bean.goods.Goods;
import com.danny.seckill.model.param.seckill.SeckillParameter;
import com.danny.seckill.model.result.CommonResult;

/**
 * @author huyuyang@lxfintech.com
 * @Title: SeckillService
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-14 17:21:26
 */
public interface SeckillService {

    CommonResult<Goods> reduceGoodsStock(SeckillParameter seckillParameter);

}
