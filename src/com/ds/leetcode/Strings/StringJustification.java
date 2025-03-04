package com.ds.leetcode.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringJustification {

    public static void main(String[] args) {
        StringJustification s = new StringJustification();
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println("String justification result = " + s.fullJustify(words, maxWidth));
        System.out.println("String justification result = " + s.fullJustify2(words, maxWidth));
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> lines = new ArrayList<>();
        int currentWord = 0;
        while(currentWord < words.length) {
            List<String> wordsInLine = getWords(currentWord, words, maxWidth);
            currentWord += wordsInLine.size();
            String line;
            if(currentWord == words.length) {
                line = wordsInLine.stream().collect(Collectors.joining(" "));
                int diff = maxWidth - line.length();
                while(diff > 0) {
                    line += " ";
                    diff--;
                }
            } else {
                line = justifyLine(wordsInLine, maxWidth);
            }
            System.out.println(line);
            lines.add(line);
        }
        return lines;
    }

    private String justifyLine(List<String> wordsInLine, int maxWidth) {

        int lineLength = wordsInLine.stream().mapToInt(s -> s.length()+1).sum()-1;
        int diff = 0;
        if(lineLength != maxWidth) {
            diff = maxWidth - lineLength;
        }
        for(int i = 0; i < wordsInLine.size()-1 && diff > 0; ) {
            wordsInLine.set(i, wordsInLine.get(i)+" ");
            diff--;
            if(i == wordsInLine.size()-2) {
                i = 0;
            } else {
                i++;
            }
        }
        if(wordsInLine.size() == 1 && diff > 0) {
            while(diff > 0) {
                wordsInLine.set(0, wordsInLine.get(0) + " ");
                diff--;
            }
        }
        return wordsInLine.stream().collect(Collectors.joining(" "));
    }

    private List<String> getWords(int currentWord, String[] words, int maxWidth) {
        List<String> wordsInLine = new ArrayList<>();
        int remainingWidth = maxWidth;
        for(int i = currentWord; i < words.length; i++) {
            if(remainingWidth - words[i].length() >= 0) {
                wordsInLine.add(words[i]);
                remainingWidth -= words[i].length();
                remainingWidth--;
            } else {
                break;
            }
        }
        return wordsInLine;
    }

    public List<String> fullJustify2(String[] words, int maxWidth) {

        List<String> lines = new ArrayList<>();
        int currentWord = 0;
        while(currentWord < words.length) {
            List<String> wordsInLine = getWords(currentWord, words, maxWidth);
            currentWord += wordsInLine.size();
            String line = justifyLine2(wordsInLine, maxWidth, currentWord, words);
            System.out.println(line);
            lines.add(line);
        }
        return lines;
    }

    private String justifyLine2(List<String> wordsInLine, int maxWidth, int currentWord, String[] words) {
        int lineLength = wordsInLine.stream().mapToInt(s -> s.length()+1).sum()-1;
        int extraSpaces = maxWidth - lineLength;
        if(wordsInLine.size() == 1 || currentWord == words.length) {
            return String.join(" ", wordsInLine) + " ".repeat(extraSpaces);
        }
        int wordCount = wordsInLine.size()-1;
        int spaceBetweenWords = extraSpaces / wordCount;
        int extraSpacesOnLeft = extraSpaces % wordCount;
        for(int j = 0; j < extraSpacesOnLeft; j++) {
            wordsInLine.set(j, wordsInLine.get(j) + " ");
        }

        for(int j = 0; j < wordCount; j++) {
            wordsInLine.set(j, wordsInLine.get(j) + " ".repeat(spaceBetweenWords));
        }

        return String.join(" ", wordsInLine);
    }


}
