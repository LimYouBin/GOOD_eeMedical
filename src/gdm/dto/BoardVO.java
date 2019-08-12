package gdm.dto;

import java.sql.Date;

public class BoardVO {
	private int board_no;
	private int member_no;
	private String board_title;
	private String board_pwd;
	private Date postdate;
	private Date modifydate;
	private String writer;
	private String content;
	private String contentimg;
	private int viewcnt;
	private int likecnt;
	private int unlikecnt;
	
	public BoardVO(int board_no, int member_no, String board_title, String board_pwd, Date postdate, Date modifydate,
			String writer, String content, String contentimg, int viewcnt, int likecnt, int unlikecnt) {
		super();
		this.board_no = board_no;
		this.member_no = member_no;
		this.board_title = board_title;
		this.board_pwd = board_pwd;
		this.postdate = postdate;
		this.modifydate = modifydate;
		this.writer = writer;
		this.content = content;
		this.contentimg = contentimg;
		this.viewcnt = viewcnt;
		this.likecnt = likecnt;
		this.unlikecnt = unlikecnt;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_pwd() {
		return board_pwd;
	}

	public void setBoard_pwd(String board_pwd) {
		this.board_pwd = board_pwd;
	}

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	public Date getModifydate() {
		return modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentimg() {
		return contentimg;
	}

	public void setContentimg(String contentimg) {
		this.contentimg = contentimg;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public int getLikecnt() {
		return likecnt;
	}

	public void setLikecnt(int likecnt) {
		this.likecnt = likecnt;
	}

	public int getUnlikecnt() {
		return unlikecnt;
	}

	public void setUnlikecnt(int unlikecnt) {
		this.unlikecnt = unlikecnt;
	}

	@Override
	public String toString() {
		return "BoardVO [board_no=" + board_no + ", member_no=" + member_no + ", board_title=" + board_title
				+ ", board_pwd=" + board_pwd + ", postdate=" + postdate + ", modifydate=" + modifydate + ", writer="
				+ writer + ", content=" + content + ", contentimg=" + contentimg + ", viewcnt=" + viewcnt + ", likecnt="
				+ likecnt + ", unlikecnt=" + unlikecnt + "]";
	}
}
