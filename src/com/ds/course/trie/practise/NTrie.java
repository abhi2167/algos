package com.ds.course.trie.practise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NTrie {

    private TrieNode root;

    NTrie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {

        int i = 0;
        TrieNode currentNode = root;
        while( i < word.length()) {
            char ch = word.charAt(i);
            if(!currentNode.children.containsKey(ch)) {
                currentNode.children.put(ch, new TrieNode());
            }
            currentNode = currentNode.children.get(ch);
            i++;
        }
        currentNode.endOfWord = true;
    }

    public boolean search(String word) {
        int i = 0;
        TrieNode currentNode = root;
        while( i < word.length()) {
            char ch = word.charAt(i);
            currentNode = currentNode.children.get(ch);
            if(currentNode == null) {
                return false;
            }
            i++;
        }
        return currentNode.endOfWord;
    }

    public void delete(String word) {
        deleteWord(this.root, 0, word);
    }

    private boolean deleteWord(TrieNode currentNode, int i, String word) {
        char ch = word.charAt(i);
        TrieNode node = currentNode.children.get(ch);
        boolean canThisNodeBeDeleted = false;

        if(node.children.size() > 1) {
            deleteWord(node, i + 1, word);
            return false;
        }

        if( i == word.length() - 1) {
            if(node.children.size() >= 1) {
                node.endOfWord = false;
                return false;
            } else {
                currentNode.children.remove(ch);
                return true;
            }
        }

        if(node.endOfWord == true) {
            deleteWord(node, i + 1, word);
            return false;
        }

        canThisNodeBeDeleted = deleteWord(node, i + 1, word);
        if(canThisNodeBeDeleted == true) {
            currentNode.children.remove(ch);
            return true;
        } else {
            return false;
        }
    }

    private class TrieNode {

        Map<Character, TrieNode> children;

        boolean endOfWord;

        TrieNode() {
            this.children = new HashMap<>();
            endOfWord = false;
        }
    }
}
