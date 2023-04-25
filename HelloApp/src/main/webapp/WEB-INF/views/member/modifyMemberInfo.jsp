<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<p>정보수정화면입니다.</p>
<form action="modifyMember.do" method="post">
    <table class="table">
        <tr>
            <th>이메일</th>
            <td><input type="text" name="email" required></td>        
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><input type="password" name="pass" required></td>
        </tr>
        <tr>
            <th>번호</th>
            <td><input type="text" name="phone" required></td>
        </tr>
        <tr>
            <th>주소</th>
            <td><input type="text" name="address" required></td>
        </tr>
        <tr>
            <td colspan="4" align="center">
                <button type="submit">정보수정</button>
                <!-- <button>회원가입</button> -->
            </td>
        </tr>
    </table>
</form>