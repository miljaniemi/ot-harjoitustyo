
package studyingcalendar.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import studyingcalendar.domain.Course;

public class FilePasswordDao implements PasswordDao {

    private String file;
    private String password;

    public FilePasswordDao(String file) throws Exception {
        this.file = file;
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                password = parts[0];
            }
        } catch (Exception e) {
            FileWriter writer = new FileWriter(new File(file));
            writer.close();
        }
    }

    @Override
    public String save(String password) throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
                writer.write(password + ";" + "\n");
        }
        return password;
    }

    public String getPassword() throws Exception {
        if (password.isEmpty() == false) {
            return password;
        } else {
            return null;
        }
    }
}
