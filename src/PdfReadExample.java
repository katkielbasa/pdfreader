
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfTemplate;
import java.io.IOException;

public class PdfReadExample {

	private static final String FILE_NAME = "C:/Users/katkielbasa/Downloads/DP-STATEMENT_9800489182-02.pdf";

	public static void main(String[] args) {

		PdfReader reader;

		try {

			reader = new PdfReader(FILE_NAME);

			// pageNumber = 1
			String textFromPage = PdfTextExtractor.getTextFromPage(reader, 2);

			System.out.println(textFromPage);

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
