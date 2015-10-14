import java.util.Scanner;

/**
 * Created by earlbozarth on 10/14/15.
 */
public class Movie {
    String title;
    String director;
    int year;
    int numOscars;
    String country;

    public Movie(){
    }//Defualt Constructor

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public int getYear() {
        return year;
    }

    public int getNumOscars() {
        return numOscars;
    }

    public String getCountry() {
        return country;
    }

    void askQuestions(){
        Scanner qScanner = new Scanner(System.in);
        System.out.println("What is the title of the movie");
        title = qScanner.nextLine();
        System.out.println(String.format("Who is the director of %s", title));
        director = qScanner.nextLine();
        System.out.println(String.format("What year did %s make %s", director, title));
        String yearNum = qScanner.nextLine();
        year = Integer.valueOf(yearNum);
        System.out.println(String.format("How many oscars did %s win?", title));
        String oscarsNum = qScanner.nextLine();
        numOscars = Integer.valueOf(oscarsNum);
        System.out.println(String.format("In what country was %s made in?", title));
        country = qScanner.nextLine();
        /*
        System.out.println(String.format("Title: %s \n Director: %s \n Year: %d \n Oscars: %d \n Country: %s", title,
                director, year, numOscars, country));
         */
    }//End of Ask Questions
}

