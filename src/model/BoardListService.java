package model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ModelAndView;
import dao.BoardDAO;
import dto.BoardDTO;

public class BoardListService implements MemberService {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();
		// 상세 보기할 때 session에 올려 둔 notice를 제거한다.
		BoardDTO board = (BoardDTO)session.getAttribute("board");
		if(board != null) {
			session.removeAttribute("board");
		}
		
		// 상세 보기할 때 session에 올려둔 open을 제거
		if(session.getAttribute("open") != null) {
			session.removeAttribute("open");
		}
		
		List<BoardDTO> list = BoardDAO.getInstance().selectBoardList();
		int total = BoardDAO.getInstance().totalBoard();
		request.setAttribute("list", list);
		request.setAttribute("total", total);
		return new ModelAndView("views/listBoard.jsp", false);
	}

}
