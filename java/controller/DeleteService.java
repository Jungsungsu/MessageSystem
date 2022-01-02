package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;

@WebServlet("/DeleteService")
public class DeleteService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 파라미터 수집
		// 쿼리스트링의 키값을 getParameter의 매개변수로 넣어줌
		String email = request.getParameter("email");
		
		// 2. DAO 객체 생성
		DAO dao = new DAO();
		
		// 3. dao의 메소드
		int cnt = dao.Delete(email);
		
		if(cnt > 0) {
			System.out.println("삭제 성공!");
		}else {
			System.out.println("삭제 실패!");
		}
		
		// 페이지 이동
		response.sendRedirect("SelectAllService");
		
	}

}
