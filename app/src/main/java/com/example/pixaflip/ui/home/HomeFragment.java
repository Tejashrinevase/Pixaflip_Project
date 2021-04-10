package com.example.pixaflip.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.pixaflip.DisplayCovidActivity;
import com.example.pixaflip.DisplayPdfActivity;
//import com.example.pixaflip.DisplayReport
import com.example.pixaflip.DisplayVideoActivity;
import com.example.pixaflip.MainActivity;
import com.example.pixaflip.R;
import com.example.pixaflip.sql.MyDbHelper;
import com.example.pixaflip.sql.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Button addCourseBtn;
    private MyDbHelper dbHandler;
    private String getDateTime()
    {
        SimpleDateFormat sd=new SimpleDateFormat ("yyyy-MM-ddcHH:mm:ss", Locale.getDefault ());
        Date d=new Date ();
        return sd.format(d);
    }

    // PDFAdapter.ItemClickListener itemClickListener;

    // MyDbHandler db;

    public interface ItemClickListener {
        void onItemClick(int pos);
        // void ontogclick
        void ontogclick(String time,String aname);
    }


    public String fun()
    {
        String s1="DisplayCovidActivity";
        return s1;
        // DisplayPdfActivity pd=new DisplayPdfActivity (s1);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, final Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        final   Button playVideo=root.findViewById(R.id.playVideo);
        //MyDbHandler db=new MyDbHandler ( HomeFragment.this );
        final Button showPdf=root.findViewById(R.id.showPdf);
        final Button viewReport=root.findViewById(R.id.viewreport);


        playVideo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                dbHandler = new MyDbHelper(getContext ());
                //dbHandler.adduseract ( "DisplayVideoActivity", "", getDateTime () );
                // MyFav pro = new MyFav(name,url);
                model m=new model();
                String from2 = m.setFrom1 ( "HomeFragment" );
                String to2=m.setTo1 ( "DisplayVideoActivity" );
                String timestamp2 =m.setTimestamp ( getDateTime () );
                // model pro = new model(from2,to2,timestamp2);
                dbHandler.Adduser (m);
                // model m=new model();
                // dbHandler.adduseract ( "DisplayVideoActivity", "DisplayPdfActivity", getDateTime () );


               /*
                MyDbHandler db = new MyDbHandler(DisplayPdfActivity.this);
                if(state){
                    int x = pos;
                    System.out.println(db.isExist(list.get(x).getPdfName()));
                    if(!db.isExist(list.get(x).getPdfName())){
                        String url = list.get(x).getPdfUrl();
                        String name = list.get(x).getPdfName();
                        MyFav pro = new MyFav(name,url);
                        db.addFavourite(pro);
                        if(viewReport.isPressed ()) {
                    dbHandler.adduseract ( "DisplayVideoActivity", "DisplayCovidActivity", getDateTime () );
                }*/




                Intent intent=new Intent(MainActivity.context, DisplayVideoActivity.class);
                startActivity(intent);


            }
        });


        showPdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHandler = new MyDbHelper(getContext ());
                //dbHandler.adduseract ( "DisplayVideoActivity", "", getDateTime () );
                // MyFav pro = new MyFav(name,url);
                model m1=new model();
                String from2 = m1.setFrom1 ( "HomeFragment" );
                String to2=m1.setTo1 ( "DisplayPdfActivity" );
                String timestamp2 =m1.setTimestamp ( getDateTime () );
                // model pro = new model(from2,to2,timestamp2);
                dbHandler.Adduser (m1);

                Intent intent=new Intent(MainActivity.context, DisplayPdfActivity.class);
                startActivity(intent);
            }
        });

        viewReport.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dbHandler = new MyDbHelper(getContext ());
                //dbHandler.adduseract ( "DisplayVideoActivity", "", getDateTime () );
                // MyFav pro = new MyFav(name,url);
                model m2=new model();
                String from2 = m2.setFrom1 ( "HomeFragment" );
                String to2=m2.setTo1 ( "DisplayCovidActivity" );
                String timestamp2 =m2.setTimestamp ( getDateTime () );
                // model pro = new model(from2,to2,timestamp2);
                dbHandler.Adduser (m2);
                Intent intent=new Intent(MainActivity.context,DisplayCovidActivity.class);
                startActivity(intent);
            }

        });
/*
        viewStatewise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.context, ShowStates.class);
                startActivity(intent);
            }
        });
*/
        return root;
    }

}