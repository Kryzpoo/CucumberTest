package siriustest;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogManager {

    private static File[] getFilesFromFolder(File folder) {
        return folder.listFiles((dir, name) -> name.contains("SystemOut"));
    }

    private static String getSessionToken(FileInputStream fis) throws IOException {
        BufferedReader reader = new BufferedReader ( new InputStreamReader(fis, "UTF-8") );
        String token = "___NO_CLIENT_SESSION_TOKEN___";
        Pattern pattern = Pattern.compile("&token=(.*?)&");
        Matcher matcher;
        String line;

        while ( (line = reader.readLine()) != null ) {
            matcher = pattern.matcher(line);
            if (matcher.find()) {
                token = matcher.group(1);
            }
        }
        // Берем не весь токен, а его часть (последние 20 символов) - из-за возможного маскирования остальной части токена
        token = token.substring(25);
        return token;
    }

    private static String getWASSessionId(BufferedReader reader, String token) throws IOException {
        String WASSessionId = "___NO_WAS_SESSION_ID___";
        Pattern pattern = Pattern.compile("SystemOut {5}O (.*?) :");
        Matcher matcher;
        String line;

        while ( (line = reader.readLine()) != null ) {
            if (line.contains("Gate") && line.contains(token)) {
                matcher = pattern.matcher(line);
                if (matcher.find()) {
                    WASSessionId = matcher.group(1);
                    break;
                }
            }
        }
        return WASSessionId;
    }

    /*
        Метод проверки лога клиента
        Берем токен последней сессии в логе клиента
        Ищем нужную строку сразу после того, как токен встретился
     */
    public static boolean parseClientLog(File clientLog, String stringToFind) throws IOException {
        String line;
        boolean search = false;

        try ( FileInputStream fis = new FileInputStream(clientLog) ) {
            String token = getSessionToken(fis);
            // Возврат к началу файла
            fis.getChannel().position(0);
            BufferedReader reader = new BufferedReader ( new InputStreamReader(fis, "UTF-8") );
            while ( (line = reader.readLine()) != null ) {
                if (search) {
                    if (line.contains(stringToFind))
                        return true;
                } else if (line.contains(token))
                    search = true;
            }
        }
        catch (IOException ex) {
            System.err.println( "Client log parsing error" );
        }
        return false;
    }

    /*
        Метод проверки лога сервера
        Берем токен последней сессии в логе клиента
        Берем лог сервера из папки
        Берем WASSessionID сервера
        Ищем нужную строку, которая включает WASSessionID интересующей нас сессии
        Если строка не найдена, берем следующий лог сервера
     */
    public static boolean parseServerLog(File clientLog, File serverLog, String stringToFind) throws IOException {
        String WASSessionId;
        String token;
        try (FileInputStream clientFis = new FileInputStream(clientLog)) {
            // Находим токен клиентской сессии в клиентском логе
            token = getSessionToken(clientFis);
        }

        // Читаем только SystemOut.log
        try (FileInputStream serverFis = new FileInputStream(serverLog)) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(serverFis, "UTF-8"));
            // Находим токен сессии WAS
            WASSessionId = getWASSessionId(reader, token);
            String line;
            // Пытаемся найти нужный лог
            // Если находим, успешно завершаем
            while ((line = reader.readLine()) != null) {
                if (line.contains(WASSessionId) && line.contains(stringToFind)) {
                    reader.close();
                    return true;
                }
            }
        }

        return false;
    }

    /*
        Метод проверки лога эмулятора
        Ищем нужную строку в логе эмулятора
     */
    public static boolean parseEmulatorLog(File emulatorLog, String stringToFind) throws IOException {
        try ( FileInputStream fis = new FileInputStream(emulatorLog) ) {
            BufferedReader reader = new BufferedReader ( new InputStreamReader(fis, "UTF-8") );
            String line;
            while ( (line = reader.readLine()) != null ) {
                if ( line.contains(stringToFind) ) {
                    return true;
                }
            }
        } catch (IOException ex) {
            System.err.println( "Emulator log parsing error" );
        }
        return false;
    }
}
