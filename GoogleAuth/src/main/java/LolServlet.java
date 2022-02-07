import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;


public class LolServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.getWriter().println("LLLLLLLLLLOOOOOOOOOOOOLLLLLLLLLLLLLL");
	}
}
