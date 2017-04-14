package siriustest;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogManager {

    public static boolean serverLogContainsString(File clientLogFile, File logsFolder, String searchingString ) {
        boolean found = false;
        String token;
        String WASSessionId;
        String[] serverLog;
        String[] clientLog;

        try ( FileInputStream clientLogFis = new FileInputStream(clientLogFile) ) {
            clientLog = getTextFileAsArray( clientLogFis );
            token = getSessionToken( clientLog );

            for (File serverLogFile : getFilesFromFolder(logsFolder)) {
                FileInputStream serverLogFis = new FileInputStream(serverLogFile);
                serverLog = getTextFileAsArray( serverLogFis );
                WASSessionId = getWASSessionId( serverLog, token );
                found = containsStringWithToken( serverLog, WASSessionId, searchingString );
                serverLogFis.close();
            }

        } catch (IOException ex) {
            System.err.println( "Log parsing error" );
        }
        return found;
    }

    public static boolean clientLogContainsString(File clientLogFile, String searchingString ) {
        boolean found = false;
        String[] clientLog;

        try ( FileInputStream clientLogFis = new FileInputStream(clientLogFile) ) {
            clientLog = getTextFileAsArray( clientLogFis );
            found = sessionContainsString(clientLog, searchingString);

        } catch (IOException ex) {
            System.err.println( "Log parsing error" );
        }
        return found;
    }

    public static boolean logContainsString(File logFile, String searchingString ) {
        boolean found = false;
        String[] log;

        try ( FileInputStream logFis = new FileInputStream(logFile) ) {
            log = getTextFileAsArray( logFis );
            found = containsString(log, searchingString);

        } catch (IOException ex) {
            System.err.println( "Log parsing error" );
        }
        return found;
    }

    private static boolean containsStringWithToken(String[] log, String WASSessionId, String searchingString) {
        boolean contains = false;
        for(int i = log.length - 1; i > 0; i--) {
            if ( log[i].contains(WASSessionId) && log[i].contains(searchingString) ) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    private static boolean containsString(String[] log, String searchingString) {
        boolean contains = false;
        for(int i = log.length - 1; i > 0; i--) {
            if ( log[i].contains(searchingString) ) {
                contains = true;
                break;
            }
        }
        return contains;
    }

    private static boolean sessionContainsString(String[] log, String searchingString) {
        boolean contains = false;
        for(int i = log.length - 1; i > 0; i--) {
            if ( log[i].contains(searchingString) ) {
                contains = true;
                break;
            }
            if (log[i].contains("Переход по \"/\"") )
                break;
        }
        return contains;
    }

    private static File[] getFilesFromFolder(File folder) {
        return folder.listFiles((dir, name) -> name.contains("SystemOut"));
    }

    private static String getWASSessionId(String[] log, String token) throws IOException {
        String WASSessionId = null;
        Pattern pattern = Pattern.compile("SystemOut     O (.*?) :");

        Matcher matcher;

        for(int i = log.length - 1; i > 0; i--) {
            if (log[i].contains(token)) {
                matcher = pattern.matcher(log[i]);
                if (matcher.find()) {
                    WASSessionId = matcher.group(1);
                    break;
                }
            }
        }
        return WASSessionId;
    }

    private static String getSessionToken(String[] log) {
        String token = null;
        Pattern pattern = Pattern.compile("token=(.*?)&");
        Matcher matcher;

        for(int i = log.length - 1; i > 0; i--) {
            matcher = pattern.matcher(log[i]);
            if (matcher.find()) {
                token = matcher.group(1);
                break;
            }
        }
        return token;
    }

    private static String[] getTextFileAsArray(FileInputStream fis) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader(fis, "UTF-8") );
        int linesCount = 0;

        while ( reader.readLine() != null ) {
            linesCount++;
        }

        String[] lines = new String[linesCount];

        // Новый BufferedReader, чтобы читать файл сначала
        fis.getChannel().position(0);
        reader = new BufferedReader ( new InputStreamReader(fis, "UTF-8") );

        for (int i = 0; i < linesCount; i ++) {
            lines[i] = reader.readLine();
        }
        return lines;
    }
}
