import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.oauth2.Oauth2;
import com.google.api.services.oauth2.model.Userinfo;


@WebServlet("/welcome")
public class Welcome extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    response.setContentType("text/html;");

    String sessionId = request.getSession().getId();
    boolean isUserLoggedIn = isUserLoggedInString(sessionId);
    response.setHeader("Cache-Control", "no-chache, no-store, must-revalidate");
    PrintWriter printWriter = response.getWriter();

    if (isUserLoggedIn) {
      Userinfo userInfo = getUserinfo(sessionId);

      printWriter.println("<h1>HI " + userInfo.getEmail() + "</h1>");
      
      
      printWriter.println("<p><a href=\"logout\">Logout</a></p>");
    } else {
      printWriter.println("<a href=\"Login.jsp\">Login with Google</a>");	
    }
  }
  
  boolean isUserLoggedInString (String session) {
	  try{
	      Credential credential = NewAuth.newFlow().loadCredential(session);
		    return credential != null;
	    } catch(IOException e){
	      return false;
	    }
  }
  
  Userinfo getUserinfo(String session) throws IOException {
	  String appName = System.getenv("APP_NAME");
	    Credential credential = NewAuth.newFlow().loadCredential(session);
	    Oauth2 oauth2Client =
	        new Oauth2.Builder(new NetHttpTransport(), JacksonFactory.getDefaultInstance(), credential)
	            .setApplicationName(appName)
	            .build();

	    Userinfo userInfo = oauth2Client.userinfo().get().execute();
	    return userInfo;
  }
}
