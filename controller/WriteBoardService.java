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
		
		// 프로젝트 파일위치
		// request.getServletContext();
		// work space > 아파치톰캣 업로드(폴더의 위치들이 바뀜)
		String savePath =request.getServletContext().getRealPath("img");
		
		// 최대 파일크기(단위 : byte) : 5MB
		int maxSize = 5*1024*1024;
		
		// 인코딩 타입
		String encoding = "euc-kr";
		
		// request를 대신해서 받아온 데이터를 정제해줄 MultipartRequest 객체
		MultipartRequest multi = new MultipartRequest(request, savePath, maxSize, encoding, new DefaultFileRenamePolicy());
	
		// 파라미터 수집
		// MultipartRequest 객체로부터 파라미터 수집
		String title = multi.getParameter("title");
		String writer = multi.getParameter("writer");
		
		// 파일 이름을 가져올때는
		// getFilesystemName("name값")
		String fileName = multi.getFilesystemName("file");
		
		String content = multi.getParameter("content");
		
		// DAO 메소드 사용해서 web_board 테이블에 저장
		DAO dao = new DAO();
		int cnt = dao.WriteBoard(writer, title, fileName, content);
		
		if (cnt > 0) {
			System.out.println("게시글 작성 성공!");
			
			// 1. request의 영역에 file의 정보를 가지고 이동 --> VO를 사용해서 묶음
			// 기존의 BoardVO 생성자는 매개변수로 6가지를 모두 받았음
			// 지금 담아갈것은 4가지밖에 없음 ---> 생성자를 하나 더 만들어주면 된다.
			// 이름은 같은데 매개변수 다른 --> 오버로딩
			request.setAttribute("bvo", new BoardVO(writer, title, fileName, content));
			
			// request영역에 데이터를 저장해서 이동하려면 >> forward방식
			RequestDispatcher rd = request.getRequestDispatcher("viewBoard.jsp");
			rd.forward(request, response);
		
		}else {
			System.out.println("게시글 작성 실패!");
		}
		
	}
		
	
}
