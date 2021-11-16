<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${rootPath}/webjars/jquery/dist/jquery.min.js"></script>

<style>

    form.join_form {
        width: 400px;
        padding: 40px;
        background-color: #eee;
        text-align: center;
        border-radius: 2px;
        box-shadow: 12px 12px 2px 1px rgba(0,0,255, 0.3);
        margin: 20px auto;
    }

    form.join_form h3 {
        color: rgba(0,0,255, 0.5);
        font-weight: 700;
    }


    form.join_form input{
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

    form.join_form input:focus{
        width: 200px;
        border-color: rgba(0,0,255, 0.3);

    }

    form.join_form button {
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

    form.join_form button:hover {
        background-color: black;
        color: white;
        cursor: pointer;
    }
    div.input_error {
        background-color: aquamarine;
        color: red;
        font-weight: 700;
    }


</style>

<script>

    $(function(){

        $("input#username").on("blur",function (){
            $.ajax({
                url : "${rootPath}/member/idcheck",
                data:{username:$(this).val()}
            })
            .done(function (result){
                if(result) {
                    // alert("이미 사용중인 ID")
                    $("div.input_error").text(
                        "사용중인아이디"
                    )
                    $(this).focus()
                } else {
                    // alert("사용가능한 아이다")
                    $("div.input_error").text(
                        "사용가능한 아이디"
                    ).css("color","#ccc")

                    $("#password").focus()
                }
            })
        })



        $("button.btn_join_ok").on("click",function (){
            const username = $("#username")
            const password = $("#password")
            const re_password = $("#re_password")
            if(username.val() === "") {
                alert("사용자 이름은 반드시 입력하세요")
                username.focus()
                return false
            }
            if(password.val() === "") {
                alert("비밀번호는 반드시 입력하세요")
                password.focus()
                return false
            }
            if(re_password.val() === "") {
                alert("비밀번호를 한번 더 입력해 주세요")
                re_password.focus()
                return false
            }
            if(password.val() !== re_password.val()) {
                alert("비밀번호와 비밀번호 확인이 일치하지 않습니다")
                password.val("")
                re_password.val("")
                password.focus()
                return false
            }
            $("form.join_form").submit()
        })
    })
</script>


<form:form action="${rootPath}/join" cssClass="join_form">
    <fieldset>
        <legend>회원가입</legend>
        <input id="username" placeholder="사용자ID" name="username">
        <div class="input_error"></div>
        <input id="password" placeholder="비밀번호" name="password" type="password" >
        <input id="re_password" placeholder="비밀번호확인" name="re_password" type="password" >
        <input placeholder="E-mail" name="email" type="email" >
        <button class="btn_join_ok">JOIN</button>
    </fieldset>
</form:form>
