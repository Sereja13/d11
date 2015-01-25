<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">               
                    <div style="size: 20px; text-align: right; margin-right:10px">
                        <form action="<c:url value="/j_spring_security_check" />" method="post">
                            <label>Email: <input type="text" name="j_username" /></label></br>
                            <label>Password: <input type="password" name="j_password" /></label>
                            <div style="text-align: right;">
                                <input type="submit" value="Login" />
                            </div>               
                        </form>
                    </div>               
    </tiles:putAttribute>
</tiles:insertDefinition>