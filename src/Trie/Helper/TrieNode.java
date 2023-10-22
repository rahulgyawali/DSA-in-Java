package Trie.Helper;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public boolean isEnd;
    public Map<Character,TrieNode> children;
    public TrieNode(){
        children = new HashMap<>();
        isEnd=false;
    }

}
