import com.itextpdf.text.pdf.parser.RenderFilter;
import com.itextpdf.text.pdf.parser.TextRenderInfo;

class FontRenderFilter extends RenderFilter {
	
	
	public boolean allowText(TextRenderInfo renderInfo) {
		int size = (int) ((renderInfo.getAscentLine().getStartPoint().get(1)) - 
		(renderInfo.getDescentLine().getStartPoint().get(1)));
		//String font = renderInfo.getFont().getPostscriptFontName();
		//System.out.println("Font:" + font + "\n size: "+ size  );
		return size == 7;
	}
}
