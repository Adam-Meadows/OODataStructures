package WordFrequency;

import java.text.DecimalFormat;

public class WordFreq implements Comparable {

    private String word;
    private int freq;

    DecimalFormat fmt = new DecimalFormat("00000");

    public WordFreq(String newWord){
        word = newWord;
        freq = 0;
    }

    public void inc(){
        freq++;
    }

    @Override
    public int compareTo(Object otherWordFreq) {
        WordFreq other = (WordFreq)otherWordFreq;
        return this.word.compareTo(other.word);
    }

    public String toString(){
        return fmt.format(freq) + " " + word;
    }

    public String wordIs(){
        return word;
    }

    public int freqIs(){
        return freq;
    }


}
