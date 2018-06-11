$(function () {
    /**
     * 点击登录按钮
     */
    $("#registerBtn").click(function () {
        doRegister();
        $("#registerBtn").click(function () {
            doRegister();
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
        url: "/user/doRegister.html",
        datatype: 'json',
        success: function (data) {
            if (data.code == 100000) {
                layer.msg('注册成功，请在收到注册邮件后点击链接激活账户~');
                window.location.reload(true);
            } else {
                layer.msg('注册失败~');
            }
        }
    });
}