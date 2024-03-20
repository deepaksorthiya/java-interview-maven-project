package com.example.systemdesign;

import java.util.*;

public class AutocompleteSystem1 {
    private HashMap<String, Integer> count = new HashMap<>();
    private Trie trie = new Trie();
    private String curr = "";

    private static class TrieNode {
        public boolean isLeaf;
        public List<String> cands;
        HashMap<Character, TrieNode> children;

        public TrieNode() {
            isLeaf = false;
            children = new HashMap<>();
            cands = new LinkedList<>();
        }

        @Override
        public String toString() {
            return "{" +
                    "children=" + children+
                    ", isLeaf=" + isLeaf +
                    ", cands=" + cands +
                    '}';
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                HashMap<Character, TrieNode> children = node.children;
                char c = word.charAt(i);
                if (!children.containsKey(c)) {
                    children.put(c, new TrieNode());
                }
                children.get(c).cands.add(word);
                if (i == word.length() - 1) {
                    children.get(c).isLeaf = true;
                }
                node = node.children.get(c);
            }
        }

        private TrieNode searchNode(String pre) {
            HashMap<Character, TrieNode> children = root.children;
            TrieNode node = root;
            for (int i = 0; i < pre.length(); i++) {
                if (!children.containsKey(pre.charAt(i))) {
                    return null;
                }
                node = children.get(pre.charAt(i));
                children = node.children;
            }
            return node;
        }
    }

    public AutocompleteSystem1(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            count.put(sentences[i], times[i]);
            trie.insert(sentences[i]);
        }
    }

    public List<String> input(char c) {
        List<String> res = new LinkedList<String>();
        if (c == '#') {
            if (!count.containsKey(curr)) {
                trie.insert(curr);
                count.put(curr, 1);
            } else {
                count.put(curr, count.get(curr) + 1);
            }
            curr = "";
        } else {
            curr += c;
            res = getSuggestions();
        }

        return res;
    }

    private List<String> getSuggestions() {
        List<String> res = new LinkedList<String>();
        TrieNode node = trie.searchNode(curr);
        if (node == null) {
            return res;
        }
        List<String> cands = node.cands;
        Collections.sort(cands, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (count.get(s1) != count.get(s2)) {
                    return count.get(s2) - count.get(s1);
                }
                return s1.compareTo(s2);
            }
        });
        int added = 0;
        for (String s : cands) {
            res.add(s);
            added++;
            if (added > 2) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        String sentences[] = {"i love you", "island", "ironman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        AutocompleteSystem1 obj = new AutocompleteSystem1(sentences, times);
        List<String> param_1 = obj.input('i');
        System.out.println(param_1);
    }

}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */