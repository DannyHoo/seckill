$(function () {
    /**
     * 点击注册按钮
     */
    $("#registerBtn").click(function () {
        doRegister();
        $("#registerBtn").click(function () {
            doRegister();
        });
    });

    /**
     * 点击登录按钮
     */
    $("#loginBtn").click(function () {
        doLogin();
        $("#loginBtn").click(function () {
            doLogin();
        });
    });
})

function doRegister() {
    var email = $("#email").val();
    var userName = $("#userName").val();
    var password = $("#password").val();
    console.log("email:" + email + ";userName:" + userName + ";password:" + password);

    var publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCD2+Aha3KVv5x5XRe/1HTFv7RMZXuZWAh+airCLLZ3l3wQ8vq9RyLAsbVkV+TAwQXjqtdYvkx9+VfbnoUWa1aqtIXtN3Y+us+jbAPC8JvKqox8Kp9SI2APcbf5ci9h8Chqg4oebxmObut/u/O57JzjZD8t4xBMgVHUD8vOtP64FwIDAQAB";

    var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey);
    var encrypted = encrypt.encrypt(password);
    console.log("加密后：" + encrypted);

    $.ajax({
        async: false,
        data: {"email": email, "userName": userName, "password": encrypted},
        type: "post",
        url: "/user/doRegister.action",
        datatype: 'json',
        success: function (data) {
            if (data.code == 100000) {
                layer.msg('注册成功，请在收到注册邮件后点击链接激活账户~');
                window.event.returnValue = false;
                window.location.href = getRootPath() + "/index.html";
            } else {
                layer.msg('注册失败，原因：' + data.message);
            }
            console.log("注册结果：" + data);
        }
    });
}


function doLogin() {
    var userName = $("#userName").val();
    var password = $("#password").val();
    console.log("userName:" + userName + ";password:" + password);

    var publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCD2+Aha3KVv5x5XRe/1HTFv7RMZXuZWAh+airCLLZ3l3wQ8vq9RyLAsbVkV+TAwQXjqtdYvkx9+VfbnoUWa1aqtIXtN3Y+us+jbAPC8JvKqox8Kp9SI2APcbf5ci9h8Chqg4oebxmObut/u/O57JzjZD8t4xBMgVHUD8vOtP64FwIDAQAB";

    var encrypt = new JSEncrypt();
    encrypt.setPublicKey(publicKey);
    var encrypted = encrypt.encrypt(password);
    console.log("加密后：" + encrypted);

    $.ajax({
        async: false,
        data: {"userName": userName, "password": encrypted},
        type: "post",
        url: "/user/doLogin.action",
        datatype: 'json',
        success: function (data) {
            if (data.code == 100000) {
                window.event.returnValue = false;
                window.location.href = getRootPath() + "/index.html";
            } else {
                layer.msg('登录失败，原因：' + data.message);
            }
            console.log("登录结果：" + data);
        }
    });
}

function getRootPath() {
    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
    var curWwwPath = window.document.location.href;
    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
    var pathName = window.document.location.pathname;
    var pos = curWwwPath.indexOf(pathName);
    //获取主机地址，如： http://localhost:8083
    var localhostPaht = curWwwPath.substring(0, pos);
    //获取带"/"的项目名，如：/uimcardprj
    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
    return localhostPaht;
}