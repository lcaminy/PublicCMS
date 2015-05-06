<#list conditionList as a>
	<#if "Date"=a.type>
		if (notEmpty(start${a.name?cap_first})) {
			queryMaker.condition("bean.${a.name} >= :start${a.name?cap_first}").setParameter("start${a.name?cap_first}", start${a.name?cap_first});
		}
		if (notEmpty(end${a.name?cap_first})) {
			queryMaker.condition("bean.${a.name} < :end${a.name?cap_first}").setParameter("end${a.name?cap_first}", tomorrow(end${a.name?cap_first}));
		}
	<#else>
		if (notEmpty(${a.name})) {
			queryMaker.condition("<@condition a/>").setParameter("${a.name}", <#if "String"=a.type&&a.like>like(${a.name})<#else>${a.name}</#if>);
		}
	</#if>
</#list>
<#macro condition a><#if a.or>(</#if><#list a.nameList as n>bean.${n} <#if "String"=a.type&&a.like>like<#else>=</#if> :${a.name}<#if n_has_next> or </#if></#list><#if a.or>)</#if></#macro>