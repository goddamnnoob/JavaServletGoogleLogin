import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.MemoryDataStoreFactory;

public class NewAuth {

	
	public static GoogleAuthorizationCodeFlow newFlow() throws IOException {

		List<String> scopes = Arrays.asList(
		  "https://www.googleapis.com/auth/userinfo.email");
		String oauthClientId = "################";
		String oauthClientSecret = "##############";

		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
		    new NetHttpTransport(),
		    JacksonFactory.getDefaultInstance(),
		    oauthClientId,
		    oauthClientSecret,
		    scopes)
		  .setDataStoreFactory(MemoryDataStoreFactory.getDefaultInstance())
		  .build();
		return flow;
	}
}
