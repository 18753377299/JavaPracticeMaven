package javaPractice.WordOrPdf;

import org.docx4j.convert.out.pdf.PdfConversion;
import org.docx4j.convert.out.pdf.viaXSLFO.Conversion;
import org.docx4j.convert.out.pdf.viaXSLFO.PdfSettings;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;

import java.io.*;

// 能够成功的生成pdf文件
@SuppressWarnings({"deprecation" })
public class Docx2PDFConverter {


	public static void main(String[] args) {
		
		createPDF();
		System.out.println("======success=======");
	}


	private static void createPDF() {
		try {
			long start = System.currentTimeMillis();
			 String sourceFile = "F:/riskcontrol/riskcontrol_file/downloadFile/20190416154206516.docx";
//	        String sourceFile = "F:/RCJBX00200002019000014_A000011533.docx";
	         String destFile="F:/riskcontrol/riskcontrol_file/downloadFile/Spring3.pdf";

//			InputStream is = new FileInputStream(new File(
//					"docx"+ System.getProperty("file.separator") +"ceshi2.docx"));
	         InputStream is = new FileInputStream(new File(sourceFile));
			WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage.load(is);


			PdfSettings pdfSettings = new PdfSettings();


//			OutputStream out = new FileOutputStream(new File(
//					"pdf"+ System.getProperty("file.separator") +"ceshi3.pdf"));
			OutputStream out = new FileOutputStream(new File(destFile));
			PdfConversion converter = new Conversion(wordMLPackage);
			converter.output(out, pdfSettings);


			System.err.println("Generate pdf with "
					+ (System.currentTimeMillis() - start) + "ms");


		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
