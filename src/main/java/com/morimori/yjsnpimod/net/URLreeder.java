package com.morimori.yjsnpimod.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class URLreeder {

public static String Titelloadint(String url) {


	String kekka;
	try {
		URLConnection connection = new URL(url).openConnection();


		InputStreamReader isr = new InputStreamReader(connection.getInputStream(),"UTF-8");
		BufferedReader br = new BufferedReader(isr);

		ArrayList<String> lineList = new ArrayList<String>();
		String line = null;
        while((line = br.readLine()) != null) {
            lineList.add(line);
        }
        String lists =""+lineList;




        kekka = lists.substring(lists.indexOf("<title>")+7,lists.indexOf("</title>"));;

	} catch (MalformedURLException e) {
		kekka = "lodingful.desc";

	} catch (IOException e) {
		kekka = "lodingful.desc";

	}

	return kekka;



}

}
