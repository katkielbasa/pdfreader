
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.FilteredTextRenderListener;
import com.itextpdf.text.pdf.parser.LocationTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.itextpdf.text.pdf.parser.RegionTextRenderFilter;
import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class PDFParser {

	public PDFParser(File _pdf) {
		pdf = _pdf;
	}

	//public static final String SRC = "C:/Users/katkielbasa/Downloads/DP-STATEMENT_9800489182-02.pdf";

	private File pdf;
	private PdfReader reader;
	private List<String[]> balances;
	private List<String[]> debits;
	private List<String[]> credits;
	private String customerNo;
	private FontRenderFilter fontFilter = new FontRenderFilter();
	

	/*
	 * public static void main(String[] args) throws IOException,
	 * DocumentException { new PDFParser().parse(SRC); }
	 */



	public String getCustomerNo() {
		return customerNo;
	}
	
	public final String getFileName() {
		return pdf.getName();
	}

	public List<String[]> getBalances() {
		return balances;
	}

	public List<String[]> getDebits() {
		return debits;
	}

	public List<String[]> getCredits() {
		return credits;
	}

	private void parseCustomerNumber() throws IOException {
		Rectangle rect = new Rectangle(273, 472, 0, 463);
		RenderFilter regionFilter = new RegionTextRenderFilter(rect);
		TextExtractionStrategy strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(),
	    regionFilter);	
		customerNo = PdfTextExtractor.getTextFromPage(reader, 1, strategy);
	}

	private void parseBalances() throws IOException {
		Rectangle rect = new Rectangle(500, 0, 700, 800);
		RenderFilter regionFilter = new RegionTextRenderFilter(rect);
		TextExtractionStrategy strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(),
				regionFilter, fontFilter);	
		balances = new ArrayList<String[]>();
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
			String balance = PdfTextExtractor.getTextFromPage(reader, i, strategy);
			balances.add(balance.split("\\s"));
		}
	}

	private void parseDebits() throws IOException {
		Rectangle rect = new Rectangle(300, 0, 400, 800);
		RenderFilter regionFilter = new RegionTextRenderFilter(rect);
		TextExtractionStrategy strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(),
				regionFilter, fontFilter);	
		debits = new ArrayList<String[]>();
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
			String debit = PdfTextExtractor.getTextFromPage(reader, i, strategy);
			debits.add(debit.split("\\s"));
		}
	}

	private void parseCredits() throws IOException {
		Rectangle rect = new Rectangle(400, 0, 500, 800);
		RenderFilter regionFilter = new RegionTextRenderFilter(rect);
		TextExtractionStrategy strategy = new FilteredTextRenderListener(new LocationTextExtractionStrategy(),
				regionFilter, fontFilter);	
		credits = new ArrayList<String[]>();
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
			String credit = PdfTextExtractor.getTextFromPage(reader, i, strategy);
			credits.add(credit.split("\\s"));
		}

	}

	public void parse() throws IOException {
		reader = new PdfReader(pdf.getAbsolutePath());
		parseCustomerNumber();
		parseBalances();
		parseDebits();
		parseCredits();
		reader.close();
	}
}