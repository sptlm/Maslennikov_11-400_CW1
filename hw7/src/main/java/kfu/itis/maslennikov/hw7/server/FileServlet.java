package kfu.itis.maslennikov.hw7.server;

import kfu.itis.maslennikov.hw7.util.AppConfigUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@WebServlet("/file/*")
public class FileServlet extends HttpServlet {

    private final Path filesDirectory = Paths.get(AppConfigUtil.loadConfig().FilesDirectory()).toAbsolutePath().normalize();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        // substring(1) удаляет ведущий слеш, чтобы получить "54/image.png".
        String name = Optional.ofNullable(req.getPathInfo()).orElse("/").substring(1);


        // чтобы убрать потенциальные обходы каталога через ".."
        Path file = filesDirectory.resolve(name).normalize();

        // file.startsWith(filesDirectory) — защита от выхода за пределы корня (directory traversal);
        if (name.isBlank() || !file.startsWith(filesDirectory) || !Files.exists(file)) {
            resp.sendError(404);
            return;
        }

        // определяем MIME‑тип файла по содержимому/расширению.
        String mime = Files.probeContentType(file);

        // либо найденный MIME, либо безопасный бинарный по умолчанию.
        resp.setContentType(mime != null ? mime : "application/octet-stream");

        // Копируем байты файла напрямую в выходной поток HTTP‑ответа;
        Files.copy(file, resp.getOutputStream());
    }
}