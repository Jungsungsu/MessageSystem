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
      
      // 0. 받아올 파라미터들을 인코딩
      request.setCharacterEncoding("euc-kr");
      
      // 1. 파라미터 수집
      String email = request.getParameter("email");
      String pw = request.getParameter("pw");
      String tel = request.getParameter("tel");
      String address = request.getParameter("address");
      
      // DAO 객체 생성
      DAO dao = new DAO();
      
      // DAO의 Join메서드 사용
      int cnt = dao.Join(email, pw, tel, address);
      
      if(cnt > 0) {
         System.out.println("회원가입 성공!");
         // join_success.jsp
         // forward 방식으로 이동
         
         request.setAttribute("vo", new MemberVO(email, pw, tel, address) );
         
         RequestDispatcher rd = request.getRequestDispatcher("join_success.jsp");
         rd.forward(request, response);
         
      }else {
         System.out.println("회원가입 실패!");
         // main.jsp
         // redirect 방식으로 이동
         response.sendRedirect("main.jsp");         
      }
      
      
      
      
      
      
      
      
      
   }
   
}
