<#list conditionList as a><#if "Date"=a.type>start${a.name?cap_first}, end${a.name?cap_first}, <#else>${a.name}, </#if></#list>pageNo, pageSize