package WordFrequency;

import Trees.BSTInterface;
import Trees.BinarySearchTree;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.StringTokenizer;

public class FrequenyList {
    private static Frame outputDisplay;

    public  static void main(String[] args) throws IOException, FileNotFoundException{
        String inLine = null;
        String word;

        WordFreq wordToTry;
        WordFreq wordInTree;
        WordFreq wordFromTree;
        BinarySearchTree tree = new BinarySearchTree();
        StringTokenizer tokenizer;

        int numWords = 0;
        int numValidWords = 0;
        int numValidFreqs = 0;
        int treeSize;

        String dataFileName = args[0];
        String outFileName = args[1];
        File file=new File(args[0]);
        System.out.println(file.exists());

        BufferedReader dataFile = new BufferedReader(new FileReader(dataFileName));
        PrintWriter outFile = new PrintWriter(new FileWriter(outFileName));

        int minSize = Integer.parseInt(args[2]);
        int minFreq = Integer.parseInt(args[3]);

        inLine = dataFile.readLine();
        while (inLine != null){
            tokenizer = new StringTokenizer(inLine, " \t\n\r\\\"![at]#$%&*()_-+={}[]:;'<,>.?/");
            while (tokenizer.hasMoreTokens()){
                word = tokenizer.nextToken();
                numWords++;
                if (word.length() >= minSize){
                    numValidWords++;
                    word = word.toLowerCase();
                    wordToTry = new WordFreq(word);

                    wordInTree = (WordFreq)tree.find(wordToTry);
                    if (wordInTree == null){
                        wordToTry.inc();
                        tree.insert(wordToTry);;
                    } else{
                        wordInTree.inc();
                    }
                }
            }
            inLine = dataFile.readLine();
        }
        treeSize = tree.reset(BSTInterface.INORDER);
        outFile.println("The words of length " + minSize + " and above,");;
        outFile.println("with frequency counts of " + minFreq + " and above:");
        outFile.println();
        outFile.println("Freq Word");
        outFile.println("--- -------");
        tree = tree.balance();
        for (int count = 1; count <= treeSize; count++) {
            wordFromTree = (WordFreq) tree.getNextItem((BinarySearchTree.INORDER));
            System.out.println(wordFromTree.wordIs());
            if (wordFromTree.freqIs() > minFreq){
                numValidFreqs++;
                outFile.println(wordFromTree);
            }
        }

        dataFile.close();
        outFile.close();

        JFrame outputFrame = new JFrame();
        outputFrame.setTitle("Frequency List Generator");
        outputFrame.setSize(400, 100);
        outputFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = outputFrame.getContentPane();
        JPanel infoPanel = new JPanel();

        infoPanel.setLayout(new GridLayout(4,1));

        infoPanel.add(new JLabel(numWords + " words in the input file.    "));
        infoPanel.add(new JLabel(numValidWords + " of them are at least " + minSize + " characters."));
        infoPanel.add(new JLabel(numValidFreqs + " of these occur at least " + minFreq + " times."));

        contentPane.add(infoPanel);

        outputFrame.show();
    }
}
