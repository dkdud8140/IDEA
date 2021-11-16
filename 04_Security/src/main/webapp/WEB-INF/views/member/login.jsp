<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${rootPath}/webjars/jquery/dist/jquery.min.js"></script>

<style>

    form.login_form {
        width: 400px;
        padding: 40px;
        background-color: #eee;
        text-align: center;
        border-radius: 2px;
        box-shadow: 12px 12px 2px 1px rgba(0,0,255, 0.3);
        margin: 20px auto;
    }

    form.login_form h3 {
        color: rgba(0,0,255, 0.5);
        font-weight: 700;
    }


    form.login_form input{
        background:none;
        margin: 20px auto;
        text-align: center;
        border: 2px solid black;
        padding: 13px 10px;
        width: 200px;
        outline: none;
        border-radius: 2px;
        transition: 0.2s;
    }

    form.login_form input:focus{
        width: 200px;
        border-color: rgba(0,0,255, 0.3);

    }

    form.login_form button {
        display: block;
        background-color: rgba(0,0,255, 0.3);
        margin: 20px auto;
        width: 150px;
        padding: 13px 10px;
        text-align: center;
        outline: none;
        border: none;
        border-radius: 2px;
        transition: 0.3s;
    }

    form.login_form button:hover {
        background-color: black;
        color: white;
        cursor: pointer;
    }


</style>


<script>
    $(function() {
            $("button.btn_to_join").on("click",function(){
                location.href = "${rootPath}/member/join"
            })
        }
    )
</script>

<form:form action="${rootPath}/login" cssClass="login_form">
    <fieldset>
        <legend>로그인</legend>
        <c:if test="${param.error != null}">
            <h3>로그인하십셔</h3>

        </c:if>
        <input placeholder="사용자ID" name="username">
        <input placeholder="password" name="password" type="password" >
        <button>LOGIN</button>
        <button type="button" class="btn_to_join">JOIN</button>
    </fieldset>
</form:form>
