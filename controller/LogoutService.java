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
		
		// �α׾ƿ� ���
		// vo�� null���� �ƴ���
		// vo --> Session ���� ����
		
		// 1. ���� ��ü ����
		   HttpSession session =  request.getSession();
		
		// 2. ���� ����
		// removeAttribute --> 1�� ����
		// invalidate() --> ���ǿ� ����� ��簪 ����
		   session.removeAttribute("vo");
		   
		// 3. ������ �̵�
		   response.sendRedirect("main.jsp");
		
		   
		
	}

}
