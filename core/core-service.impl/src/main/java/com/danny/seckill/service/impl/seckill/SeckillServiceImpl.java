package com.danny.seckill.service.impl.seckill;

import com.danny.seckill.framework.service.CallbackResult;
import com.danny.seckill.framework.service.ServiceCallbackAction;
import com.danny.seckill.model.bean.goods.Goods;
import com.danny.seckill.model.param.seckill.SeckillParameter;
import com.danny.seckill.model.result.CommonResult;
import com.danny.seckill.service.impl.BaseServiceImpl;
import com.danny.seckill.service.seckill.SeckillService;
import org.springframework.stereotype.Service;

/**
 * @author huyuyang@lxfintech.com
 * @Title: SeckillServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-14 17:21:05
 */
@Service("seckillService")
public class SeckillServiceImpl extends BaseServiceImpl implements SeckillService {

    // 分布式锁key值
    private final static String REDUCE_GOODS_STOCK_LOCKKEY = "REDUCE_GOODS_STOCK_LOCKKEY";

    /**
     * 秒杀尝试减库存操作，返回SUCCESS表示该用户已经成功下单
     *
     * @param seckillParameter
     * @return
     */
    @Override
    public CommonResult<Boolean> reduceGoodsStock(final SeckillParameter seckillParameter) {
        String bizAction = "reduceGoodsStock";
        //以分布式锁的方式执行
        CallbackResult callbackResult = this.getServiceTemplate().executeDistributeLock(new ServiceCallbackAction() {
            @Override
            public CallbackResult executeCheck() {
                return getCheckParameterEmptyResult(seckillParameter, "userName", "goodsNo");
            }

            @Override
            public CallbackResult executeAction() {

                return null;
            }
        }, REDUCE_GOODS_STOCK_LOCKKEY);
        return this.getCommonResult(callbackResult);
    }
}
