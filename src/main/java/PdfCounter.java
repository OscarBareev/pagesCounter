import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PdfCounter {

    public void doWork(String path) throws IOException {



        Stream<Path> filePathStream = Files.walk(Paths.get(path));

        filePathStream
                .filter(Files::isRegularFile)
                .filter(filePath -> filePath.toString().endsWith("pdf"))
                .forEach(filePath -> {




                    try {
                        PDDocument doc = PDDocument.load(filePath.toFile());
                        int count = doc.getNumberOfPages();
                        doc.close();

                        String newFileName = filePath.getFileName().toString()
                                .replace(".pdf", " на " + count + "л..pdf");

                        Files.move(filePath, filePath.resolveSibling(newFileName));


                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                });


    }
}
