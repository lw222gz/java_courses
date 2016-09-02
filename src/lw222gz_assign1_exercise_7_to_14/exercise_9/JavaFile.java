package lw222gz_assign1_exercise_7_to_14.exercise_9;

/**
 * Created by Lucas on 2016-09-02.
 */
public class JavaFile {

    private int rows;
    private String name;

    //creates a new JavaFile object
    public JavaFile(String name, int rows){
        this.rows = rows;
        this.name = name;
    }

    //returns the name of the javafile
    public String getName(){
        return this.name;
    }

    //returns amount of rows in the java file.
    public int getRows(){
        return this.rows;
    }
}
