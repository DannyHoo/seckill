package com.danny.seckill.resources.controller.seckill;

import com.danny.seckill.framework.model.enums.ResultStatusEnum;
import com.danny.seckill.framework.util.DateUtils;
import com.danny.seckill.model.bean.goods.Goods;
import com.danny.seckill.model.bean.system.User;
import com.danny.seckill.model.param.goods.GoodsParameter;
import com.danny.seckill.model.param.seckill.SeckillParameter;
import com.danny.seckill.model.result.CommonResult;
import com.danny.seckill.resources.controller.BaseController;
import com.danny.seckill.resources.response.ResponseData;
import com.danny.seckill.resources.utils.SessionUtils;
import com.danny.seckill.service.goods.GoodsService;
import com.danny.seckill.service.seckill.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dannyhoo
 * @Title: IndexController
 * @Description:
 * @Created on 2018-06-07 10:57:10
 */
@Controller
@RequestMapping("/seckill")
public class SeckillController extends BaseController {

    @Autowired
    private GoodsService goodsService;
    @Autowired
    private SeckillService seckillService;

    /**
     * 访问/刷新秒杀页面
     *
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("seckill/index");
        return modelAndView;
    }

    /**
     * 查询商品信息
     *
     * @param request
     * @return
     */
    @RequestMapping("/getGoodsInfo")
    @ResponseBody
    public Map<String, Object> getGoodsInfo(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        //查询秒杀商品信息（缓存）
        String goodsNo = getValueFromRequest(request, "goodsNo");
        CommonResult<Goods> goodsFindCommonResult = goodsService.findByGoodsNo(new GoodsParameter().setGoodsno(goodsNo));
        Goods goods = goodsFindCommonResult.getBusinessObject();
        map.put("goods", goods);
        map.put("nowTime", DateUtils.getNowDate());
        return map;
    }

    @RequestMapping("/doSeckill")
    @ResponseBody
    public ResponseData doSeckill(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        //1、请求合法校验
        //是否已经登录
        User user = SessionUtils.getCurrentUser(request);
        if (user == null) {
            return new ResponseData(ResultStatusEnum.USER_NOT_LOGIN, null);
        }
        //2、尝试减少库存，查看库存是否足够，如果足够直接下单
        String goodsNo = getValueFromRequest(request, "goodsNo");
        seckillService.reduceGoodsStock(new SeckillParameter()
                .setUserName(user.getUsername())
                .setGoodsNo(goodsNo));
        return new ResponseData(ResultStatusEnum.SUCCESS, null);
    }

    @RequestMapping("/{prefix}")
    public ModelAndView prefix(@PathVariable String prefix) {
        ModelAndView modelAndView = new ModelAndView("seckill/" + prefix);
        return modelAndView;
    }
}
