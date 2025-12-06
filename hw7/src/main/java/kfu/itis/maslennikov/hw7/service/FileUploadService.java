package kfu.itis.maslennikov.hw7.service;

import kfu.itis.maslennikov.hw7.util.AppConfigUtil;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUploadService {
    public static final int DIRECTORIES_COUNT = 100;
    private static final Path filesDirectory = Paths.get(AppConfigUtil.loadConfig().FilesDirectory()).toAbsolutePath().normalize();


    /// returns file path from webapp
    public static String uploadFile(Part part) throws IOException {

        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();

        String path = Math.abs(filename.hashCode()) % DIRECTORIES_COUNT + "/"
                + filename;

        File file = new File(filesDirectory + "/" + path);

        InputStream content = part.getInputStream();
        file.getParentFile().mkdirs();
        file.createNewFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        byte[] buffer = new byte[content.available()];
        content.read(buffer);
        outputStream.write(buffer);
        outputStream.close();
        return path;
    }

}
