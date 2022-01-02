package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import Model.BoardVO;
import Model.DAO;

@WebServlet("/WriteBoardService")
public class WriteBoardService extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ������Ʈ ������ġ
		// request.getServletContext();
		// work space > ����ġ��Ĺ ���ε�(������ ��ġ���� �ٲ�)
		String savePath =request.getServletContext().getRealPath("img");
		
		// �ִ� ����ũ��(���� : byte) : 5MB
		int maxSize = 5*1024*1024;
		
		// ���ڵ� Ÿ��
		String encoding = "euc-kr";
		
		// request�� ����ؼ� �޾ƿ� �����͸� �������� MultipartRequest ��ü
		MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
	
		// �Ķ���� ����
		// MultipartRequest ��ü�κ��� �Ķ���� ����
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		
		// ���� �̸��� �����ö���
		// getFilesystemName("name��")
		String fileName = multi.getFilesystemName("file");
		
		String content = multi.getParameter("content");
		
		// DAO �޼ҵ� ����ؼ� web_board ���̺� ����
		DAO dao = new DAO();
		int cnt = dao.WriteBoard(writer, title, fileName, content);
		
		if (cnt > 0) {
			System.out.println("�Խñ� �ۼ� ����!");
			
			// 1. request�� ������ file�� ������ ������ �̵� --> VO�� ����ؼ� ����
			// ������ BoardVO �����ڴ� �Ű������� 6������ ��� �޾���
			// ���� ��ư����� 4�����ۿ� ���� ---> �����ڸ� �ϳ� �� ������ָ� �ȴ�.
			// �̸��� ������ �Ű����� �ٸ� --> �����ε�
			request.setAttribute("bvo", new BoardVO(writer, title, fileName, content));
			
			// request������ �����͸� �����ؼ� �̵��Ϸ��� >> forward���
			RequestDispatcher rd = request.getRequestDispatcher("viewBoard.jsp");
			rd.forward(request, response);
		
		}else {
			System.out.println("�Խñ� �ۼ� ����!");
		}
		
	}
		
	
}
