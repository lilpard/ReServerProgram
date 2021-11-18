package model;

import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.BoardDAO;
import dao.ReplyDao;
import dto.BoardDTO;
import dto.ReplyDTO;

public class BoardViewService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		
		Optional<String> optNo = Optional.ofNullable(request.getParameter("no"));
		Long no = Long.parseLong(optNo.orElse("0"));
		
		if( session.getAttribute("open") == null ) {
			session.setAttribute("open", true);
			BoardDAO.getInstance().updateBoardHit(no);
		}	
		
		BoardDTO board = BoardDAO.getInstance().selectBoard(no);
		PrintWriter out = response.getWriter();
		if(board != null) {
			
			session.setAttribute("board", board);
			
			List<ReplyDTO> replyList = ReplyDao.getInstance().selectReplyList(no);
			
			request.setAttribute("replyList", replyList);
			request.setAttribute("board", board);
			
			
			return new ModelAndView("views/view.jsp", false);
		}
		else {
			
			return null;
		}
		
	}

}
