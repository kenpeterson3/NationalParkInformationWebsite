<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="common/header.jsp" %>


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
			<p>
				Acreage:
				<c:out value="${park.acreage}" /> sq Km
			</p>
	<p>
		Established:
		<c:out value="${park.yearFounded }" />
	</p>
	<p>
		Number of Visitors:
		<c:out value="${park.annualVisitorCount }" />
	</p>
			<p>
				Elevation: <c:out value="${park.elevationInFeet }" /> ft.
			</p>
	<p>
		Total Miles of Trails:
		<c:out value="${park.milesOfTrail }" />
	</p>

			<p>Total Number of Campsites: No Campsites Available</p>

			<p>
				Total Number of Campsites:
				<c:out value="${park.numberOfCampsites }" />
			</p>

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
					value="/img/weather/${parkWeather[0].parsedForecast}.png" />
				<img src="${weatherImage}" />
			</div>
			<div class="currentWeatherInfo">
				<div> High: <c:out value="${parkWeather[0].high}" /> </div>
				<div> Low: <c:out value="${parkWeather[0].low}" /> </div>
			</div>
			<c:url var="conversionSubmit" value="/parkDetail/${park.parkCode}" />
			<form method="post" action="${conversionSubmit }">
				<input type="radio" name="convert" value="C">Celcius <input
					type="radio" name="convert" value="F">Fahrenheit <input
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
							<c:url var="weatherImage" value="/img/weather/${forecastWeather.parsedForecast}.png" />
							<img src="${weatherImage}" />
						</div>
						<div class="individualWeatherInfo">
							<div>  High: <c:out value="${forecastWeather.high}" /> </div>
							<div> Low: <c:out value="${forecastWeather.low}" /> </div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</div>

<%@include file="common/footer.jsp" %>