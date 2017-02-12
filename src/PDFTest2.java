
/**
* Created by kat.kielbasa on 09/02/2017.
*/
/*import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
//import com.itextpdf.text.pdf.parser.TextRenderInfo;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

public class PDFTest2 {

	private static final String SRC = "C:/Users/katkielbasa/pdf/DP-STATEMENT_9800489182-02.pdf";

	public static void main(String[] args) throws IOException, DocumentException {
		new PDFTest2().parse(SRC);

	}
*/
/*	public void parse(String filename) throws IOException {
		
		PdfReader reader = new PdfReader(filename);
		Rectangle mediabox = reader.getPageSize(2);
		System.out.println("Top=" + mediabox.getTop() + " Bottom=" + mediabox.getBottom() + "Left=" + mediabox.getLeft()
				+ " Right=" + mediabox.getRight() + "\n\n");

		// page1: Rectangle rect1 = new Rectangle(500, 0, 700 , 400);
		// page 2-x balances
		//Rectangle rect = new Rectangle(300, 0, 400, 800);
		Rectangle rect = new Rectangle(273, 472, 0, 463);
		RenderFilter regionFilter = new RegionTextRenderFilter(rect);
		FontRenderFilter fontFilter = new FontRenderFilter();
		TextExtractionStrategy strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(),
				regionFilter, fontFilter);
		  

		String s1 = PdfTextExtractor.getTextFromPage(reader, 1, strategy);
		System.out.println(s1);


		// System.out.println(PdfTextExtractor.getTextFromPage(reader, 1,
		// strategy));
		// System.out.println(PdfTextExtractor.getTextFromPage(reader, 2,
		// strategy));
		// String s2 = PdfTextExtractor.getTextFromPage(reader, 2, strategy);
		// System.out.println("s2:"+ s2);
		// String[] splitStr = s1.split("\\s+");
		// System.out.println("drugi rekord: " + splitStr[2]);
		reader.close();
		// String sAll = s1 + "\n"+ s2;
		// System.out.println(sAll);
	}
}*/