package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.MemberVO;

@WebServlet("/JoinService")
public class JoinService extends HttpServlet {
   private static final long serialVersionUID = 1L;
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      // 0. �޾ƿ� �Ķ���͵��� ���ڵ�
      request.setCharacterEncoding("euc-kr");
      
      // 1. �Ķ���� ����
      String email = request.getParameter("email");
      String pw = request.getParameter("pw");
      String tel = request.getParameter("tel");
      String address = request.getParameter("address");
      
      // DAO ��ü ����
      DAO dao = new DAO();
      
      // DAO�� Join�޼��� ���
      int cnt = dao.Join(email, pw, tel, address);
      
      if(cnt > 0) {
         System.out.println("ȸ������ ����!");
         // join_success.jsp
         // forward ������� �̵�
         
         request.setAttribute("vo", new MemberVO(email, pw, tel, address) );
         
         RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp");
         rd.forward(request, response);
         
      }else {
         System.out.println("ȸ������ ����!");
         // main.jsp
         // redirect ������� �̵�
         response.sendRedirect("main.jsp");         
      }
      
      
      
      
      
      
      
      
      
   }
   
}
