package com.example.trieds;

import java.util.*;


public class Trie {

    // root node
    private TrieNode root = new TrieNode();

    public static void main(String[] args) {
        Trie trie = new Trie();
        String[] words = {"apple", "app", "application", "bat", "batman", "batmobile"};

        // Insert words into the trie
        for (String word : words) {
            trie.insert(word);
        }

        // Search for words
        System.out.println(trie.search("app"));  // true
        System.out.println(trie.search("bat"));  // true
        System.out.println(trie.search("batman"));  // true
        System.out.println(trie.search("batmobile"));  // true
        System.out.println(trie.search("banana"));  // false

        // Get words with prefix
        List<Map.Entry<String, Integer>> prefixResults = trie.getWordsWithPrefix("app");
        System.out.println("Words with prefix 'app':");
        for (Map.Entry<String, Integer> entry : prefixResults) {
            System.out.println(entry.getKey() + " (Frequency: " + entry.getValue() + ")");
        }

        // Get popular words
        List<Map.Entry<String, Integer>> popularResults = trie.getPopularWords(3);
        System.out.println("Top 3 popular words:");
        for (Map.Entry<String, Integer> entry : popularResults) {
            System.out.println(entry.getKey() + " (Frequency: " + entry.getValue() + ")");
        }
    }

    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
        int frequency = 0; // Track the frequency of words
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEndOfWord = true;
        node.frequency++;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return false;
            }
            node = node.children.get(ch);
        }
        return node.isEndOfWord;
    }

    // Helper method to collect words with a given prefix
    private void collectWords(TrieNode node, String prefix, List<Map.Entry<String, Integer>> results) {
        if (node.isEndOfWord) {
            results.add(new AbstractMap.SimpleEntry<>(prefix, node.frequency));
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            collectWords(entry.getValue(), prefix + entry.getKey(), results);
        }
    }

    // Get all words with a given prefix in sorted order
    public List<Map.Entry<String, Integer>> getWordsWithPrefix(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return new ArrayList<>();
            }
            node = node.children.get(ch);
        }

        List<Map.Entry<String, Integer>> results = new ArrayList<>();
        collectWords(node, prefix, results);
        results.sort(Comparator.comparing(Map.Entry::getKey)); // Sort by lexicographical order
        return results;
    }

    // Get top N popular words
    public List<Map.Entry<String, Integer>> getPopularWords(int topN) {
        List<Map.Entry<String, Integer>> results = new ArrayList<>();
        collectWords(root, "", results);
        results.sort((a, b) -> {
            int freqComp = Integer.compare(b.getValue(), a.getValue()); // Sort by frequency descending
            return freqComp != 0 ? freqComp : a.getKey().compareTo(b.getKey()); // Sort by lexicographical order
        });
        return results.size() > topN ? results.subList(0, topN) : results;
    }
}

