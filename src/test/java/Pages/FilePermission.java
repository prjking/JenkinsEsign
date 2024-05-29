package Pages;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class FilePermission {

    /**
     * Sets execute permissions for the specified file and runs it.
     *
     * @param filePath The relative path to the file.
     * @throws IOException if an I/O error occurs.
     * @throws InterruptedException if the current thread is interrupted while waiting.
     */
    public static void setExecutePermissionAndRun(String filePath) throws IOException, InterruptedException {
        Path path = Paths.get(filePath);
        File file = new File(filePath);

        if (file.exists()) {
            // Set execute permissions (POSIX)
            try {
                Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rwxr-xr-x");
                Files.setPosixFilePermissions(path, permissions);

                // Verify the permissions
                Set<PosixFilePermission> newPermissions = Files.getPosixFilePermissions(path);
                System.out.println("Permissions set to: " + PosixFilePermissions.toString(newPermissions));
            } catch (UnsupportedOperationException e) {
                System.out.println("POSIX file permissions are not supported on this platform.");
            }

            // Execute the file
            if (file.canExecute()) {
                Process process = new ProcessBuilder(file.getAbsolutePath()).start();
                process.waitFor(); // Wait for the process to complete
                System.out.println("File executed successfully.");
            } else {
                System.out.println("File is not executable: " + filePath);
            }
        } else {
            System.out.println("File not found: " + filePath);
        }
    }
}
