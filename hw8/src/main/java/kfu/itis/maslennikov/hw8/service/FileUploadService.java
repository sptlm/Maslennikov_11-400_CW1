package kfu.itis.maslennikov.hw8.service;

import com.cloudinary.Cloudinary;
import kfu.itis.maslennikov.hw8.util.AppConfigUtil;
import kfu.itis.maslennikov.hw8.util.CloudinaryUtil;

import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class FileUploadService {
    public static final int DIRECTORIES_COUNT = 100;
    private static final Path filesDirectory = Paths.get(AppConfigUtil.loadConfig().FilesDirectory()).toAbsolutePath().normalize();
    static Cloudinary cloudinary = CloudinaryUtil.getInstance();


    /// returns file path from webapp
    public static Map<String, String> uploadFile(Part part) throws IOException {

        Map<String, String> result = new HashMap<>();

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

        Map<String, String> upload_results =  cloudinary.uploader().upload(file,new HashMap());

        result.put("image", path);
        result.put("cloud_image", upload_results.get("url"));
        return result;
    }

}
