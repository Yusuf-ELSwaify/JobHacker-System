<%--@elvariable id="ageAtDate" type="java.util.Date"--%>
<%--@elvariable id="birthDate" type="java.util.Date"--%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<body>
    <form action="">
        Date of birth
        <input type="date" value="${param.birthDay}" name="birthDay" required/>
        <br>
        Age at the date of
        <input type="date" value="${param.ageAt}" name="ageAt" required/>
        <input type="submit" value="Calculate"/>
    </form>

    <c:if test="${empty param.birthDay || empty param.ageAt}">
        <b>The birth and age-at dates are required.</b>
    </c:if>
    <c:if test="${!empty param.birthDay && !empty param.ageAt}">
        <fmt:parseDate value = "${param.birthDay}"
                       var = "birthDate"
                       pattern = "yyyy-MM-dd"/>
        <fmt:parseDate value = "${param.ageAt}"
                       var = "ageAtDate"
                       pattern = "yyyy-MM-dd" />

        <c:if test="${ageAtDate.time lt birthDate.time}">
            <font style="color: red; font-size: large">
                Age-at date can't be bigger than birth-date.
            </font>
        </c:if>

        <c:if test="${ageAtDate.time ge birthDate.time}">
            <c:set var="timeDiff" value="${ageAtDate.time - birthDate.time}"/>
            <div style="width: 100%; color: white; background-color: green">
                <b>Result</b>
            </div>
            <b>Age:</b><br>
            ${(timeDiff / (1000*60*60*24*30*12)).intValue()} years <br>
            or ${(timeDiff / (1000*60*60*24*30)).intValue()} months <br>
            or ${(timeDiff / (1000*60*60*24)).intValue()} days <br>
            or ${(timeDiff / (1000*60*60)).intValue()} hours <br>
            or ${(timeDiff / (1000*60)).intValue()} minutes <br>
            or ${(timeDiff / (1000)).longValue()} seconds <br>

<%--        ${ageAtDate.year - birthDate.year} years <br>--%>
<%--        ${ageAtDate.month - birthDate.month} months <br>--%>
<%--        ${ageAtDate.date - birthDate.date} days <br>--%>
<%--        ${ageAtDate.hours - birthDate.hours} hours <br>--%>
<%--        ${ageAtDate.minutes - birthDate.minutes} minutes <br>--%>
<%--        ${ageAtDate.seconds - birthDate.seconds} seconds <br>--%>
        </c:if>
    </c:if>

</body>
</html>
