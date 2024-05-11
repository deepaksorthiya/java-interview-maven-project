package com.example.corejava;

import java.net.URI;

public class URIExample {
    public static void main(String[] args) {
        URI uri = URI.create("https://mail.google.com/mail/u/0/?p=p&&p2=p2#inbox/FMfcgzGxSRQsjBCGglVxjbtXBtfQbWJJ");

        String host = uri.getHost();
        String path = uri.getPath();
        String query = uri.getQuery();
        String fragment = uri.getFragment();

        System.out.println(host);
        System.out.println(path);
        System.out.println(query);
        System.out.println(fragment);
    }
}
