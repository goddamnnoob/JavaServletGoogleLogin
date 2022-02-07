import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.auth.oauth2.AuthorizationCodeResponseUrl;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeCallbackServlet;
import com.google.api.client.http.GenericUrl;

import jakarta.servlet.annotation.WebServlet;

@javax.servlet.annotation.WebServlet("/login-callback")
public class CallBack extends AbstractAuthorizationCodeCallbackServlet {

  @Override
  protected AuthorizationCodeFlow initializeFlow() throws IOException {
		return NewAuth.newFlow();
  }

  @Override
  protected String getRedirectUri(HttpServletRequest request) {
	  GenericUrl url = new GenericUrl("http://127.0.0.1:8080/GoogleAuth/login-callback");
	    return url.build();
  }

  @Override
  protected String getUserId(HttpServletRequest request) {
    return request.getSession().getId();
  }

  @Override
  protected void onSuccess(HttpServletRequest request, HttpServletResponse response, Credential credential)
      throws IOException {
    response.sendRedirect("welcome");
  }

  @Override
  protected void onError(
      HttpServletRequest request, HttpServletResponse response, AuthorizationCodeResponseUrl errorResponse)
      throws IOException {
    response.getWriter().print("Login cancelled.");
  }
}