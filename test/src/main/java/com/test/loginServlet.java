package com.test;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 임의의 인증 정보 설정
        String aid = "admin";
        String apw = "1234";
        String aname = "Admin";

        // 사용자가 입력한 ID와 PW 가져오기
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");

        HttpSession session = request.getSession();

        // ID와 PW가 일치하는지 확인
        if (aid.equals(id) && apw.equals(pw)) {
            // 로그인 성공: 세션에 aname 저장하고 main.jsp로 리다이렉트
            session.setAttribute("aname", aname);
            response.sendRedirect("main.jsp");
        } else {
            // 로그인 실패: main.jsp로 리다이렉트
            response.sendRedirect("main.jsp");
        }
    }
}
