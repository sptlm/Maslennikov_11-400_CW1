package kfu.itis.maslennikov.service;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

public class FileUploadService {
    public static final String IMAGE_PREFIX = "images";
    public static final String IMAGES_DIRECTORY = "src\\main\\webapp\\" + IMAGE_PREFIX;
    public static final int DIRECTORIES_COUNT = 100;

    /// returns file path from webapp
    public static String uploadFile(Part part) throws IOException {
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        String path = IMAGES_DIRECTORY + File.separator
                + Math.abs(filename.hashCode()) % DIRECTORIES_COUNT + File.separator
                + filename;

        File file = new File(path);

        InputStream content = part.getInputStream();
        file.getParentFile().mkdirs();
        file.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[content.available()];
        content.read(buffer);
        outputStream.write(buffer);
        outputStream.close();
        return IMAGE_PREFIX + File.separator
                + Math.abs(filename.hashCode()) % DIRECTORIES_COUNT + File.separator
                + filename;
    }

}
