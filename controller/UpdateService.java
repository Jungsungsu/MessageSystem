package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.DAO;
import Model.MemberVO;

@WebServlet("/UpdateService")
public class UpdateService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   // 0. �޾ƿ� �Ķ���͵��� ���ڵ�
	      request.setCharacterEncoding("euc-kr");
	      
	      // 1. �Ķ���� ����
	      // �̸��� --> ���ǿ����� ����Ǿ� �ִ� vo
	      HttpSession session = request.getSession();
	      MemberVO vo = (MemberVO)session.getAttribute("vo");
	      
	      
	      
	      String email = vo.getEmail();
	      // form�±� �̿��ؼ� ���� -> request.getParameter()
	      String pw = request.getParameter("pw");
	      String tel = request.getParameter("tel");
	      String address = request.getParameter("address");
	      
	      // DAO ��ü ����
	      DAO dao = new DAO();
	      
	      // DAO�κ��� ������ �޼ҵ�
	      // ���� ���� ��� (executeUpdate) : intŸ��, ������ ���� ��  
	      
	      int cnt = dao.Update(email, pw, tel, address);
	      
	      if(cnt > 0) {
	         System.out.println("���� ����!");
	         
	         // �����̸����� �ٸ� �����͸� ���� ������ �����ȴ�.
	         session.setAttribute("vo", new MemberVO(email, pw, tel, address) );
	          
	      }else {
	         System.out.println("���� ����!");
	      }   
	      	// ������ �̵�
	         response.sendRedirect("main.jsp");         
	      
	      
	      
	}
}
