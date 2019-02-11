<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %><%@
page import="com.liferay.portal.kernel.util.PortalUtil" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%
String tab = renderRequest.getParameter("tab");

String url = PortalUtil.getCurrentCompleteURL(request);

String sportsURL = HttpUtil.setParameter(url, "tab", "sports");
String techURL = HttpUtil.setParameter(url, "tab", "tech");
%>

<ul>
	<li><a href="<%= sportsURL %>">Sports</a></li>
	<li><a href="<%= techURL %>">Tech</a></li>
</ul>
