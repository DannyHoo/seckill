var longTime = 0;//当前时间

$(function () {

    /*var temp;
    $.ajax({
        async: false,
        type: "post",
        data: '{"mobileNo": "13001073366","type": "1"}',
        url: "10.5.117.41:8080/user/sendMsg",
        datatype: 'json',
        success: function (data) {
            temp = data;
            alert(data);
        },error: function(XMLHttpRequest, textStatus, errorThrown) {
            alert(XMLHttpRequest.status);
            alert(XMLHttpRequest.readyState);
            alert(textStatus);
        }
    });*/

    //获取商品信息
    $.get("/seckill/getGoodsInfo.action?goodsNo=G20180614160305682062" + $("#goodsNo").val(), function (data) {
        $("#goodsImg").attr("src", data.goods.pictureurl);
        $("#goodsName").html(data.goods.name);
        $("#goodsDesc").html(data.goods.description);
        $("#nowPrice").html(data.goods.nowprice);
        $("#originPrice").html(data.goods.originprice);
        var scekilledNum = data.goods.totalnum - data.goods.balance;
        $("#seckilledNum").html(scekilledNum);

        var strSeckillStartTime = data.goods.seckillbegintime;
        var strSeckillEndTime = data.goods.seckillendtime;
        var strServerNowTime = data.nowTime;
        startTime = new Date(strSeckillStartTime);//商品秒杀开始时间
        endtime = new Date(strSeckillEndTime);//商品秒杀结束时间
        nowtime = new Date(strServerNowTime);//服务器端现在时间
        longTime = nowtime.getTime();

        //还没开始
        if (nowtime < startTime) {
            setInterval("_fresh(startTime, '开始')", 1000);
        }
        //正在进行
        if (nowtime >= startTime && nowtime <= endtime) {
            setInterval("_fresh(endtime, '结束')", 1000);
            /* 马上抢按钮 */
            $("#doSeckill").css("background-color", "#ff4646")
            $("#doSeckill").on('click', function () {
                doSeckill();
            });
        }
        //活动结束
        if (nowtime > endtime) {
            $("#doSeckill").css("background-color", "#CCCCCC");
            $("#doSeckill").on('click', function () {
            });
        }

    });

})

/**
 *
 * @param endtime 截止(开始/结束)时间
 * @param type 开始/结束
 * @private
 */
function _fresh(endTime, type) {
    var leftsecond = parseInt((endTime.getTime() - longTime) / 1000);
    if (leftsecond < 0) {
        leftsecond = 0;
    }
    day = parseInt(leftsecond / 3600 / 24);
    hour = parseInt((leftsecond / 3600) % 24);
    minute = parseInt((leftsecond / 60) % 60);
    second = parseInt(leftsecond % 60);
    $("#times").html("还剩： " + day + "天" + hour + "小时" + minute + "分" + second + "秒 " + type);

    longTime = longTime + 1000;
}

function doSeckill() {
    layer.msg('faqi');

    /*$.post(
     "/seckill/doRequest",
     {
     userName: "admin",
     productNo: "",
     token: ""
     },
     function (data) {
     if (data.msg == 1) {
     alert("请您登陆哦~");
     }
     if (data.msg == 2) {
     alert("秒杀还没有开始哦~");
     }
     if (data.msg == 3) {
     alert("单机请求数量过大~");
     }
     if (data.msg == 4) {
     alert("库存不足~");
     }
     if (data.msg == 5) {
     alert("秒杀成功！即将跳转到订单页面~");
     location.href = "/toOrder";
     }
     });
     */
    /* 用这个方法会报406错误 */
    /*$.ajax({
     type : "POST",
     url : "<%=basePath%>seckill.htm",
     dataType : "json",
     data:"{}",
     async : false,
     success : function(data) {
     alert(data);
     /!* if (data.msgCount > 0) {
     alert("还没到时间哦");
     } *!/
     },
     error : function(XMLHttpRequest, textStatus, errorThrown) {
     alert("异步调用出错，请您联系管理员");
     alert(XMLHttpRequest.status);
     alert(XMLHttpRequest.readyState);
     alert(textStatus);
     }
     });*/
}


