package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import dto.BoardDTO;
import mybatis.config.DBService;

public class Board {

	/* StudentDao의 모든 메소드는 factory에서 SqlSession을 얻어 낸다. */
	private SqlSessionFactory factory;
	
	private static Board instance;
	private Board() {
		factory = DBService.getInstance().getFactory();
	}
	public static Board getInstance() {
		if (instance == null) {
			instance = new Board();
		}
		return instance;
	}
	
	public List<BoardDTO> selectBoardList(){
		SqlSession ss = factory.openSession();
		List<BoardDTO> list = ss.selectList("dao.board.selectBoardList");
		ss.close();
		return list;
	}
	
}