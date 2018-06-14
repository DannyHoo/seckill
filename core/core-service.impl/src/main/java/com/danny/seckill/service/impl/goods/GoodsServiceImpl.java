package com.danny.seckill.service.impl.goods;

import com.danny.seckill.domain.glue.goods.GoodsGlue;
import com.danny.seckill.framework.service.CallbackResult;
import com.danny.seckill.framework.service.ServiceCallbackAction;
import com.danny.seckill.model.bean.goods.Goods;
import com.danny.seckill.model.param.goods.GoodsParameter;
import com.danny.seckill.model.result.CommonResult;
import com.danny.seckill.service.goods.GoodsService;
import com.danny.seckill.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huyuyang@lxfintech.com
 * @Title: GoodsServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-14 17:47:18
 */
@Service("goodsService")
public class GoodsServiceImpl extends BaseServiceImpl implements GoodsService {

    @Autowired
    private GoodsGlue goodsGlue;

    /**
     * 根据商品编号查询商品信息
     *
     * @param goodsParameter
     * @return
     */
    @Override
    public CommonResult<Goods> findByGoodsNo(final GoodsParameter goodsParameter) {
        String bizAction = "findByGoodsNo";
        CallbackResult callbackResult = this.getServiceTemplate().execute(new ServiceCallbackAction() {
            @Override
            public CallbackResult executeCheck() {
                return getCheckParameterEmptyResult(goodsParameter, "goodsno");
            }

            @Override
            public CallbackResult executeAction() {
                Goods goods = goodsGlue.findByGoodsNo(goodsParameter.getGoodsno());
                return getSuccessCallbackResult(goods);
            }
        });
        return getCommonResult(callbackResult);
    }

}
