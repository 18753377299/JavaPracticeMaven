package javaPractice.WordOrPdf;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * XDocReportTest 将docx文档转为pdf
 * @author Tom
 *
 */
public class XDocReportTest {
 
	public static void main(String[] args) {
		
		try {
			String source = "F:/riskcontrol/riskcontrol_file/downloadFile/abc.docx";
			String target = "F:/riskcontrol/riskcontrol_file/downloadFile/Spring1.pdf";
			File file = new File(source);
			File targetFile = new File(target);
			XWPFDocument doc = new XWPFDocument(new FileInputStream(file));// docx
			PdfOptions options = PdfOptions.create();
			PdfConverter.getInstance().convert(doc, new FileOutputStream(targetFile), options);// pdf
			System.out.println("=======success============");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
