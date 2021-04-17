package everyssafy.model.dao;
import java.util.List;
import everyssafy.model.CommentDto;

public interface CommentDao {
	//댓글 작성
		void registerComment(CommentDto commentDto);

		//댓글 수정을 위한 얻어오기
		CommentDto getComment(int commentDto);
		
		//댓글 수정
		void modifyComment(CommentDto commentDto);
		
		
		//댓글 삭제
		void deleteComment(int commentDto);
		
		//댓글 조회
		List<CommentDto> getCommentList(int articleId);
}
