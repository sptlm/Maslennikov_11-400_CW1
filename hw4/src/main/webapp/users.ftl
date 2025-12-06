<#include "base.ftl">

<#macro title>Users</#macro>

<#macro content>
    <h2>Users table</h2>

    <#if users?has_content>
        Таблица рекордов:
        <br>
        Имя Очки
        <br>
        <#list users as u>
            ${u.name} ${u.score}
            <br>
        </#list>
    </#if>

</#macro>
