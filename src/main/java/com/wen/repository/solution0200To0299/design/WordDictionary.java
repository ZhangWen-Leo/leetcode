package com.wen.repository.solution0200To0299.design;

/**
 * 211. Design Add and Search Words Data Structure
 *
 * 1 <= word.length <= 500
 * word in addWord consists lower-case English letters.
 * word in search consist of '.' or lower-case English letters.
 * At most 50000 calls will be made to addWord and search.
 */
public class WordDictionary {

    private boolean exist;
    private WordDictionary[] sons;

    /** Initialize your data structure here. */
    public WordDictionary() {
        this(false);
    }
    public WordDictionary(boolean exist) {
        this.exist = exist;
        sons = new WordDictionary[26];
    }

    public void addWord(String word) {
        int len = word.length();
        WordDictionary cur = this;

        for (int i = 0; i < len; i++) {
            int index = word.charAt(i) - 'a';
            if (cur.sons[index] == null) {
                cur.sons[index] = new WordDictionary();
            }
            cur = cur.sons[index];
        }
        cur.exist = true;
    }

    public boolean search(String word) {
        return search(word, 0);
    }

    private boolean search(String word, int start) {
        int len = word.length();
        if (start >= len) {
            return exist;
        }

        if (word.charAt(start) == '.') {
            for (int index = 0; index < 26; index++) {
                if (sons[index] != null && sons[index].search(word, start + 1)) {
                    return true;
                }
            }
            return false;
        }
        else {
            int index = word.charAt(start) - 'a';
            if (sons[index] == null) {
                return false;
            }
            return sons[index].search(word, start + 1);
        }
    }
}
