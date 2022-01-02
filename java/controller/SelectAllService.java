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
		
		   // 1. DAO ��ü ����
		   DAO dao = new DAO();
		   
		   // 2. DAO�� ���� SelectAll() --> ȸ�� ������ ���� ������ �ð�
		   ArrayList<MemberVO> list = dao.SelectAll(); 
		   
		
		   System.out.println(list.size());
	
		   // request ������ Attribute�� �߰�
		   // request�� �ָӴϿ� �����͸� ��Ƶд�.
		   request.setAttribute("list", list);
		   
		    // forward������� �������� �̵�
		   // �׻� �׺���̼��� ���� ���ȴ�.
			RequestDispatcher res = request.getRequestDispatcher("select.jsp");
			
			// ���
			res.forward(request,response);
			
			
		   
		   // MemberVO --> ������� �� --> ArrayList<MemberVO> �̸� = new ArrayList<MemberVO>();
		  
		   
		   // ArrayList.add(�߰��� ������)
		 
		   
		   // SelectAll()�� ArrayList<MemberVO>�� ����
		   
		   
	}

}
