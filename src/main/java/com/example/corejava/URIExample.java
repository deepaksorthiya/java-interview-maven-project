package com.example.corejava;

import java.net.URI;

public class URIExample {
    public static void main(String[] args) {
        URI uri = URI.create("https://mail.google.com/mail/u/0/?p=p&&p2=p2#inbox/FMfcgzGxSRQsjBCGglVxjbtXBtfQbWJJ");

        String host = uri.getHost();
        String path = uri.getPath();
        String query = uri.getQuery();
        String fragment = uri.getFragment();

        System.out.println("Host: " + host);
        System.out.println("Path: " + path);
        System.out.println("Query: " + query);
        System.out.println("Fragment: " + fragment);
    }
}
/**
 * OUTPUT ::
 * Host: mail.google.com
 * Path: /mail/u/0/
 * Query: p=p&&p2=p2
 * Fragment: inbox/FMfcgzGxSRQsjBCGglVxjbtXBtfQbWJJ
 */
