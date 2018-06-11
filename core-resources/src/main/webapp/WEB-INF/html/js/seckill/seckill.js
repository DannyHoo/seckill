$(function () {

    /**
     * 点击马上抢按钮
     */
    $(".subnow").on('click', function () {
        $.post(
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
    });

})


var endtime = new Date();//商品秒杀结束时间
var nowtime = new Date();//服务器端现在时间
var longTime = 0;
function _getDate() {
    $.get("/seckill/getdate", function (data) {
        var strServerEndTime=data.endtime;
        var strServerNowTime=data.nowtime;
        endtime = new Date(strServerEndTime);
        nowtime = new Date(strServerNowTime);
    });
    longTime = nowtime.getTime()
}
function _fresh() {
    var longEndTime=endtime.getTime();
    var leftsecond = parseInt((longEndTime - longTime) / 1000);
    if (leftsecond < 0) {
        leftsecond = 0;
    }
    __d = parseInt(leftsecond / 3600 / 24);
    __h = parseInt((leftsecond / 3600) % 24);
    __m = parseInt((leftsecond / 60) % 60);
    __s = parseInt(leftsecond % 60);
    document.getElementById("times").innerHTML = __d + "天 " + __h
        + "小时" + __m + "分" + __s + "秒";

    longTime = longTime + 1000;
}

_getDate();
setInterval(_fresh, 1000);