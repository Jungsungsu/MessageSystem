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
		
		// 1. �Ķ���� ����
		// ������Ʈ���� Ű���� getParameter�� �Ű������� �־���
		String email = request.getParameter("email");
		
		// 2. DAO ��ü ����
		DAO dao = new DAO();
		
		// 3. dao�� �޼ҵ�
		int cnt = dao.Delete(email);
		
		if(cnt > 0) {
			System.out.println("���� ����!");
		}else {
			System.out.println("���� ����!");
		}
		
		// ������ �̵�
		response.sendRedirect("SelectAllService");
		
	}

}
