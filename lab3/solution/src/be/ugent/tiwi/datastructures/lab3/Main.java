package be.ugent.tiwi.datastructures.lab3;


/**
 *
 * @author sleroux
 */
public class Main {
    public static void main(String[] args) {
        String text = "Test Test Test";
        //text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbccccccccccccccccccccddddd";
        System.out.println(text);

        char[] characters = text.toCharArray();        

        
        for (char i: characters){
           System.out.print(Integer.toBinaryString(i)+" ");       
        }
        System.out.println("");
        
        System.out.println("Ascii encoding requires "+text.length()*8+" bits");
        
        HuffmanCoder coder = new HuffmanCoder(text);
        BinaryTree tree = coder.getTree();
        System.out.println(tree);
        
        //String code = coder.encode(text);
        String code = "10101 10110 111 10000 0111 0110 0110 000 111 10001 0100 111 001 10100 111 110 0111 000 10010 110 000 10011 111 0101 001 110 111 0101 001 110 10111 0100 110";
        System.out.println(code);
        
        int bits = 0;
        for (char cc: code.toCharArray()){
            if (cc == '0' || cc =='1'){
                bits++;
            }
        }
        System.out.println("");
        System.out.println("Huffman encoding requires "+bits+" bits");
        
        String decoded = coder.decode(code);
        System.out.println("Decoded: "+decoded);
        
    }
}
