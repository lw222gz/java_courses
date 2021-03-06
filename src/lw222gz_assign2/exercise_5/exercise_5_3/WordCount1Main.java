package lw222gz_assign2.exercise_5.exercise_5_3;

import lw222gz_assign2.exercise_5.exercise_5_2.Word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Lucas on 2016-09-20.
 */
public class WordCount1Main {

    public static void main(String[] args){
        try{
            if(args[0].length() <= 0){
                throw new IllegalArgumentException("Not a valid path was given as program parameter.");
            }

            System.out.println("Path used: " + args[0]);
            readFile(Paths.get(args[0]));

        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }

    }


    private static void readFile(Path p) throws IOException{
        if(!Files.exists(p) || Files.isDirectory(p)){
            throw new IOException("The file was not found.");
        }

        HashSet<Word> hashWords = new HashSet<Word>();
        TreeSet<Word> treeWords = new TreeSet<Word>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(p.toString()));

            String line;

            while ((line = reader.readLine()) != null){
                String[] words = line.split(" ");

                for(String s : words){
                    hashWords.add(new Word(s));
                    treeWords.add(new Word(s));
                }
            }

            reader.close();

            Iterator<Word> it = treeWords.iterator();

            int counter = 1;
            //prints out the words to test the alphabetic order
            while(it.hasNext()){
                System.out.println(counter + ". " + it.next());
                counter++;
            }

            //System.out.println(treeWords);
            //Prints out the sizes, according to the exercise description this should be 350 for both.
            System.out.println("Hash size : " + hashWords.size());
            System.out.println("Tree size : " + treeWords.size());



        }
        catch(Exception e){
            throw new IOException("Something went wrong when reading the file.");
        }
    }
}
