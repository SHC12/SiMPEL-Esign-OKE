package com.egov.win10.simpelv.TTD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import com.egov.win10.simpelv.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;

import java.io.File;


public class PreviewTTE extends AppCompatActivity {


    PDFView pdfView;

    String file_esign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_tte);

            pdfView = (PDFView) findViewById(R.id.pdf_viewer);
//        final Uri pdfFile = Uri.parse(getIntent().getStringExtra("FileUri"));


            file_esign = getIntent().getStringExtra("path_file_esign");
        Toast.makeText(this, ""+file_esign, Toast.LENGTH_SHORT).show();
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), file_esign);

        pdfView.fromFile(file).load();
    }






}
