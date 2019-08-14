package gdm.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IActionForward {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException;
}
