package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO;
import Model.MemberVO;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		   // 1. id, pw �Ķ���� ����
		   String email = request.getParameter("email");
		   String pw = request.getParameter("pw");
		   
		   // DAO ��ü ����
		   DAO dao = new DAO();
		   dao.Login(email, pw);
		   MemberVO vo = dao.Login(email, pw);
		   
		   // �α��� ���� / ���� �Ǵ�
		   // vo�� null�̸� : �α��� ����
		   // vo�� null�� �ƴ϶�� : �α��� ����
		   
		   if(vo != null) {
			   //����
			   System.out.println("�α��� ����");
			   
			   // ���ǿ� ������ ������ ��Ƽ� ����
			   // 1. ���� ��ü ����
			   HttpSession session = request.getSession();
			   
			   // 2. ���ǿ� Attribute �߰�
			   session.setAttribute("vo", vo);
			   
		   }else {
			   //����
			   System.out.println("�α��� ����");
		   }
		   
		   response.sendRedirect("main.jsp");
		   
		   
		   
		 
		 
		   
		   
		

	}

}
