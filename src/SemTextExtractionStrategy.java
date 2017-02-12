import com.itextpdf.text.pdf.parser.ImageRenderInfo;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

public class SemTextExtractionStrategy implements TextExtractionStrategy {
	private String text;

	@Override
	public void beginTextBlock() {
	}

	@Override
	public void renderText(TextRenderInfo renderInfo) {
		text = renderInfo.getText();

		System.out.println(renderInfo.getFont().getFontType());

		System.out.print(text);
	}

	@Override
	public void endTextBlock() {
	}

	@Override
	public void renderImage(ImageRenderInfo renderInfo) {
	}

	@Override
	public String getResultantText() {
		return text;
	}
}