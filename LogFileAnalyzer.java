package IntershipDEALSDRAY;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogFileAnalyzer {
	


    private static final String LOG_FILE = "";


    public static void analyzeLogs(String logFile) {
        Pattern errorPattern = Pattern.compile("HTTP/1\\.\\d\" (\\d{3})");
        Pattern requestPattern = Pattern.compile("\"(GET|POST) (.+?) HTTP");
        Pattern ipPattern = Pattern.compile("^(\\S+)");

        Map<String, Integer> statusCodes = new HashMap<>();
        Map<String, Integer> requests = new HashMap<>();
        Map<String, Integer> ipAddresses = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher errorMatcher = errorPattern.matcher(line);
                if (errorMatcher.find()) {
                    String statusCode = errorMatcher.group(1);
                    statusCodes.put(statusCode, statusCodes.getOrDefault(statusCode, 0) + 1);
                }

                Matcher requestMatcher = requestPattern.matcher(line);
                if (requestMatcher.find()) {
                    String requestPath = requestMatcher.group(2);
                    requests.put(requestPath, requests.getOrDefault(requestPath, 0) + 1);
                }

                Matcher ipMatcher = ipPattern.matcher(line);
                if (ipMatcher.find()) {
                    String ipAddress = ipMatcher.group(1);
                    ipAddresses.put(ipAddress, ipAddresses.getOrDefault(ipAddress, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("404 Errors Count: " + statusCodes.getOrDefault("404", 0));
        System.out.println("Most Requested Pages:");
        requests.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
        System.out.println("Top IP Addresses:");
        ipAddresses.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    public static void main(String[] args) {
        analyzeLogs(LOG_FILE);
    }
}
