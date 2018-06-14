package com.danny.seckill.resources.controller.seckill;

import com.alibaba.fastjson.JSONObject;
import com.danny.seckill.framework.cache.Cache;
import com.danny.seckill.framework.cache.CacheFactory;
import com.danny.seckill.framework.cache.enums.CacheTypeEnum;
import com.danny.seckill.framework.util.StringUtil;
import com.danny.seckill.model.bean.goods.Goods;
import com.danny.seckill.model.param.goods.GoodsParameter;
import com.danny.seckill.model.result.CommonResult;
import com.danny.seckill.resources.controller.BaseController;
import com.danny.seckill.service.goods.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dannyhoo
 * @Title: IndexController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-06-07 10:57:10
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController extends BaseController {

    /* 缓存商品信息的key值前缀，格式为：前缀+商品编号*/
    private final static String GOODS_CACHE_PREFIX = "GOODS_CACHE_PREFIX";

    @Autowired
    private GoodsService goodsService;

    /**
     * 访问/刷新秒杀页面
     *
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("seckill/index");
        //查询秒杀商品信息（缓存）
        String goodsNo = getValueFromRequest(request, "goodsNo");
        if (StringUtil.isEmpty(goodsNo)) goodsNo = "G20180614160305682062";

        Cache cache = CacheFactory.getCache(CacheTypeEnum.LOCAL_MEMORY_CACHE);
        Goods goods = cache.get(GOODS_CACHE_PREFIX + goodsNo, Goods.class);
        //缓存中没有，从数据库中查询
        if (goods == null) {
            CommonResult<Goods> goodsFindCommonResult = goodsService.findByGoodsNo(new GoodsParameter().setGoodsno(goodsNo));
            if (goodsFindCommonResult.isSuccess()) goods = goodsFindCommonResult.getBusinessObject();
            if (goods != null) {//查询到商品信息后，重新设置缓存
                cache.put(GOODS_CACHE_PREFIX + goodsNo, goods);
            }
        }
        modelAndView.addObject("goods", goods);
        return modelAndView;
    }


    @RequestMapping("/getSeckillTime")
    @ResponseBody
    public JSONObject getDate(HttpServletRequest request) {
        //查询某个商品秒杀开始和结束时间
        String goodsNo = getValueFromRequest(request, "goodsNo");
        JSONObject jsonObject = new JSONObject();
        // TODO: 18/6/14 从缓存中查询
        jsonObject.put("endtime", "2018-06-30 12:12:12");
        jsonObject.put("nowtime", "2018-06-11 10:30:12");
        return jsonObject;
    }

    public String doSeckill(HttpServletRequest request) {
        String result = "";
        //1、请求合法校验

        //2、获得商品信息，查看库存是否足够

        //3、生成订单，减库存

        //4、
        return result;
    }


    @RequestMapping("/{prefix}")
    public ModelAndView prefix(@PathVariable String prefix) {
        ModelAndView modelAndView = new ModelAndView("seckill/" + prefix);
        return modelAndView;
    }
}
