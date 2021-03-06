<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>CMS - 注册</title>
    <link rel="stylesheet" href="../vendor/simple-line-icons/css/simple-line-icons.css">
    <link rel="stylesheet" href="../vendor/font-awesome/css/fontawesome-all.min.css">
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
<div class="page-wrapper flex-row align-items-center">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-5">
                <div class="card p-4">
                    <div class="card-header text-center text-uppercase h4 font-weight-light">
                        注册
                    </div>

                    <div class="card-body py-5">
                        <div class="form-group">
                            <label class="form-control-label">用户名</label>
                            <input type="name" class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">邮箱</label>
                            <input type="email" class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">密码</label>
                            <input type="password" class="form-control">
                        </div>

                        <div class="form-group">
                            <label class="form-control-label">确认密码</label>
                            <input type="password" class="form-control">
                        </div>
                    </div>

                    <div class="card-footer">
                        <button type="submit" class="btn btn-success btn-block register">创建账户</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/popper.js/popper.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="../vendor/chart.js/chart.min.js"></script>
<script src="../js/carbon.js"></script>
<script src="../js/demo.js"></script>
<script>
    $("input[type='name']").blur(function () {
        var obj = $(this);
        var userName = obj.val();
        if(userName =="undefined"||userName == ""){
            obj.focus()
            alert("用户名不能为空");
        }else{
            verifyUserName(userName);
        }
    })
    $(".register").click(function () {
        var userName = $("input[type='name']").val();
        var password = $("input[type='password']").val();
        var email = $("input[type='email']").val();

        var params = JSON.stringify({
            userName:userName,
            password:password,
            email:email
        })

        $.ajax({
            type:"post",
            url:"../api/user/register",
            data:params,
            contentType:"application/json",
            success:function (res) {
                if(res.code == 200){
                    location.href="../Home/Index";
                }else{
                    alert(res.message);
                }
            }
        })
    })
    function verifyUserName(userName) {
        $.ajax({
            type:"post",
            url:"../api/user/verify",
            data:{"userName":userName},
            success:function (res) {
                if(res.code != 200){
                    alert(res.message);
                }
            }
        })
    }

</script>
</body>
</html>
