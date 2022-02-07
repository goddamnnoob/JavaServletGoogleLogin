import java.io.IOException;

import javax.servlet.annotation.WebServlet;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeServlet;
import com.google.api.client.http.GenericUrl;


@WebServlet("/login")
public class Login extends AbstractAuthorizationCodeServlet{

	
	@Override
	protected AuthorizationCodeFlow initializeFlow() throws IOException {
		return NewAuth.newFlow();
	}

	@Override
	protected String getRedirectUri(javax.servlet.http.HttpServletRequest req)
			throws javax.servlet.ServletException, IOException {
		GenericUrl url = new GenericUrl("http://127.0.0.1:8080/GoogleAuth/login-callback");
	    return url.build();
	}


	@Override
	protected String getUserId(javax.servlet.http.HttpServletRequest req)
			throws javax.servlet.ServletException, IOException {
		return req.getSession().getId();
	}
	
}
