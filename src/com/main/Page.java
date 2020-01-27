package com.main;

public class Page {
    private StringBuilder page;

    public Page(StringBuilder page) {
        this.page = page;
    }

    public Page() {
        this.page = new StringBuilder();
    }

    public StringBuilder getPage() {
        return page;
    }

    public void setPage(StringBuilder page) {
        this.page = page;
    }

    public void parseHTML(){
        String startString = "</header>    <div class=\"quote__body\">";
        String endString = "<footer class=\"quote__footer\">";
        int startIndex = page.indexOf(startString);
        int endIndex = page.indexOf(endString);
        page = new StringBuilder(page.substring(startIndex + startString.length(), endIndex - 17));
    }

    public void filterDecode(){
        String p = page.toString();
        p.replaceAll("&lt","<");
        p.replaceAll("&gt",">");
        p.replaceAll("&quot","\"");
        page = new StringBuilder(p);
    }

    @Override
    public String toString() {
        return page.toString();
    }
}
