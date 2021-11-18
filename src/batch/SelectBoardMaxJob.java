package batch;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import dao.BoardDAO;
import dto.BoardDTO;

// 인터페이스  JOB을 상속받아야 한다.
public class SelectBoardMaxJob implements Job {

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		
		BoardDTO board = BoardDAO.getInstance().selectTopList();
		
		System.out.println("=== 최대 조회수 게시글 ===");
		System.out.println("제목: " +board.getTitle().toString());
		System.out.println("내용: " +board.getContent().toString());
		System.out.println("조회수: " + board.getHit());
		
	}

}
