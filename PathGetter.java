/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bankProject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rande2
 */
public class PathGetter {
    //private static final Path PROGRAM_DIR = findProgramDir();
    private static final Path USER_HOME = Paths.get(System.getProperty("user.home"));
    private static final char sep = System.getProperty("file.separator").charAt(0);

    public static Path getUserHome() {
        return USER_HOME;
    }

    public static Path getFromHome(String name) {
        return USER_HOME.resolve(name);
    }

    public static Path programResource(String name) {
        //remove "file:/"
        String path = PathGetter.class.getClassLoader().getResource(name).toString();
        if(path.charAt(0)=='f')
            path=path.substring(6);
        else if(path.charAt(0)=='j')
            path=path.substring(10);
        //remove jar file from path, program will try to read from jar
        String jar = ".jar!/";
        int end, similar = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == jar.charAt(similar)) {
                if (++similar == jar.length()) {
                    end = i;//end is the index of the '/'
                    for (int j = end-1; j > 0; j--) {
                        if (path.charAt(j) == '/') {//not entering
                            StringBuilder builder = new StringBuilder();
                            builder.append(path.substring(0, j));
                            builder.append(path.substring(end, path.length()));
                            path=builder.toString();
                            break;
                        }
                    }
                    break;
                }
            } else {
                similar = 0;
            }
        }
        return Paths.get(path);
    }

    public static void ensureExistance(Path path) {
        if (!Files.exists(path))
            try {
            Path parent = path.getParent();
            if (!Files.exists(parent)) {
                Files.createDirectories(parent);
            }
            Files.createFile(path);
        } catch (IOException ex) {
            Logger.getLogger(PathGetter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
