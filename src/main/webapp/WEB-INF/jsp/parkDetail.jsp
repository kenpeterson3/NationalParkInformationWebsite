<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/header.jsp" %>

<%-- <c:catch var="convert">${weatherConversion.convert}</c:catch> --%>
<%-- 	<c:if test="${not empty exception}"> --%>
<%-- 		<c:set var="convert" value="false"/> --%>
<%-- 	</c:if> --%>

<h2><c:out value="${park.parkName}"/></h2>

<div>
	<c:url var="imageLink" value="/img/parks/${park.parkCode.toLowerCase() }.jpg" />
	<img src="${imageLink }" />
</div>

<div>
	<p>
		<em>"<c:out value="${park.inspirationalQuote }" />" -<c:out
				value="${park.inspirationalQuoteSource }" /></em>
	</p>
</div>

<div>
	<p>
		<c:out value="${park.parkDescription }" />
	</p>
	<p>
		Entry Fee: $
		<c:out value="${park.entryFee }" />
	</p>
	<p>
		State:
		<c:out value="${park.state }" />
	</p>
	<c:choose>
		<c:when test="${weatherConversion.convert == true }">
			<p>
				Acreage:
				<c:out value="${Conversion.sqMilesToSqKilometers(park.acreage)}" /> sq Km
			</p>
		</c:when>
		<c:otherwise>
			<p>
				Acreage:
				<c:out value="${park.acreage}" />
				sq mi
			</p>		
		</c:otherwise>
	</c:choose>
	<p>
		Established:
		<c:out value="${park.yearFounded }" />
	</p>
	<p>
		Number of Visitors:
		<c:out value="${park.annualVisitorCount }" />
	</p>
	<c:choose>
		<c:when test="${weatherConversion.convert == true }">
			<p>
				Elevation: <c:out value="${Conversion.ftToMeters(park.elevationInFeet) }" /> meters
		</c:when>
		<c:otherwise>
			<p>
				Elevation: <c:out value="${park.elevationInFeet }" /> ft.
			</p>
		</c:otherwise>
	</c:choose>

	<p>
		Total Miles of Trails:
		<c:out value="${park.milesOfTrail }" />
	</p>
	<c:choose>
		<c:when test="${park.numberOfCampsites == 0 }">
			<p>Total Number of Campsites: No Campsites Available</p>
		</c:when>
		<c:otherwise>
			<p>
				Total Number of Campsites:
				<c:out value="${park.numberOfCampsites }" />
			</p>
		</c:otherwise>
	</c:choose>
	<p>
		Total Number of Animal Species:
		<c:out value="${park.numberOfAnimalSpecies }" />
	</p>
</div>

<div class="weatherContainer">

	<div class="currentWeatherContainer">
		<div class="currentWeather">
			<div class="currentWeatherImage">
				<h3>Today</h3>
				<c:url var="weatherImage"
					value="/img/weather/${parkWeather[0].forecast}.png" />
				<img src="${weatherImage}" />
			</div>
			<div class="currentWeatherInfo">
				High:
				<c:out value="${parkWeather[0].high}" />
				Low:
				<c:out value="${parkWeather[0].low}" />
			</div>
			<c:url var="conversionSubmit" value="/parkDetail/${park.parkCode}" />
			<form method="post" action="${conversionSubmit }">
				<input type="radio" name="convert" value=true>Celcius <input
					type="radio" name="convert" value=false>Fahrenheit <input
					type="submit">
			</form>

			<p>
				<c:out value="${parkWeather[0].weatherMessage}" />
			</p>
		</div>

		<div class="fourDayWeatherContainer">
			<c:forEach items="${parkWeather}" var="forecastWeather">
				<c:if test="${forecastWeather.fiveDayForcastValue > 0}">
					<div class="individualForecasts">
						<div class="individualImage">
							<c:url var="weatherImage" value="/img/weather/${forecastWeather.forecast}.png" />
							<img src="${weatherImage}" />
						</div>
						<div class="individualWeatherInfo">
							High: <c:out value="${forecastWeather.high}" />
							Low: <c:out value="${forecastWeather.low}" />
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</div>

<%@include file="common/footer.jsp" %>