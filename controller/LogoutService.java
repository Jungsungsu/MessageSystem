package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.ha.session.SessionMessage;

import Model.DAO;
import Model.MemberVO;

@WebServlet("/LogoutService")
public class LogoutService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 로그아웃 기능
		// vo가 null인지 아닌지
		// vo --> Session 영역 저장
		
		// 1. 세션 객체 생성
		   HttpSession session =  request.getSession();
		
		// 2. 세션 삭제
		// removeAttribute --> 1개 삭제
		// invalidate() --> 세션에 저장된 모든값 삭제
		   session.removeAttribute("vo");
		   
		// 3. 페이지 이동
		   response.sendRedirect("main.jsp");
		
		   
		
	}

}
