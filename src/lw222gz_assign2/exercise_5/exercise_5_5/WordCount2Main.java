package lw222gz_assign2.exercise_5.exercise_5_5;

import lw222gz_assign2.exercise_5.exercise_5_2.Word;
import lw222gz_assign2.exercise_5.exercise_5_4.HashWordSet;
import lw222gz_assign2.exercise_5.exercise_5_4.TreeWordSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/**
 * Created by Lucas on 2016-09-21.
 */
public class WordCount2Main {

    public static void main(String[] args){
        try{
            if(args.length == 0){
                throw new IllegalArgumentException("Not a valid path was given as program parameter.");
            }

            System.out.println("Path used: " + args[0]);
            readFile(Paths.get(args[0]));

        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }

    }


    private static void readFile(Path p) throws IOException {
        if(!Files.exists(p) || Files.isDirectory(p)){
            throw new IOException("The file was not found.");
        }

        HashWordSet hashWords = new HashWordSet();
        TreeWordSet treeWords = new TreeWordSet();

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

            //close reader
            reader.close();

            System.out.println("\nHash word set iteration.");
            Iterator<Word> it = hashWords.iterator();

            int counter = 1;
            //Test the iterator in HashWordSet
            while(it.hasNext()){
                System.out.println(counter + ". " + it.next());
                counter++;
            }


            System.out.println("\nTree set iteration.");
            it = treeWords.iterator();

            counter = 1;
            //testing the iterator in TreeWordSet to display the words in alphabetic order
            while(it.hasNext()){
                System.out.println(counter + ". " + it.next());
                counter++;
            }

            //Prints out the sizes, according to the exercise description this should be 350 for both.
            System.out.println("Hash size : " + hashWords.size());
            System.out.println("Tree size : " + treeWords.size());


        }
        catch(Exception e){
            throw new IOException(e.getCause());
        }
    }
}
