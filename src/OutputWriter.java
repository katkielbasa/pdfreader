import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OutputWriter {

	BufferedWriter outfile;

	public OutputWriter() {

	}

	private String firstBalance(PDFParser parser) {
		List<String[]> balances = parser.getBalances();
		String firstBalance = balances.get(0)[0];
		// System.out.println("debug first balance: " + firstBalance);
		return firstBalance;
	}

	private String lastBalance(PDFParser parser) {
		List<String[]> balances = parser.getBalances();
		return balanceFromLastPage(balances);
	}

	private String firstDebit(PDFParser parser) {
		List<String[]> debits = parser.getDebits();
		String firstDebit;
		try {
			firstDebit = debits.get(0)[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			return "";
		}
		// System.out.println("debug first debit: " + firstDebit);
		return firstDebit;
	}

	private String firstCredit(PDFParser parser) {
		List<String[]> credits = parser.getCredits();
		String firstCredit;
		try {
			firstCredit = credits.get(0)[0];
		} catch (ArrayIndexOutOfBoundsException e) {
			return "";
		}
		// System.out.println("debug first credit: "+ firstCredit);
		return firstCredit;
	}

	private String balanceFromLastPage(List<String[]> pages) {
		for (int i = pages.size() - 1; i >= 0; i--) {
			String[] page = pages.get(i);
			String lastBalance;
			if ((lastBalance = lastNotEmpty(page)) != null) {
				return lastBalance;
			}
		}
		return null;
	}

	private String lastNotEmpty(String[] balances) {
		for (int i = balances.length - 1; i >= 0; i--) {
			if (balances[i] != "" && balances[i] != null && balances[i].trim().length() > 0) {
				return balances[i];
			}
		}
		return null;
	}

	public String header() {
		return "#File name, Customer Number, Firts Balance, Last balance, First Credit, First Debit";
	}

	// just for debug
	public void writeWhatRequired(PDFParser parser) {
		System.out.println("Name of file: " + parser.getFileName() + "\n Customer number: " + parser.getCustomerNo()
				+ "\nFirst Balance: " + firstBalance(parser) + "\nLast Balance: " + lastBalance(parser)
				+ "\nFirst Debit: " + firstDebit(parser) + "First credit: " + firstCredit(parser));

	}

	// **this function can have more start scenarios in future, this one is for
	// CSV*/
	public void start() throws IOException {

		FileWriter fstream = new FileWriter("C:/Users/katkielbasa/pdf/out/PDFStatmentOUT.txt", true); // true
																										// tells
																										// to
																										// append
																										// data.
		outfile = new BufferedWriter(fstream);
		System.out.println(header());
		outfile.write(header());
		outfile.newLine();
	}

	//
	public void printRecord(PDFParser parser) throws IOException {
		String record = q(parser.getFileName()) + ", " + q(parser.getCustomerNo()) + ", " + q(firstBalance(parser))
				+ ", " + q(lastBalance(parser)) + ", " + q(firstCredit(parser)) + ", " + q(firstDebit(parser)) + "\n";
		System.out.println(record);
		outfile.write(record);
		outfile.newLine();
	}

	private String q(String s) {
		return "\"" + s + "\"";
	}

	// maybe needed in future
	public void finish() throws IOException {
		System.out.println("No more statements in this folder");
		outfile.close();

	}
}
