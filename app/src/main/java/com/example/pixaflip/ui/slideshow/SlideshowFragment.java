package com.example.pixaflip.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pixaflip.ItemClickLester;
import com.example.pixaflip.R;
import com.example.pixaflip.sql.Fav;
import com.example.pixaflip.sql.MyDbHelper;
import com.example.pixaflip.ui.Favourite.FavAdapter;

import java.util.List;

public class SlideshowFragment extends Fragment {

    public static List<Fav> list;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.recyclerViewfav);

        MyDbHelper db = new MyDbHelper(getActivity());
        final List<Fav> list = db.getAll();


//        list.add(new SlideshowViewModel("Stories ","https://www.bartleby.com/ebook/adobe/3134.pdf"));
//        list.add(new SlideshowViewModel("C++ ", "https://www.tutorialspoint.com/cplusplus/cpp_tutorial.pdf"));
//        list.add(new SlideshowViewModel("Java ","https://www.tutorialspoint.com/java/java_tutorial.pdf"));
//        list.add(new SlideshowViewModel("DSA ","https://www.tutorialspoint.com/data_structures_algorithms/data_structures_algorithms_tutorial.pdf"));
//        list.add(new SlideshowViewModel("Python ","http://tdc-www.harvard.edu/Python.pdf"));

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ItemClickLester itemClickListener = new ItemClickLester() {
            @Override
            public void onClick(View view, int position, boolean isLongClick) {
                Intent intent = new Intent(getActivity().getApplication(),Fav.class);
                intent.putExtra("url",list.get(position).getUrl());
                //intent.putExtra("position",position);
                startActivity(intent);
            }
        };
        FavAdapter adapter = new FavAdapter(list,getActivity(),itemClickListener);
        recyclerView.setAdapter(adapter);



        return root;
    }
}
