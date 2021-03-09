package com.wen.repository.solution0200To0299.design;

/**
 * 208. Implement Trie (Prefix Tree)
 *
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist of lowercase English letters.
 * At most 3 * 10^4 calls will be made to insert, search, and startsWith.
 */
public class Trie {

    private boolean exist;
    private Trie[] sons;

    /** Initialize your data structure here. */
    public Trie() {
        this(false);
    }
    public Trie(boolean exist) {
        this.exist = exist;
        sons = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        insert(word, 0);
    }

    private void insert(String word, int start) {
        if (start >= word.length()) {
            exist = true;
            return;
        }
        int index = word.charAt(start) - 'a';
        if (sons[index] == null) {
            sons[index] = new Trie();
        }
        sons[index].insert(word, start + 1);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return search(word, 0);
    }

    private boolean search(String word, int start) {
        if (start >= word.length()) {
            return exist;
        }
        int index = word.charAt(start) - 'a';
        if (sons[index] == null) {
            return false;
        }
        return sons[index].search(word, start + 1);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWith(prefix, 0);
    }

    private boolean startsWith(String prefix, int start) {
        if (start >= prefix.length()) {
            return true;
        }
        int index = prefix.charAt(start) - 'a';
        if (sons[index] == null) {
            return false;
        }
        return sons[index].startsWith(prefix, start + 1);
    }
}
