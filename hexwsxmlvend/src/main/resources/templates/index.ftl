<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>third-party</title>
</head>
<body>
this is welcome page : ${username}
<div>
    <form id="loginForm" method="post" >
        <label>AgentNo:</label><input type="text" name="AgentNo" placeholder="AgentNo"  maxlength="6">
        <label>PassWord:</label><input type="text" name="PassWord" placeholder="PassWord"  maxlength="10">
        <div class="row">
            <button type="submit">Login</button>
        </div>
    </form>
</div>
<script src="${request.contextPath}/static/adminlte/plugins/iCheck/icheck.min.js"></script>
<script src="${request.contextPath}/static/js/login.1.js"></script>
</body>
</html>