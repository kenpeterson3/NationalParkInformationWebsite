<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/header.jsp" %>


<c:forEach items="${parks }" var="entry">
<div class="contentContainer">
<div class="parkImage">
<c:url var="parkLink" value="/parkDetail/${entry.parkCode }" />
<a href="${parkLink }" >
<img src="img/parks/${entry.parkCode.toLowerCase() }.jpg"/></a>
</div>

<div class="parkInfo">

<h2><a href="${parkLink }" ><c:out value="${entry.parkName }"/></a></h2>
<p><c:out value="${entry.parkDescription }"/></p>
</div>
</div>
</c:forEach>

<%@include file="common/footer.jsp" %>