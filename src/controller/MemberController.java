package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import model.BoardDeleteService;
import model.BoardInsertService;
import model.BoardListService;
import model.BoardViewService;
import model.MemberService;
import model.ReplyInsertService;

@WebServlet("*.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String requestURI = request.getRequestURI();                       
		String contextPath = request.getContextPath();                  
		String command = requestURI.substring(contextPath.length() + 1); 
		
		ModelAndView mav = null;
		MemberService service =null;
		switch (command) {
		case "list.do":
			service = new BoardListService();
			break;
		case "insertForm.do":
			mav = new ModelAndView("views/insert.jsp", false);
			break;
		case "insert.do":
			service = new BoardInsertService();
			break;
		case "selectView.do":
			service = new BoardViewService();
			break;
		case "insertReply.do":
			service = new ReplyInsertService();
			break; 
		case "delete.do":
			service = new BoardDeleteService();
		}
		
		if ( service != null) {
			try {
				mav = service.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (mav != null) {
			if (mav.isRedirect()) {
				response.sendRedirect(mav.getView());
			} else {
				request.getRequestDispatcher(mav.getView()).forward(request, response);
			}
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
