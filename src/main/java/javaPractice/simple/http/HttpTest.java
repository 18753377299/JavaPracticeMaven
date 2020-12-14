package javaPractice.simple.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpTest {
	public static void main(String argv[]){
        String urlStr = "http://60.205.166.252/renbaofile/FileProvider/downloadFileByJson?secretuid=433f3dd6-d9eb-11e9-9637-00163e30bfa0&secretkey=YYUTAKPEV6Y4F3P8NQZD3CWF5J&Content-type=application/text";
        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(),"utf-8"));
            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
