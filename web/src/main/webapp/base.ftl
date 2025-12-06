<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><@title></@title></title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css",
          rel = "stylesheet">
</head>

<body>
<div id="header">
    <h2> <strong>Garbage website</strong></h2>
    <table>
        <tr>
            <form method="get" action="index">
                <input type="submit" value="Main page">
            </form>
        </tr>
        <tr>
            <form method="get" action="login">
                <input type="submit" value="Login">
            </form>
        </tr>
        <tr>
            <form method="get" action="sign_up">
                <input type="submit" value="Sign up">
            </form>
        </tr>
        <tr>
            <form method="get" action="logout">
                <input type="submit" value="Log out">
            </form>
        </tr>
    </table>
</div>

<hr>

<div id="content">
    <div class="content">
        <@content></@content>
    </div>
</div>

</body>

</html>