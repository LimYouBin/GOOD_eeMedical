package gdm.controller;

public class ActionForward {
	private boolean isRedirect; // 결과를 뿌려줄 때 redirect로 전달해주면 true, dispatcher로 전달해주면 false
	private String path; // 결과가 전달 될 페이지의 경로
	
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	@Override
	public String toString() {
		return "ActionForward [isRedirect=" + isRedirect + ", path=" + path + "]";
	}
}