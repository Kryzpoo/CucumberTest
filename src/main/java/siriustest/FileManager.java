package siriustest;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipFile;

public class FileManager {

    public static void example() throws  Exception{
        File file = new File ( "C:\\Users\\Kryzpo\\Desktop\\log.txt" );
        ZipFile zipFile = new ZipFile( "C:\\Users\\Kryzpo\\Desktop\\log.zip" );
        String innerFile = "log.txt";
        String pattern = "паттерн";
        String searchingString = "найтиэто";
        //System.out.println ( searchInLogFile (file, pattern, searchingString) );
        //System.out.println ( searchInZippedLogFile (zipFile, innerFile, pattern, searchingString) );

        File folder = new File( "C:\\Users\\Kryzpo\\Desktop\\logs" );
        getFilesFromFolder(folder);


    }

    public static List<File> getFilesFromFolder(File folder) {
        File[] listOfFiles = folder.listFiles();

        if ( listOfFiles == null || listOfFiles.length == 0 ) {
            System.err.println("Директория " + folder + "пуста");
            return null;
        }

        List<File> fitFiles = new ArrayList<>(listOfFiles.length);

        for (int i = listOfFiles.length - 1; i >= 0; i--) {
            if ( listOfFiles[i].isFile() ) {
                fitFiles.add(listOfFiles[i]);
            }
        }
        return fitFiles;
    }

    public static boolean searchInZippedLogFile ( ZipFile zipFile, String innerFile, String pattern, String searchingString ) throws Exception {
        boolean found = false;

        try (BufferedReader reader = new BufferedReader
                (new InputStreamReader
                        (zipFile.getInputStream(zipFile.getEntry(innerFile)), "UTF-8"))) {

            found = findString ( reader, pattern, searchingString );
        } catch (IOException ex) {
            System.out.println("Файл " + innerFile + " не найден в архиве " + zipFile);
        }
        return found;
    }

    public static boolean searchInLogFile  ( File file, String pattern, String searchingString ) {
        boolean found = false;

        try ( BufferedReader reader = new BufferedReader
                (new InputStreamReader
                        (new FileInputStream( file ), "UTF-8" ))) {

            found = findString ( reader, pattern, searchingString );
        } catch (IOException ex) {
            System.out.println("Файл " + file + " не найден");
        }
        return found;
    }


    private static boolean findString ( BufferedReader reader, String pattern, String searchingString ) throws IOException {
        String line;

        while( (line = reader.readLine()) != null ) {
            System.out.println( "First WHILE: " + line );
            if (line.contains(pattern)) {
                System.out.println( "Line contains PATTERN: " + line );
                while ( (line = reader.readLine()) != null ) {
                    System.out.println( "Second WHILE: " + line );
                    if ( line.contains(searchingString) ) {
                        System.out.println( "Line contains searchingSTRING: " + line );
                        return true;
                    }
                }
                break;
            }
        }
        return false;
    }

    public static String getPattern(File property) {
        return "";
    }
}
