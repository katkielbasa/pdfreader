import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class PDFStatementsReader {

	public PDFStatementsReader() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		OutputWriter writer = new OutputWriter(args[1]);
		try {
			writer.start();
			final File folder = new File(args[0]);
			for (final File fileEntry : folder.listFiles(new FilenameFilter() { 
                public boolean accept(File dir, String filename)
                { return filename.endsWith(".pdf"); }})) {
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
