package com.egov.win10.simpelv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class PdfReader extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_reader);

        PDFView pdfView = (PDFView)findViewById(R.id.pdfView);
        File pdfFile = new File("/storage/emulated/0/SiMPEL/Surat Masuk/BACAAN SHOLAT LENGKAP.pdf");

        pdfView.fromFile(pdfFile).load();



    }
}
