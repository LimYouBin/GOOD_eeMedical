package gdm.dto;

import java.sql.Date;

public class BdreplyVO {
	private int reply_no;
	private int board_no;
	private int member_no;
	private String writer;
	private String reply_pwd;
	private Date postdate;
	private String content;
	private int reply_step;
	private int reply_order;
    
	public BdreplyVO(int reply_no, int board_no, int member_no, String writer, String reply_pwd, Date postdate,
			String content, int reply_step, int reply_order) {
		this.reply_no = reply_no;
		this.board_no = board_no;
		this.member_no = member_no;
		this.writer = writer;
		this.reply_pwd = reply_pwd;
		this.postdate = postdate;
		this.content = content;
		this.reply_step = reply_step;
		this.reply_order = reply_order;
	}

	public int getReply_no() {
		return reply_no;
	}

	public void setReply_no(int reply_no) {
		this.reply_no = reply_no;
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

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getReply_pwd() {
		return reply_pwd;
	}

	public void setReply_pwd(String reply_pwd) {
		this.reply_pwd = reply_pwd;
	}

	public Date getPostdate() {
		return postdate;
	}

	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReply_step() {
		return reply_step;
	}

	public void setReply_step(int reply_step) {
		this.reply_step = reply_step;
	}

	public int getReply_order() {
		return reply_order;
	}

	public void setReply_order(int reply_order) {
		this.reply_order = reply_order;
	}

	@Override
	public String toString() {
		return "BdreplyVO [reply_no=" + reply_no + ", board_no=" + board_no + ", member_no=" + member_no + ", writer="
				+ writer + ", reply_pwd=" + reply_pwd + ", postdate=" + postdate + ", content=" + content
				+ ", reply_step=" + reply_step + ", reply_order=" + reply_order + "]";
	}
}
