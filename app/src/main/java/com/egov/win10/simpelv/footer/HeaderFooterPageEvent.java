package com.egov.win10.simpelv.footer;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;

public class HeaderFooterPageEvent extends PdfPageEventHelper {

    public void onStartPage(PdfWriter writer, Document document) {
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Top Left"), 30, 800, 0);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("Top Right"), 550, 800, 0);
    }
/*
    public void onEndPage(PdfWriter writer, Document document) {
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("http://www.xxxx-your_example.com/"), 110, 30, 0);
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_CENTER, new Phrase("page " + document.getPageNumber()), 550, 30, 0);
    }*/

    Font ffont = new Font(Font.FontFamily.UNDEFINED, 10, Font.BOLD);

    private void addHeader(PdfWriter writer,Document document){
        PdfContentByte cb = writer.getDirectContent();
        Phrase header = new Phrase("Customer Id : ", ffont);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                header,
                (document.right() - document.left()) / 2 +
                        document.leftMargin(),
                document.top() - 10, 0);

    }

    private void addFooter(PdfWriter writer,Document document){
        PdfContentByte cb = writer.getDirectContent();
        Phrase footer = new Phrase("Page "+writer.getPageNumber(),
                ffont);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                footer,
                (document.right() - document.left()) / 2 +
                        document.leftMargin(),
                document.bottom() - 10, 0);
    }


    public void onEndPage(PdfWriter writer, Document document) {
        try{
            addHeader(writer,document);
            addFooter(writer,document);
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
