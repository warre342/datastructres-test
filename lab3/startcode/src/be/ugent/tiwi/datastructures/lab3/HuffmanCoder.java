package be.ugent.tiwi.datastructures.lab3;

import java.util.*;

/**
 * This class builds a HuffmanTree in the constructor based on the provided text.
 * It can then use this tree to encode or decode arbitrary text.
 * @author sleroux
 */
public class HuffmanCoder {

    private final BinaryTree tree;

    public HuffmanCoder(String text) {
        // ToDo build a HuffmanTree based on the text and store it as "tree"
        Map<Character, Integer> mapje = getFrequencies(text);
        this.tree=buildTree(mapje);


    }

    // ToDo: add additional methods if needed
    private Map<Character, Integer> getFrequencies(String tekst){
        Map<Character, Integer> mapje= new HashMap<>();
        for(char a : tekst.toCharArray()){
            mapje.put(a, mapje.getOrDefault(a, 0)+1);
        }
        return mapje;
    }
    private BinaryTree buildTree(Map<Character, Integer> frequencies){
        Map<Character, Integer> map2 = frequencies;
        Queue<BinaryTree> trees= new PriorityQueue<>(new Comparator<BinaryTree>() {
            @Override
            public int compare(BinaryTree o1, BinaryTree o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        });

        for(char c: map2.keySet()){//map omzetten naar binary trees queue
            BinaryTree boompje = new BinaryTree(String.valueOf(c), map2.get(c));
            trees.add(boompje);
        }
        while(trees.size()>1){
            BinaryTree boom1 =trees.poll();
            BinaryTree boom2 =trees.poll();

            BinaryTree groteBoom= new BinaryTree(boom1, boom2);
            trees.add(groteBoom);

        }
        return trees.poll();
    }


    /**
     * Encode a text by replacing each character with its Huffman code
     *
     * @param text The text to encode
     * @return A String containing the binary representations of each character
     * separated by spaces
     */
    public String encode(String text) {
        // ToDo use the Huffman tree to encode the text
        StringBuilder code = new StringBuilder();
        for(char c : text.toCharArray()){
            BinaryTree tree= this.getTree();
            while(!tree.isLeaf()){
                if(tree.getLeft().getCharacter().indexOf(c)>0){
                    tree=tree.getLeft();
                    code.append("0");
                }
                else{
                    tree=tree.getRight();
                    code.append("2");
                }
            }
            code.append(" ");
        }
        return code.toString();
    }

    /**
     * Decode a text by replacing each Huffman code with its corresponding
     * character
     *
     * @param code A String containing the binary representations of each
     * character separated by spaces
     * @return The decoded text
     */
    public String decode(String code) {
        // ToDo use the Huffmantree to decode the code
        StringBuilder text = new StringBuilder();
        for(char c : code.toCharArray()){

        }

        return null;
    }

    public BinaryTree getTree() {
        return tree;
    }

}
