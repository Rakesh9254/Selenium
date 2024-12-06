package IntershipDEALSDRAY;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SystemHealthMonitor {

    public static void main(String[] args) {
        System.out.println("System Health Monitoring:");
        
        // Monitor CPU usage
        System.out.println("\n--- CPU Usage ---");
        getCpuUsage();

        // Monitor Memory usage
        System.out.println("\n--- Memory Usage ---");
        getMemoryUsage();

        // Monitor Disk Space
        System.out.println("\n--- Disk Space ---");
        getDiskSpace();

        // Monitor Running Processes
        System.out.println("\n--- Running Processes ---");
        getRunningProcesses();
    }

    private static void getCpuUsage() {
        try {
            // macOS command to get CPU usage
            String command = "top -l 1 | grep \"CPU usage\"";
            
            Process process = Runtime.getRuntime().exec(new String[] { "/bin/zsh", "-c", command });
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            
            while ((line = reader.readLine()) != null) {
                // Trim the line to clean up extra spaces
                System.out.println(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getMemoryUsage() {
        try {
            // macOS command to get memory usage
            String command = "vm_stat";
            
            Process process = Runtime.getRuntime().exec(new String[] { "/bin/zsh", "-c", command });
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            
            while ((line = reader.readLine()) != null) {
                // Trim the line to clean up extra spaces
                System.out.println(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getDiskSpace() {
        try {
            // macOS command to get disk space
            String command = "df -h";
            
            Process process = Runtime.getRuntime().exec(new String[] { "/bin/zsh", "-c", command });
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            
            while ((line = reader.readLine()) != null) {
                // Trim the line to clean up extra spaces
                System.out.println(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getRunningProcesses() {
        try {
            // macOS command to get running processes
            String command = "ps aux";
            
            Process process = Runtime.getRuntime().exec(new String[] { "/bin/zsh", "-c", command });
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            
            while ((line = reader.readLine()) != null) {
                // Print a formatted line if it includes essential information (e.g., process ID, CPU, memory usage)
                if (line.contains("Google Chrome")) {
                    System.out.println(line.trim());
                } else if (line.contains("/System/Library")) {
                    System.out.println(line.trim());
                } else if (line.contains("java")) {
                    System.out.println(line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
