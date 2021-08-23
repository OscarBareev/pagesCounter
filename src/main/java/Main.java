import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "D:\\ideProjects\\parser\\pages";

        PdfCounter counter = new PdfCounter();

        counter.doWork(path);

    }
}
