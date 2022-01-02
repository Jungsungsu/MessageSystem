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
import Model.MemberVO;
@WebServlet("/SelectAllService")
public class SelectAllService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		   // 1. DAO 객체 생성
		   DAO dao = new DAO();
		   
		   // 2. DAO가 가진 SelectAll() --> 회원 정보를 전부 가지고 올것
		   ArrayList<MemberVO> list = dao.SelectAll(); 
		   
		
		   System.out.println(list.size());
	
		   // request 영역에 Attribute를 추가
		   // request의 주머니에 데이터를 담아둔다.
		   request.setAttribute("list", list);
		   
		    // forward방식으로 페이지를 이동
		   // 항상 네비게이션을 먼저 찍어된다.
			RequestDispatcher res = request.getRequestDispatcher("select.jsp");
			
			// 출발
			res.forward(request,response);
			
			
		   
		   // MemberVO --> 몇명인지 모름 --> ArrayList<MemberVO> 이름 = new ArrayList<MemberVO>();
		  
		   
		   // ArrayList.add(추가할 데이터)
		 
		   
		   // SelectAll()은 ArrayList<MemberVO>를 리턴
		   
		   
	}

}
