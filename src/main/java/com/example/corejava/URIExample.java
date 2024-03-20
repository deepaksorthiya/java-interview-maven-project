package com.example.corejava;

import java.net.URI;

public class URIExample {
    public static void main(String[] args) {
        URI uri = URI.create("https://mail.google.com/mail/u/0/#inbox/FMfcgzGxSRQsjBCGglVxjbtXBtfQbWJJ");
        String query = uri.getQuery();
        String fragment = uri.getFragment();
        System.out.println(query);
        System.out.println(fragment);
    }
}
