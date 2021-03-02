package com.example.pixaflip;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
   private List<CovidData> covidDataList;
    private Context context;
    private LayoutInflater inflater;

    public MyAdapter(List<CovidData> covidDataList, Context context) {
        this.covidDataList = covidDataList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rowlayot,parent,false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        CovidData covidDatalist = covidDataList.get(position);
        holder.Tv.setText("Locality : "+covidDatalist.getLoc());
        holder.Tv1.setText("Confirmed cases Indian : "+covidDatalist.getConInd());

        holder.text.setText("Confirmed cases Foreign: "+covidDatalist.getConFor());

        holder.Discharged.setText("Discharged : "+covidDatalist.getDischarge());
        holder.Death.setText("Death : "+covidDatalist.getDeath());
        holder.Total.setText("Total: "+covidDatalist.getTotalCon());

    }

    @Override
    public int getItemCount() {
        return covidDataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView Tv;
        public TextView Tv1;
        public TextView text,Discharged,Death,Total;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Tv = (TextView) itemView.findViewById(R.id.Tv);
            Tv1 =(TextView) itemView.findViewById(R.id.Tv1);
            text =(TextView) itemView.findViewById(R.id.Tv2);
            Discharged = itemView.findViewById(R.id.Tv3);
            Death = itemView.findViewById(R.id.Tv4);
            Total = itemView.findViewById(R.id.Tv5);


        }
    }
}

   /* ArrayList<ListItem> list;
        //ArrayList<String> ;
       // ArrayList<String> mobileNumbers;
        Context context;

public MyAdapter(List<CovidData> covidDataList, Context applicationContext) {
        this.context = context;
        this.covidDatalist = this.covidDatalist;
       // this.emailIds = emailIds;
        //this.mobileNumbers = mobileNumbers;
        }

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayot, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
        }

@Override
public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        CovidData list = list.get(position);
        holder..setText(list.get(position));
        //holder.email.setText(emailIds.get(position));
       // holder.mobileNo.setText(mobileNumbers.get(position));
        // implement setOnClickListener event on item view.
        holder.itemView.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
        // display a toast with person name on item click
        Toast.makeText(context, (CharSequence) list.get(position), Toast.LENGTH_SHORT).show();
        }
        });

        }


@Override
public int getItemCount() {
        return list.size();
        }

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView Loc,Indian;//email, mobileNo;// init the item view's

    public MyViewHolder(View itemView) {
        super(itemView);

        Loc = itemView.findViewById(R.id.Tv);
        Indian = itemView.findViewById(R.id.Tv1);
          //  Foreign = itemView.findViewById(R.id.Tv2);
            //Discharged = itemView.findViewById(R.id.Tv3);
            //Death = itemView.findViewById(R.id.Tv4);
            //Total = itemView.findViewById(R.id.Tv5);

        }
    }
}


*/