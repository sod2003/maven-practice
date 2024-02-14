package com.skillstorm;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.skillstorm.daos.BookDao;
import com.skillstorm.daos.BookDaoMySQLImpl;
import com.skillstorm.models.Book;

public class Main {

    static BookDao dao = new BookDaoMySQLImpl();
    public static void main(String[] args) {
        List<Book> result = dao.findAll();
		for (Book book : result) {
            System.out.println(book);
        }
        // start();
    }

    public static void start() {

        String choice = takeInput("Welcome to BookSearch. Would you like to search by title, author or genre?");
        boolean SearchTypeChosen = false;
        Optional<Book> bookResult = null;


        while(!SearchTypeChosen){
            switch (choice.toLowerCase()) {
                case "title":
                    String searchString = takeInput("Please enter a title to search for:");
                    bookResult = dao.findByTitle(searchString);
                    SearchTypeChosen = true;
                    break;
                case "author":
                    // TODO add author search
                    System.out.println("Sorry, that feature is under construction!");
                    break;
                case "genre":
                    // TODO add genre search
                    System.out.println("Sorry, that feature is under construction!");
                    break;
            
                default:
                    System.out.println("Sorry, that option is not recognized.");
                    break;
            }

        }

        if(bookResult==null){
            System.out.println("Sorry, no books were returned from that search.");
        }else{
            System.out.println(bookResult);
        }

    }

    public static String takeInput(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    public static int getUserId(String url) throws IllegalArgumentException {
        return 0;
   }

    public static String getQueryParameterValue(String url, String key) throws NullPointerException, IllegalArgumentException {
        
        if (url == null || key == null) {
            throw new NullPointerException();
        }

        if (key.isEmpty() || illegalArgumentHelper(key)) {
            throw new IllegalArgumentException();
        }

        if (!(url.contains("?"))) {
            return null;
        }

        int indexValueStart = url.lastIndexOf(key) + 2;
        String shortStr = url.substring(indexValueStart);
        int indexValueEnd = shortStr.contains("&") ?  shortStr.indexOf("&") : shortStr.length();
        String value = shortStr.substring(0, indexValueEnd);

        if (value.isEmpty()) {
            return null;
        }
        return value;
    }

    public static boolean illegalArgumentHelper(String key) {
        String illegalChars = ";" + "/" + "?" + ":" + "@" + "&" + "=" + "+" + "," + "$";
        for (char c : illegalChars.toCharArray()) {
            if (key.contains("" + c)) {
                return true;
            }
        }
        return false;
    }
}