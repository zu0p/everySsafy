package everyssafy.model.service;

import java.util.List;

import everyssafy.model.CommentDto;
import everyssafy.model.dao.CommentDaoImpl;

public class CommentServiceImpl implements CommentService
{
	private static CommentService commentService;
	private CommentServiceImpl() {}
	public static CommentService getCommentService()
	{
		if(commentService == null) commentService = new CommentServiceImpl();
		return commentService;
	}
	public void registerComment(CommentDto commentDto) {
		CommentDaoImpl.getCommentDao().registerComment(commentDto);
	}

	@Override
	public CommentDto getComment(int commentId) {
		return CommentDaoImpl.getCommentDao().getComment(commentId);
	}

	@Override
	public void modifyComment(CommentDto commentDto) {
		CommentDaoImpl.getCommentDao().modifyComment(commentDto);
	}

	@Override
	public void deleteComment(int commentId) {
		CommentDaoImpl.getCommentDao().deleteComment(commentId);
	}

	@Override
	public List<CommentDto> getCommentList(int articleId) {
		return CommentDaoImpl.getCommentDao().getCommentList(articleId);
	}

}
