package everyssafy.model;

public class BoardDto {
	private int boardId;
	private String boardTitle;
	
	public BoardDto(String boardTitle){
		this.boardTitle=boardTitle;
	}
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	
	
}
