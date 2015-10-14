import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;


/**
 * Created by earlbozarth on 10/14/15.
 */
public class Serializer {

    static Movie movie;

    public static void main(String[] args) {


        movie = loadMovie();


        if(movie == null) {
            movie = new Movie();
            movie.askQuestions();
            //System.out.println(movie);
        }//Enf of if Movie object is Null statement
        else if(movie != null){
            System.out.println(String.format("Title: %s \nDirector: %s \nYear: %d \nOscars: %d \nCountry: %s", movie.title,
                    movie.director, movie.year, movie.numOscars, movie.country));
            System.out.println("Please udpate movie information");
            movie.askQuestions();
        }


        saveMovie();
    }//End of main method

    static void saveMovie(){
        File f = new File("save.json");
        JsonSerializer serializer = new JsonSerializer();
        String contentToSave = serializer.serialize(movie);

        try {
            FileWriter fw = new FileWriter(f);
            fw.write(contentToSave);
            fw.close();
        }//End of Try
        catch (Exception e){
            System.out.println("Here is a friendly Save Error");
        }//End of Catch
    }//End of Save Movie Method

    static Movie loadMovie(){

        try {
            File f = new File("save.json");
            FileReader fr = new FileReader(f);
            int fileSize = (int)f.length();
            char [] contents = new char[fileSize];
            fr.read(contents);
            String fileContents = new String(contents);
            JsonParser parser = new JsonParser();
            return parser.parse(fileContents, Movie.class);
        }//End of Try
        catch (Exception e){
            System.out.println("Here is a friendly Load Error");
            return null;
        }//End of Catch

    }//End of Load Movie method



}//End of Serializer Class
