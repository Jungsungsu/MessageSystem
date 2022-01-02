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
		
		   // 0. 받아올 파라미터들을 인코딩
	      request.setCharacterEncoding("euc-kr");
	      
	      // 1. 파라미터 수집
	      // 이메일 --> 세션영역에 저장되어 있는 vo
	      HttpSession session = request.getSession();
	      MemberVO vo = (MemberVO)session.getAttribute("vo");
	      
	      
	      
	      String email = vo.getEmail();
	      // form태그 이용해서 보냄 -> request.getParameter()
	      String pw = request.getParameter("pw");
	      String tel = request.getParameter("tel");
	      String address = request.getParameter("address");
	      
	      // DAO 객체 생성
	      DAO dao = new DAO();
	      
	      // DAO로부터 꺼내올 메소드
	      // 쿼리 실행 결과 (executeUpdate) : int타입, 성공한 행의 수  
	      
	      int cnt = dao.Update(email, pw, tel, address);
	      
	      if(cnt > 0) {
	         System.out.println("수정 성공!");
	         
	         // 같은이름으로 다른 데이터를 집어 넣으면 덮어쓰기된다.
	         session.setAttribute("vo", new MemberVO(email, pw, tel, address) );
	          
	      }else {
	         System.out.println("수정 실패!");
	      }   
	      	// 페이지 이동
	         response.sendRedirect("main.jsp");         
	      
	      
	      
	}
}
