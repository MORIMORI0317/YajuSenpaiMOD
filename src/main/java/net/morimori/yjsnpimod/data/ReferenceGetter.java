package net.morimori.yjsnpimod.data;

import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.TranslationTextComponent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReferenceGetter {
    protected static Map<String, String> urlb = new HashMap<String, String>();

    public static TranslationTextComponent getReference(String url) {
        String i = getTitle(url);
        if (i.equals("fal")) {
            i = I18n.format("lodingful.desc");
        } else if (i.equals("lod")) {
            i = I18n.format("loding.desc");
        }
        return new TranslationTextComponent("urlsource.desc", i);
    }

    private static String getTitle(String url) {

        if (urlb.containsKey(url)) {
            return urlb.get(url);
        }

        URLLoadThread ull = new URLLoadThread(url);
        ull.start();

        urlb.put(url, "lod");
        return "lod";
    }

    private static class URLLoadThread extends Thread {
        private final String url;

        protected URLLoadThread(String url) {
            this.url = url;
        }

        public void run() {
            try {
                URLConnection connection = new URL(url).openConnection();
                InputStreamReader isr = new InputStreamReader(connection.getInputStream(), "UTF-8");
                BufferedReader br = new BufferedReader(isr);
                ArrayList<String> lineList = new ArrayList<String>();
                String line = null;
                while ((line = br.readLine()) != null) {
                    lineList.add(line);
                }
                String lists = "" + lineList;
                ReferenceGetter.urlb.put(url, lists.substring(lists.indexOf("<title>") + 7, lists.indexOf("</title>")));
            } catch (Exception e) {
                ReferenceGetter.urlb.put(url, "fal");
            }
        }
    }

}
