<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%String name = (String) request.getAttribute("ATTRIBUTE_NAME");%>


<portlet:defineObjects />

This is the <b>Hello World</b> <%= name %>!.
