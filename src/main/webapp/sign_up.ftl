<#include "base.ftl">

<#macro title>Sign up page</#macro>

<script>
    $(document).on("input", "#ajax-login", function (){
        console.log("Debug");
        $.get("ajax/user_exists?target=signup&login=" + $("#ajax-login").val(), function (response){
            $("#ajax-response").text(response)
        })
    })
</script>

<#macro content>
    <h3>Sign Up page</h3>

    <div class="flex-box" id="ajax-response"></div>
    <form method="post" action="sign_up" enctype="multipart/form-data">
        Login: <input type="text" id="ajax-login" name="login" placeholder="login"><br>
        Password: <input type="password" name="password" placeholder="password"><br>
        Name: <input type="text" name="name" placeholder="name"><br>
        Lastname: <input type="text" name="lastname" placeholder="lastname"><br>
        Profile picture: <input type="file" name="file" placeholder="your picture"><br>
        <input type="submit" value="Sign up">
    </form>

</#macro>
