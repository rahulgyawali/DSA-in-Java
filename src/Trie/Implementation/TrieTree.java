package Trie.Implementation;

import Trie.Helper.TrieNode;

import java.util.Map;

public class TrieTree {
    public TrieNode root;
    public TrieTree(){
        root = new TrieNode();
    }

    public TrieNode insert(String s){
        TrieNode current = root;
        for(int i = 0; i < s.length(); i++){
            TrieNode node = new TrieNode();
            current.children.put(s.charAt(i),node);
            current = current.children.get(s.charAt(i));
        }
        current.isEnd=true;
        return  root;
    }

    public void print(){

        TrieNode current = root;
        while(!current.isEnd){
            for(Map.Entry<Character,TrieNode> entry:current.children.entrySet()){
                System.out.print(entry.getKey()+" - ");
                current = current.children.get(entry.getKey());
            }
        }
        System.out.println("\b\b");
    }
    public  static void main(String args[]){
        TrieTree trieTree = new TrieTree();
        trieTree.root = trieTree.insert("Hello");
        trieTree.print();
    }
}
