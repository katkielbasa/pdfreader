import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

	private static final String FILENAME = "C:/Users/katkielbasa/Downloads/DP-STATEMENT_9800489182-02.pdf";

	public ReadFile() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {

		BufferedReader br = null;
		FileReader fr = null;

		try {

			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);

			String sCurrentLine;

			br = new BufferedReader(new FileReader(FILENAME));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}

