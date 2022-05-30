import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.Scanner;

public class MorseCodeTree extends BinaryTree<Character> implements Serializable {

    //Fields
    BinaryTree tree;
    Scanner inputFile;
    File buildTree = new File("C:\\Users\\chris\\IdeaProjects\\MorseCodeTrees\\src\\buildTree.txt");

    MorseCodeTree() {
        buildMorseTree();
    }

    MorseCodeTree(String morseCode) {
        buildMorseTree();
        System.out.println(translateFromMorseCode(morseCode) + "\n");
    }

    public String translateFromMorseCode(String morseCode) {
        return String.valueOf(readMorseCodeTree(morseCode));
    }

    public char readMorseCodeTree(String morseCode) {
        Node tmpNode = tree.root;
        for (int i = 0; i < morseCode.length(); i++) {
            if (morseCode.substring(i, i + 1).contains("*")) {
                tmpNode = tmpNode.left;
            } else if (morseCode.substring(0, 1).contains("-")) {
                tmpNode = tmpNode.right;
            } else
                tmpNode.data = null;
        }
        return (char) tmpNode.data;
    }

    private void buildMorseTree() {
        tree = new BinaryTree(new Node(null));

        try {
            inputFile = new Scanner(new FileReader(buildTree));

            String tmp, letter, morse;
            Node<Character> currentNode;
            while (inputFile.hasNextLine()) {
                tmp = inputFile.nextLine();
                letter = tmp.substring(0, 1);
                morse = tmp.substring(1);
                currentNode = tree.root;

                while (morse.length() > 0) {
                    if (morse.startsWith("*"))
                        currentNode = tree.root.left;
                    else if (morse.startsWith("-"))
                        currentNode = tree.root.right;
                    else {
                        System.err.println("Invalid Morse Code Value");
                        System.exit(0);
                    }
                    morse = morse.substring(1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
