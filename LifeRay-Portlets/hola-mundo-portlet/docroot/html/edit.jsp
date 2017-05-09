<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

This is the <b>Hola Mundo Portlet</b> portlet in Edit mode 2.

<form action="<portlet:actionURL />" method="post"	name="<portlet:namespace/>fm">
	<label for="<portlet:namespace/>name">Name: </label>
	<input name="<portlet:namespace/>name" type="text" />
	<br>
	<br>
	<input type="submit" value="AÑADIR VALOR" />	
</form>