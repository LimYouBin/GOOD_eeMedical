package gdm.dto;

import java.util.Arrays;

public class BdreplyVOJson {
	private int totalCnt; // 전체 댓글 수
	private BdreplyVO[] replys; // 현재 글의 댓글 (json)
	
	public BdreplyVOJson(int totalCnt, BdreplyVO[] replys) {
		this.totalCnt = totalCnt;
		this.replys = replys;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public BdreplyVO[] getReplys() {
		return replys;
	}

	public void setReplys(BdreplyVO[] replys) {
		this.replys = replys;
	}

	@Override
	public String toString() {
		return "BdreplyVOJson [totalCnt=" + totalCnt + ", replys=" + Arrays.toString(replys) + "]";
	}
}
