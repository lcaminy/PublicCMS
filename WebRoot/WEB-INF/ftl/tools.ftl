<#ftl>
<#macro m code>${springMacroRequestContext.getMessage(code,code)}</#macro>
<#macro cut string l=50><#if string?length lt l>${string}<#else>${string[0..l-1]}</#if></#macro>
<#macro urlPrefix code><#if code=0>http://<#elseif code=1>http://www.<#else>未知</#if></#macro>
<#macro referer visitor><#if visitor.refererType =1>-<#elseif visitor.refererType =2><a href="${visitor.refererUrl}" title="${visitor.refererUrl}" target="_blank">${visitor.refererName} : "${visitor.refererKeyword}"</a><#elseif visitor.refererType =3><a href="${visitor.refererUrl}" title="${visitor.refererUrl}" target="_blank">${visitor.refererName}</a></#if></#macro>
<#macro highlighter content keyword><#local index=content?index_of(keyword) />${content?substring(content?substring(0,index)?last_index_of('<p'),content?index_of('</p>',index)+4)?replace(keyword,'<font color="#ff0000">'+keyword+'</font>')}</#macro>
