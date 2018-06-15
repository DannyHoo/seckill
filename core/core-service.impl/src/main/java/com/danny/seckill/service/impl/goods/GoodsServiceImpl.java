package com.danny.seckill.service.impl.goods;

import com.danny.seckill.domain.glue.goods.GoodsGlue;
import com.danny.seckill.framework.cache.Cache;
import com.danny.seckill.framework.cache.CacheFactory;
import com.danny.seckill.framework.cache.enums.CacheTypeEnum;
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

    /* 缓存商品信息的key值前缀，格式为：前缀+商品编号*/
    private final static String GOODS_CACHE_PREFIX = "GOODS_CACHE_PREFIX";
    private static Cache cache = CacheFactory.getCache(CacheTypeEnum.LOCAL_MEMORY_CACHE);

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

    /**
     * 从缓存中查询商品信息
     *
     * @param goodsParameter
     * @return
     */
    @Override
    public CommonResult<Goods> getGoodsFromCache(final GoodsParameter goodsParameter) {
        String bizAction = "getGoodsFromCache";
        CallbackResult callbackResult = this.getServiceTemplate().execute(new ServiceCallbackAction() {
            @Override
            public CallbackResult executeCheck() {
                return getCheckParameterEmptyResult(goodsParameter, "goodsno");
            }

            @Override
            public CallbackResult executeAction() {
                //先从缓存中查询商品信息
                Goods goods = cache.get(GOODS_CACHE_PREFIX + goodsParameter.getGoodsno(), Goods.class);
                //如果缓存中没有，从数据库中查询
                if (goods == null) {
                    goods = goodsGlue.findByGoodsNo(goodsParameter.getGoodsno());
                    if (goods != null) {//查询到商品信息后，重新设置缓存
                        cache.put(GOODS_CACHE_PREFIX + goodsParameter.getGoodsno(), goods);
                    }
                }
                return getSuccessCallbackResult(goods);
            }
        });
        return getCommonResult(callbackResult);
    }
}
