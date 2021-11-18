package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.BoardDTO;
import mybatis.config.DBService;

public class BoardDAO {

	/* StudentDao의 모든 메소드는 factory에서 SqlSession을 얻어 낸다. */
	private SqlSessionFactory factory;
	
	private static BoardDAO instance;
	private BoardDAO() {
		factory = DBService.getInstance().getFactory();
	}
	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	public List<BoardDTO> selectBoardList(){
		SqlSession ss = factory.openSession();
		List<BoardDTO> list = ss.selectList("dao.board.selectBoardList");
		ss.close();
		return list;
	}
	public int totalBoard() {
		SqlSession ss = factory.openSession();
		int total = ss.selectOne("dao.board.totalBoard");
		ss.close();
		return total;
	}
	
	public int insertBoard(BoardDTO board) {
		SqlSession ss = factory.openSession(false);
		int result = ss.insert("dao.board.insertBoard", board);
		if(result > 0 ) ss.commit();
		ss.close();
		return result;
	}
	
	public int updateBoardHit(Long no) {
		SqlSession ss = factory.openSession();
		int result = ss.update("dao.board.updateBoardHit", no);
		if(result > 0 ) ss.commit();
		return result;
	}
	
	public BoardDTO selectBoard(Long no) {
		SqlSession ss = factory.openSession();
		BoardDTO board = ss.selectOne("dao.board.selectBoard", no);
		ss.close();
		return board;
	}
	
	public int deleteBoard(Long no) {
		SqlSession ss = factory.openSession();
		int result = ss.delete("dao.board.deleteBoard", no);
		if(result > 0 ) ss.commit();
		return result;
	}
	
	public BoardDTO selectTopList() {
		SqlSession ss = factory.openSession();
		BoardDTO board = ss.selectOne("dao.board.selectTopList");
		ss.close();
		return board;
	}
}