package com.main;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class Class1 {
    public static void main(String[] args) throws IOException {
        //Enter number a quote
        System.out.print("Enter number a quote: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberQuote = Integer.parseInt(reader.readLine());

        //get page
        URL site = new URL("https://bash.im/quote/" + numberQuote);
        URLConnection yc = site.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        Page page = new Page();
        while ((inputLine = in.readLine()) != null) {
            page.getPage().append(inputLine);
        }
        in.close();

        System.out.println(page.getPage());
        page.parseHTML();
        System.out.println(page.getPage());
        page.filterDecode();
        System.out.println(page.getPage());

        //parse page
        //якорь
    }


}
