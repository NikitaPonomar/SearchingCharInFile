package org.example;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Please, input the string, you want to find in the file xanadu.txt");
        Scanner scanner=new Scanner(System.in);
      //  String findStr = "Xanadu";

        String findStr=scanner.nextLine();
        long total=0;
        Path file= FileSystems.getDefault().getPath("xanadu.txt");
        System.out.println("---------------------------");
        for (String line : Files.readAllLines(file)) {
            System.out.println("\tthe line was read: " + line);
            long matches=countOccurrences(line.toLowerCase(), findStr.toLowerCase());
            System.out.println("the string "+findStr+" was found in the line: "+ matches);
            total+=matches;
        }
        System.out.println("---------------------");
        System.out.println("matches was found:" + total);


    }

    public static long countOccurrences(String source, String find) {

        return Pattern.compile(find) // Pattern
                .matcher(source) // Mather
                .results()       // Stream<MatchResults>
                .count();
    }
}