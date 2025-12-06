<#include "base.ftl">

<#macro title>Sign up page</#macro>

<#macro content>
    <h3>Sign Up page</h3>

    <form method="post" action="sign_up">
        Login: <input type="text" name="login" placeholder="login"><br>
        Password: <input type="password" name="password" placeholder="password"><br>
        <input type="submit" value="Sign up">
    </form>

</#macro>
