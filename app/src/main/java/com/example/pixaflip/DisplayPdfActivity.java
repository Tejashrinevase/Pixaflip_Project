package com.example.pixaflip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.pixaflip.sql.Fav;
import com.example.pixaflip.sql.MyDbHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static android.widget.Toast.LENGTH_SHORT;

public class DisplayPdfActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    static List<pdf> list;
    ToggleButton toggleButton;
    PdfAdapter adapter;
    private String getDateTime()
    {
        SimpleDateFormat sd=new SimpleDateFormat ("yyyy-MM-ddcHH:mm:ss", Locale.getDefault ());
        Date d=new Date ();
        return sd.format(d);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_pdf);
        recyclerView = (RecyclerView) findViewById(R.id.pdflist);
        toggleButton = (ToggleButton)findViewById(R.id.favourite);

        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            connected = true;
        }
        else
            connected = false;



        MyDbHelper db = new MyDbHelper(DisplayPdfActivity.this);

        list = new ArrayList<>();
        list.add(new pdf("samplePdf ","http://www.africau.edu/images/default/sample.pdf"));
        list.add(new pdf("DataBase ", "http://zcht.home.amu.edu.pl/pliki/Databases%20for%20beginners.pdf"));
        list.add(new pdf("JavaBAsics ","https://www.cs.usfca.edu/~parrt/doc/java/JavaBasics-notes.pdf"));
        list.add(new pdf("PDF ","http://www.pdf995.com/samples/pdf.pdf"));
        list.add(new pdf("DataStructure ","http://www.darshan.ac.in/Upload/DIET/Documents/CE/2130702_DS_2015_24112015_025019AM.pdf"));



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PdfAdapter(list,this, db);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new PdfAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                MyDbHelper db = new MyDbHelper(DisplayPdfActivity.this);
                //  String pname pos.get
                //  int x=getAda

                String name = list.get(pos).getPdfName();

                Log.d("pdfname",name);
               // Toast.makeText ("pdfname " +name ,Toast.LENGTH_SHORT ).show ();
                //Toast.makeText("PdfName is "+name , LENGTH_SHORT).show() ; //).show();
                //Toast.makeText("name of pdf is:", LENGTH_SHORT).show();
                //Toast.makeText ("name of pdf is"+name,Toast.LENGTH_SHORT ).show ();
                //Toast.makeText("name of PDFS is"+name, LENGTH_SHORT).show();

                db.adduseract ( "DisplayPdfActivity",name,getDateTime () );
                // String timestamp2 =m.setTimestamp ( getDateTime () );
                // model pro = new model(from2,to2,timestamp2);
                // db.Adduser (m);

                Intent intent = new Intent(DisplayPdfActivity.this,WebActivity.class);
                intent.putExtra("position",pos);
                startActivity(intent);
            }

            @Override
            public void ontogclick(int pos,boolean state) {

                MyDbHelper db = new MyDbHelper(DisplayPdfActivity.this);
                if(state){
                    int x = pos;
                    System.out.println(db.isExist(list.get(x).getPdfName()));
                    if(!db.isExist(list.get(x).getPdfName())){
                        String url = list.get(x).getUrl();
                        String name = list.get(x).getPdfName();
                        Fav pro = new Fav(name,url);
                        db.addFavourite(pro);
                    }

                }else{
                    if(db.isExist(list.get(pos).getPdfName())){
                        String name = list.get(pos).getPdfName();
                        db.deleteById(name);
                    }
                }
            }
        });


    }
}

