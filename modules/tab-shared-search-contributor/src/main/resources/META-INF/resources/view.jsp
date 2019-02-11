<%@ page import="com.liferay.portal.kernel.util.HttpUtil" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<%
String tab = renderRequest.getParameter("tab");

String url = HttpUtil.getCompleteURL(request);

String div = "?";

if (url.contains("?"))
	div = "&";

String sportsURL = url+div+"tab=sports";
String techURL = url + div + "&tab=tech";
%>

<ul>
	<li><a href="<%= sportsURL %>">Sports</a></li>
	<li><a href="<%= techURL %>">Tech</a></li>
</ul>