package utils;
import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class AuthReader {
    public  Map<String, Object> read(String path) throws IOException {
        InputStream in = Files.newInputStream(Paths.get(path));
        Yaml yaml = new Yaml();
        return (Map<String, Object>) yaml.load(in);
  }
    public String Testread(String field) throws IOException {
//        InputStream inputStream = new FileInputStream(new File(path));
//        Yaml yaml = new Yaml(new Constructor(Logopass.class));
//        Map<String, Object> data = yaml.load(inputStream);
//        String k;
//        try (InputStream in = AuthReader.class
//                .getResourceAsStream("auth.yaml")) {
//            Logopass logo =yaml.loadAs(inputStream, Logopass.class);
//            k = logo.getlogin();
//        }
//        System.out.println("login "+yaml.getName());
//        return k;
        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream("src/test/resources/auth.yml");

// Создание нового ObjectMapper как YAMLFactory
        Map<String, Object> data = yaml.load(inputStream);
        System.out.println("Login is " + ", field's value "+data.get(field).toString());
        return data.get(field).toString();
    }

}

