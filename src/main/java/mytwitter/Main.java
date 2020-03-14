package mytwitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import authtwitter.TwitterAuthenticationException;
import authtwitter.TwitterAuthenticator;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import mytwitter.model.MyTwitterObj;
import oauth2twitter.Oauth2Main;

public class Main {

	final private static String consumerKey    = "RLSrphihyR4G2UxvA0XBkLAdl";
	final private static String consumerSecret = "FTz2KcP1y3pcLw0XXMX5Jy3GTobqUweITIFy4QefullmpPnKm4";

	// Filter messages that track on "Bieber"
	//
	final private static String filter_track = "Bieber";
	final private static String url = "https://stream.twitter.com/1.1/statuses/filter.json?track=" + filter_track;

	final private static int max = 100; // max message to receive
	final private static int twitter_time = 30000; // 30 SECs for Interval

	public Main() {
		// TODO Auto-generated constructor stub
	}

	private static HttpResponse myGetHttpResponse(HttpRequestFactory httpRequestFactory, String url) throws IOException {
		GenericUrl genericUrl = new GenericUrl(url);
        return httpRequestFactory.buildGetRequest(genericUrl).execute();
	}
	
	private static List<MyTwitterObj> getTwitterMessagesList(PrintStream printStream, HttpResponse httpResponse) throws IOException {
		
		List<MyTwitterObj> list = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        
        mapper.setDateFormat(new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH));

	    InputStream inputStream = httpResponse.getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        String line = reader.readLine();

        int cnt = 0;
        long startTime = System.currentTimeMillis();

        boolean condition = true;
        
        while (condition) {

            String track = LocalTime.now().getHour()+":"+LocalTime.now().getMinute()+":"+LocalTime.now().getSecond();

        	// Retrieve the incoming messages for 30 seconds or up to 100 messages, 
        	// whichever comes first
        	//
        	condition = line != null &&
        			cnt < max &&
        			(System.currentTimeMillis() - startTime < twitter_time);

        	if(!condition) break;
        	
        	MyTwitterObj myTwitterObj = mapper.readValue(line, MyTwitterObj.class);
        	myTwitterObj.setTrack(track);
        	
            list.add(myTwitterObj);

            line = reader.readLine();
            cnt++;
            
            // Keep track of messages per second statistics 
            // across multiple runs of the application
            //	
            printStream.println(track + "#" + cnt + "#");
        }
        
        return list;
    }
	
	public static void main(String[] args) throws TwitterAuthenticationException, IOException {
		
		System.out.println("java-exercise v. 1.0");
		
		Oauth2Main.Oauth2Demo();
		
		// Check how many arguments were passed in
		//
	    if(args.length == 0)
	    {	    	
	        System.out.println("Proper Usage is: java -jar target/java-exercise-0.0.1-SNAPSHOT.jar <any argument>");
	        System.out.println("If you are in Docker image: java -jar java-exercise.jar <any argument>");
	        System.exit(0);
	    }
		
		// All the above infomation is provided in either SDTOUT or a log file
		//
		PrintStream printStream = System.out;
		
		// You will need to login with Twitter
		//
        TwitterAuthenticator authenticator =
        	new TwitterAuthenticator(printStream, consumerKey, consumerSecret);

        HttpRequestFactory httpRequestFactory = authenticator
        			.getAuthorizedHttpRequestFactory();
        
        List<MyTwitterObj> list = null;
        HttpResponse httpResponse = myGetHttpResponse(httpRequestFactory, url);
        
    	list = getTwitterMessagesList(printStream, httpResponse);
    	
    	printStream.println("Tweets Size: " + list.size());
        
        // The messages per user should also be sorted chronologically, ascending
        //
        Stream<MyTwitterObj> streamSorted = 
        	list.stream()
        		.sorted((twitter1, twitter2) -> 
        				 twitter1.getUser()
        				 .getCreated_at()
        				 .compareTo(twitter2.getUser()
        						 .getCreated_at()));
        
        // Your application should return the messages 
        // grouped by user (users sorted chronologically, ascending)
        //
        @SuppressWarnings("rawtypes")
		Collector collector = Collectors
			.groupingBy(t -> ((MyTwitterObj) t)
					.getUser().getId()); 

        @SuppressWarnings("unchecked")
		Map<String, List<MyTwitterObj>> mapListMyTwitterObj = 
        		(Map<String, List<MyTwitterObj>>) streamSorted
        			.collect(collector);

        Collection<List<MyTwitterObj>> myTwitterObjListList = mapListMyTwitterObj
        		.values();
        
        for (List<MyTwitterObj> myTwitterObjList : myTwitterObjListList)
        	myTwitterObjList.sort((myTwitterObjList_1, myTwitterObjList_2) 
        			-> myTwitterObjList_1
        				.compareTo(myTwitterObjList_2));

		// You are free to choose the output format, 
		// provided that it makes it easy to parse and process by a machine
		//
        for (List<MyTwitterObj> myTwitterObjList : myTwitterObjListList)
            for(MyTwitterObj tweet: myTwitterObjList) 
            	printStream.println(tweet
            			.toString());
	}
}
