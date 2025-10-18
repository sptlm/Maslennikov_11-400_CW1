<#include "base.ftl">

<#macro title>Login page</#macro>

<script>
    $(document).on("input", "#ajax-login", function (){
        console.log("Debug");
        $.get("ajax/user_exists?target=login&login=" + $("#ajax-login").val(), function (response){
            $("#ajax-response").text(response)
        })
    })
</script>

<#macro content>
    <h3>Login page</h3>
    <div class="flex-box" id="ajax-response"></div>
    <form method="post" action="login">
        Login: <input type="text" id="ajax-login" name="login" placeholder="login"><br>
        Password: <input type="password" name="password" placeholder="password"><br>
        <input type="submit" value="Log in">
    </form>


</#macro>
