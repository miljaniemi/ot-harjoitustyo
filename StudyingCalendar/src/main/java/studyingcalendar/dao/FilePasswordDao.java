
package studyingcalendar.dao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
import studyingcalendar.domain.Course;

public class FilePasswordDao implements PasswordDao {

    private String file;
    private String password;

    /**
     * Metodi, joka yrittää löytää salasanan tiedostosta ja tallentaa sen parametriin password
     * @param file tiedosto, jossa on salasana
     * @throws Exception 
     */
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

    /**
     * Metodi, joka talentaa uuden salasanan
     * @param password salasana, joka tallennetaan
     * @return salasanan
     * @throws Exception 
     */
    @Override
    public String save(String password) throws Exception {
        try (FileWriter writer = new FileWriter(new File(file))) {
            writer.write(password + ";" + "\n");
        }
        this.password = password;
        return password;
    }

    /**
     * Metodi, joka palauttaa salasanan
     * @return salasana
     * @throws Exception
     */
    @Override
    public String getPassword() throws Exception {
        if (file.isEmpty()) {
            return null;
        } else {
            return password;
        }
    }
}
