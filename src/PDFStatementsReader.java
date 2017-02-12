import java.io.File;
import java.io.IOException;

public class PDFStatementsReader {

	public PDFStatementsReader() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		OutputWriter writer = new OutputWriter();
		try {
			writer.start();
			final File folder = new File("C:/Users/katkielbasa/pdf");
			for (final File fileEntry : folder.listFiles()) {
				if (fileEntry.isDirectory()) {
					continue;
				} else {
					PDFParser parser = new PDFParser(fileEntry);
					try {
						parser.parse();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// writer.writeEverithing(parser);
					// writer.writeWhatRequired(parser);
	
					writer.printRecord(parser);
	
					// System.out.println(fileEntry.getAbsolutePath());
				}
	
			}
			writer.finish();
		} catch(IOException e) {
			System.out.println("Error! " + e);
		}
	}

}
