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
		  
		  // <포스트 방식>
		
		  // 0. 받아올 파라미터들을 인코딩
	      request.setCharacterEncoding("euc-kr");
	      
	      // 1. 파라미터 수집
	      String send_name = request.getParameter("send_name");
	      String receive_email= request.getParameter("receive_email");
	      String content= request.getParameter("content");
	     
	      
	      // DAO 객체 생성
	      DAO dao = new DAO();
	      
	      // DAO의 메서드 사용
	      int cnt = dao.MsgSend(send_name,receive_email, content);
	      
	      if(cnt > 0) {
	         System.out.println("메세지 전송 성공!");
	         // join_success.jsp
	         // forward 방식으로 이동
	         
	        
	         
	      }else {
	         System.out.println("메세지 전송 실패!");
	         // main.jsp
	         // redirect 방식으로 이동
	      }
	      response.sendRedirect("main.jsp");         
	      
	      // ============================================================
	      

			
			
	      
	      
	}

}
