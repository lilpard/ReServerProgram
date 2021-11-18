package model;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.ReplyDao;
import dto.ReplyDTO;

public class ReplyInsertService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String author = request.getParameter("author");
		String content = request.getParameter("content");
		Long board_no = Long.parseLong(request.getParameter("no"));
		String ip = request.getRemoteAddr();
		
		
		ReplyDTO reply = new ReplyDTO();
		reply.setAuthor(author);
		reply.setContent(content);
		reply.setBoard_no(board_no);
		reply.setIp(ip);
		
		int result = ReplyDao.getInstance().insertReply(reply);

		if(result > 0) {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('댓글 등록 성공');");
			out.println("location.href='selectView.do?no="+ board_no + "'");
			out.println("</script>");
			out.close();
		}else {
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('댓글 달기 실패');");
			out.println("history.back()");
			out.println("</script>");
			out.close();
		}
		
		return null;
	}

}
