
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<style>

    section.write_box {
        width: 100vw;
    }

    .table_box {
        width: 100%;
        display: flex;
        justify-items: center;
        align-content: center;
    }

    table.write_table {
        width: 90%;
        margin: 15px auto;
    }

    table.write_table td{
        padding: 0.5rem;
    }

    table.write_table input{
        height: 45px;
        width: 100%;
        border: 1px solid blueviolet ;
        text-align: left;
        padding: 0.5rem;
    }

    table.write_table input:focus {
        outline: none;
        border: none;
        background-color:thistle ;
    }

    .btn_box {
        width: 100%;
        display: flex;
    }

    .btn_box button{
        padding: 1rem;
        background-color: indigo;
        outline: none;
        border: none;
        border-radius: 5px;
        color: white;
        margin: 15px;
        cursor: pointer;
    }

    .btn_box button:first-of-type {
        margin-left: auto;
    }
    .btn_box button:last-of-type {
        margin-right: 5%;
    }

</style>

<section class="write_box" >
    <div class="table_box">
        <table class="write_table">
            <tr>
                <td colspan="2"><input placeholder="책일련번호"/></td>
                <td colspan="2"><input placeholder="책이름"/></td>
            </tr>
            <tr>
                <td colspan="2"><input placeholder="읽은 날짜"/></td>
                <td><input placeholder="읽기 시작한 시간"/></td>
                <td><input placeholder="다 읽은 시간"/></td>
            </tr>
            <tr>
                <td colspan="4"><input placeholder="한 줄 감상"/></td>
            </tr>
            <tr>
                <td colspan="4"><input placeholder="내용"/></td>
            </tr>
        </table>
    </div>

    <div class="btn_box">
        <button>저장</button>
        <button>새로작성</button>
        <button>리스트로</button>
    </div>

</section>