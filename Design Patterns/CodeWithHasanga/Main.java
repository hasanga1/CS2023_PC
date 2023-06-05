package CodeWithHasanga;

import Builder.URL;
import Builder.URLBuilder;

public class Main {
    public static void main(String[] arg) {
        URLBuilder urlBuilder = new URLBuilder("https://", "mywebsite");
        urlBuilder.setPathParam("/companies");
        urlBuilder.setQueryParam("?companyName=xyz");

        URL url = new URL(urlBuilder);
        url.print();
    }
}
