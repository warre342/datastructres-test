package be.ugent.tiwi.datastructures.lab1;

import java.util.Random;

public class SkipList implements SortedList{

    private int size;

    //start array
    private Node[] levels;
    private static final Random rnd = new Random();


    class Node{
        private int key;
        private Node[] pointers;

    }
    public SkipList(int levels){
        this.levels= new Node[levels]; size=0;
    }

    @Override
    public void insert(int key) {
        Node n = new Node();
        n.key=key;

        int nlevels= 1;
        while(nlevels < levels.length && rnd.nextBoolean()){
            nlevels++;
        }

        n.pointers=new Node[nlevels];
        Node[] pointers= levels;
        int level=pointers.length -1;
        //alle verschillende levels afgaan
        while(level >=0){
            Node m= pointers[level];
            if(m == null || m.key>n.key){
                if(level< nlevels){
                    Node temp= pointers[level];
                    pointers[level]=n;
                    n.pointers[level]=temp;
                }
                level--;
            }
            else {//we zijn ng voor de juiste plek dus 1 opschuiven
                pointers = m.pointers;
            }
        }
        size++;
    }

    @Override
    public boolean contains(int key) {
        Node[] pointers= levels;
        int level=pointers.length -1;
        Node m=null;
        while(level >=0){
            m= pointers[level];
            if(m == null || m.key>=key){
                level--;
            }
            else {//we zijn ng voor de juiste plek dus 1 opschuiven
                pointers = m.pointers;
            }
        }
        return (m !=null) && (m.key==key);
    }

    @Override
    public void remove(int key) {
        Node[] pointers= levels;
        int level=pointers.length -1;
        Node m=null;
        while(level >=0){
            m= pointers[level];
            if(m == null || m.key>key){
                level--;
            }
            else if(m.key==key){
                pointers[level]=m.pointers[level];
                if(level==0){
                    size--;
                }

            }
            else {//we zijn ng voor de juiste plek dus 1 opschuiven
                pointers = m.pointers;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[size];
        Node start= levels[0];
        int teller=0;
        while(start.pointers[0]!=null){
            array[teller]=start.key;
            teller++;
            start=start.pointers[0];
        }
        return array;

    }

    @Override
    public void clear() {

    }

    @Override
    public void print() {

    }
}
