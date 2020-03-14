/**
 * 
 */
package oauth2twitter;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map.Entry;
import java.util.Scanner;

import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonParser;
import com.google.api.client.json.JsonToken;
import com.google.api.client.json.jackson2.JacksonFactory;

/**
 * @author es
 *
 */
public class Oauth2Main {

	 public static HttpResponse myGetHttpResponse(String url) throws IOException {
		HttpTransport transport = new NetHttpTransport();
		GenericUrl genericUrl = new GenericUrl(url);
		Credential credential = new Credential(
				BearerToken.authorizationHeaderAccessMethod())
				.setAccessToken(accessToken);
	    HttpRequestFactory requestFactory = transport.createRequestFactory(credential);
	    return requestFactory.buildGetRequest(genericUrl).execute();
	 }
	 
	 public static void myPrintHeaders(PrintStream out, HttpResponse httpResponse) {
		HttpHeaders headers = httpResponse.getHeaders();
		for (Entry<String, Object> entry : headers.entrySet()) {
		    out.println(entry.getKey() + "/" + entry.getValue());
		}
	 }
	 
	@SuppressWarnings("resource")
	public static void myPrintContent(PrintStream out, HttpResponse httpResponse) {
		InputStream inputStream = null;
		Scanner s = null;
		try {
			inputStream = httpResponse.getContent();
			s = new Scanner(inputStream).useDelimiter("\\A");
			String result = s.hasNext() ? s.next() : "";
			out.println(result);
 			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 
	public static void myPrintJson(PrintStream out, HttpResponse httpResponse) {
		
		String parsedName = "";
		String parsedDescription = "";

		JsonFactory jsonFactory = new JacksonFactory();
		InputStream output;
		
		try {
			output = httpResponse.getContent();
			JsonParser jParser = jsonFactory.createJsonParser(output);
			
			while (jParser.nextToken() != JsonToken.END_OBJECT) {

				String fieldname = jParser.getCurrentName();
				
			    if ("name".equals(fieldname)) {
			        jParser.nextToken();
			        parsedName = jParser.getText();
			    }
			 
			    if ("description".equals(fieldname)) {
			        jParser.nextToken();
			        parsedDescription = jParser.getText();
			    }
			 
			    /*
			    if ("address".equals(fieldname)) {
			        jParser.nextToken();
			        while (jParser.nextToken() != JsonToken.END_ARRAY) {
			            addresses.add(jParser.getText());
			        }
			    }
			    */
				out.println("NAME=" + parsedName);
				out.println("DESC=" + parsedDescription);
				out.println("---------------------");
			}
			
			jParser.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	 
	
	/**
	 * curl -u RLSrphihyR4G2UxvA0XBkLAdl:FTz2KcP1y3pcLw0XXMX5Jy3GTobqUweITIFy4QefullmpPnKm4 --data grant_type=client_credentials https://api.twitter.com/oauth2/token
	 * 
	 */
	final static String consumerKey    = "RLSrphihyR4G2UxvA0XBkLAdl";
	final static String consumerSecret = "FTz2KcP1y3pcLw0XXMX5Jy3GTobqUweITIFy4QefullmpPnKm4";
	final static String accessToken    = "AAAAAAAAAAAAAAAAAAAAACWxtwAAAAAAiMrV%2Ft%2Bx0Nl%2Fc6FNau1F6nB8h0E%3DfnqD07isWAYpBIgfaMCzXvnCel5yexZOQdSyK5cVDxi8EnGk5h";
	 
	public Oauth2Main() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws TwitterAuthenticationException 
	 * @throws IOException 
	 */
	public static void Oauth2Demo() throws IOException {
		// TODO Auto-generated method stub
		
		// final File file = new File("mytest.txt");
		final PrintStream out = new PrintStream(System.out);
			     
		String url = "https://api.twitter.com/1.1/lists/list.json?screen_name=twitterdev";

		HttpResponse httpResponse  = myGetHttpResponse(url);
		HttpResponse httpResponse2 = myGetHttpResponse(url);

		myPrintHeaders(out, httpResponse);
		myPrintJson(out, httpResponse);
		myPrintContent(out, httpResponse2);
	}

}
