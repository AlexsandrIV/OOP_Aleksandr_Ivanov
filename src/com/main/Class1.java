package com.main;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Class1 {
    public static void main(String[] args) throws IOException {
        //Enter number a quote
        System.out.print("Enter number a quote: ");
        System.out.println();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberQuote = Integer.parseInt(reader.readLine());

        //get page
        URL site = new URL("https://bash.im/quote/" + numberQuote);
        URLConnection yc = site.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        StringBuilder page = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            page.append(inputLine);
        }
        in.close();
        System.out.println(parseHTML(page));


        //parse page
        //якорь
    }
    static String parseHTML(StringBuilder page){
        String startString = "</header>    <div class=\"quote__body\">";
        String endString = "<footer class=\"quote__footer\">";
        int startIndex = page.indexOf(startString);
        int endIndex = page.indexOf(endString);
        return page.substring(startIndex + startString.length() + 6, endIndex - 17);
    }

}
