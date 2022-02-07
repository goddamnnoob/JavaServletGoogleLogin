import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.servlet.annotation.WebServlet;

@javax.servlet.annotation.WebServlet("/logout")
public class Logout extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    request.getSession().invalidate();
    response.sendRedirect("Login.jsp");
  }
}