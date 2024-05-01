package com.ds.leetcode.Strings;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordBreak {

    public static void main(String[] args) {
        WordBreak w = new WordBreak();
        String s = "catsanddog";
        List<String> wordDict = Stream.of("cats","dog","and","cat").collect(Collectors.toList());
        System.out.println(" Word break top down result == " + w.wordBreak(s, wordDict));
        System.out.println(" Word break result bu == " + w.wordBreak_bu(s, wordDict));
        System.out.println(" Word break result trie == " + w.wordBreak_trie(s, wordDict));
        System.out.println(" Word break result bfs == " + w.wordBreak_bfs(s, wordDict));
    }

    private boolean wordBreak_bfs(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] seen = new boolean[s.length()+1];
        while(!queue.isEmpty()) {
            int start = queue.poll();
            if(start == s.length()) {
                return  true;
            }
            for(int end = start + 1; end <= s.length(); end++) {
                if(seen[end]) {
                    continue;
                }
                String subStr = s.substring(start, end);
                if(dict.contains(subStr)) {
                    queue.add(end);
                    seen[end] = true;
                }
            }

        }
        return false;
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    public boolean wordBreak_trie(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        for(String word : wordDict) {
            TrieNode currentNode = root;
            for(int i=0; i < word.length(); i++) {
                currentNode = currentNode.children.computeIfAbsent(word.charAt(i), ch -> new TrieNode());
            }
            currentNode.endOfWord = true;
        }
        boolean[] dp = new boolean[s.length()];
        for(int i=0; i < s.length(); i++) {
            if(i == 0 || dp[i-1]) {
                TrieNode currentNode = root;
                for(int j=i; j < s.length(); j++) {
                    if(!currentNode.children.containsKey(s.charAt(j))) {
                        break;
                    }
                    currentNode = currentNode.children.get(s.charAt(j));
                    if(currentNode.endOfWord) {
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[s.length()-1];
    }

    public boolean wordBreak_bu(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()];
        for(int i=0; i < s.length(); i++) {
            for(String word: wordDict) {
                if (i >= word.length()-1 && (i == word.length()-1 || dp[i-word.length()])) {
                    if(s.substring(i-word.length()+1, i+1).equals(word)) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[s.length()-1];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> wordSet = new HashSet<>(wordDict);
        Boolean dp[][] = new Boolean[s.length()+1][s.length()+1];

        return  wordBreak(s, wordSet, 0, dp);
    }

    private boolean wordBreak(String s, HashSet<String> wordSet, int currentIndex, Boolean[][] dp) {
        if(currentIndex == s.length()) {
            dp[currentIndex][s.length()] = true;
            return true;
        }
        for(int j=currentIndex+1; j <= s.length(); j++) {
            if(dp[currentIndex][j] != null) {
                return dp[currentIndex][j];
            } else {
                String subStr = s.substring(currentIndex, j);
                if(wordSet.contains(subStr) && wordBreak(s, wordSet, j, dp)) {
                    dp[currentIndex][j] = true;
                    return true;
                }
            }
        }
        for(int j=currentIndex+1; j <= s.length(); j++) {
            dp[currentIndex][j] = false;
        }
        return  false;
    }
}
