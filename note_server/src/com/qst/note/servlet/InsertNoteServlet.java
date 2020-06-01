package com.qst.note.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.qst.note.dao.NoteDao;
import com.qst.note.result.Result;

/**
 * Servlet implementation class InsertNoteServlet
 */
@WebServlet("/InsertNoteServlet")
public class InsertNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		
		String title=request.getParameter("title");
	    String content=request.getParameter("content");
	    String tel=request.getParameter("tel");
	    String noteTime=request.getParameter("noteTime");
	    
	    NoteDao dao=new NoteDao();
	    Gson gson=new Gson();
	    Result rs=new Result();
	    rs.isSuccess=dao.insert(title, content, noteTime, tel);
	    rs.msg=rs.isSuccess?"��¼�ɹ�":"����ʧ��";
	    response.getWriter().append(gson.toJson(rs));
	
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
