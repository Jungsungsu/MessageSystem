package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.MessageVO;

@WebServlet("/MsgSendService")
public class MsgSendService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  // <����Ʈ ���>
		
		  // 0. �޾ƿ� �Ķ���͵��� ���ڵ�
	      request.setCharacterEncoding("euc-kr");
	      
	      // 1. �Ķ���� ����
	      String send_name = request.getParameter("send_name");
	      String receive_email= request.getParameter("receive_email");
	      String content= request.getParameter("content");
	     
	      
	      // DAO ��ü ����
	      DAO dao = new DAO();
	      
	      // DAO�� �޼��� ���
	      int cnt = dao.MsgSend(send_name,receive_email, content);
	      
	      if(cnt > 0) {
	         System.out.println("�޼��� ���� ����!");
	         // join_success.jsp
	         // forward ������� �̵�
	         
	        
	         
	      }else {
	         System.out.println("�޼��� ���� ����!");
	         // main.jsp
	         // redirect ������� �̵�
	      }
	      response.sendRedirect("main.jsp");         
	      
	      // ============================================================
	      

			
			
	      
	      
	}

}
