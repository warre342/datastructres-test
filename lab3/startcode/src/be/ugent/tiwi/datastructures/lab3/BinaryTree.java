package be.ugent.tiwi.datastructures.lab3;

/**
 *
 * @author sleroux
 */
public class BinaryTree {

    private BinaryTree left;
    private BinaryTree right;
    private String character;
    private int weight;

    public BinaryTree(String character, int weight) {
        this.character = character;
        this.weight = weight;
    }

    public BinaryTree(BinaryTree left, BinaryTree right) {
        this(left.character + right.character, left.weight + right.weight);
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return (left == null) && (right == null);
    }

    public BinaryTree getLeft() {
        return left;
    }

    public void setLeft(BinaryTree left) {
        this.left = left;
    }

    public BinaryTree getRight() {
        return right;
    }

    public void setRight(BinaryTree right) {
        this.right = right;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }



}
