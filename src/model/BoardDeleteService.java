package model;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.ModelAndView;
import dao.BoardDAO;
import dao.ReplyDao;
import dto.ReplyDTO;

public class BoardDeleteService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		
		Long no = Long.parseLong(request.getParameter("no"));
		

		List<ReplyDTO> replyList = ReplyDao.getInstance().selectReplyList(no);
		
		
		PrintWriter out = response.getWriter();
		if(replyList.size() == 0) {
			int result = BoardDAO.getInstance().deleteBoard(no);			
			if(result > 0) {
				out.println("<script>");
				out.println("alert('게시글 삭제 성공')");
				out.println("location.href='list.do'");
				out.println("</script>");
				out.close();
			} else {
				out.println("<script>");
				out.println("alert('게시글 삭제 실패')");
				out.println("history.back()");
				out.println("</script>");
				out.close();
			}	
		}
	
		else {
			out.println("<script>");
			out.println("alert('댓글이 달린 게시글은 삭제 불가.')");
			out.println("history.back()");
			out.println("</script>");
			out.close();		
		}
		
		return null;
	
	}

}
