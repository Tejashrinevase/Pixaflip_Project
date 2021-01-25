package com.example.pixaflip;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;


public class pdfopener extends AppCompatActivity {


    PDFView myPDFViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdfopener);
        myPDFViewer=(PDFView)findViewById(R.id.PDFView);
        String getItem=getIntent().getStringExtra("pdfFileName");
        if(getItem.equals("Clean Code"))
        {
            myPDFViewer.fromAsset("Clean Code.pdf").load();
        }

        if(getItem.equals("Cyber Assignment"))
        {
            myPDFViewer.fromAsset("Cyber Assignment.pdf").load();
        }

        if(getItem.equals("Database System"))
        {
            myPDFViewer.fromAsset("Database System.pdf").load();
        }
        if(getItem.equals("IOT"))
        {
            myPDFViewer.fromAsset("IOT.pdf").load();
        }

        if(getItem.equals("Thinking in C++"))
        {
            myPDFViewer.fromAsset("Thinking in C++.pdf").load();
        }

    }
}