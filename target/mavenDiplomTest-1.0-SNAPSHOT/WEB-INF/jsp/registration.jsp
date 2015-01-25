<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">               
        <div style="size: 20px; text-align: center; margin-right:10px">
            <form method="get" action="<c:url value="/user/userSave"/>">
                <label for="name">Name:</label>
                <input type="text" name="name" />
                <label for="email">Email:</label>
                <input type="text" name="email" />
                <label for="password">Password:</label>
                <input type="text" name="password" />
                <input type="submit" value="Add" />
            </form>
        </div>               
    </tiles:putAttribute>
</tiles:insertDefinition>
