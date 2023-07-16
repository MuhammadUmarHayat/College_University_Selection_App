package com.example.fyp8july23;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllinstitutesAdapter extends RecyclerView.Adapter<AllinstitutesAdapter.ViewHolder>
{
    private Context context;
    private ArrayList id,name, medium, address, city,  link;


    public AllinstitutesAdapter()
    {

    }
    public AllinstitutesAdapter(Context context, ArrayList id, ArrayList name, ArrayList medium, ArrayList address, ArrayList city, ArrayList link)
    {
        this.context = context;
        this.id=id;
        this.name = name;
        this.medium = medium;
        this.address = address;
        this.city = city;
        this.link = link;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout and create the ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_institute_layout2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //name, medium, address, city,  link
        holder.tvid1.setText(String.valueOf(id.get(position)));
        holder.tvname1.setText(String.valueOf(name.get(position)));
        holder.tvmedium1.setText(String.valueOf(medium.get(position)));
        holder.tvaddress1.setText(String.valueOf(address.get(position)));
        holder.tvcity1.setText(String.valueOf(city.get(position)));
        holder.tvlink1.setText(String.valueOf(link.get(position)));


    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tvid1,tvname1, tvmedium1, tvaddress1, tvcity1,  tvlink1;
        View rootView;
        int position;
       // Institute ins;

        public ViewHolder(View itemView) {
            super(itemView);
            tvid1= itemView.findViewById(R.id.tvInsid1);
            tvname1 = itemView.findViewById(R.id.tvname12);
            tvmedium1 = itemView.findViewById(R.id.tvmedium12);
            tvaddress1 = itemView.findViewById(R.id.tvaddress12);
            tvcity1 = itemView.findViewById(R.id.tvcity12);
            tvlink1 = itemView.findViewById(R.id.tvlink12);

            rootView=itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("Demo","you have clicked on position"+" name: "+tvname1.getText().toString());
                    //  Toast.makeText(itemView.getContext(), "you have clicked on position name: "+ins.name,Toast.LENGTH_LONG).show();

                }
            });

            itemView.findViewById(R.id.btnDeleteInsMgr).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {

                    Context context= itemView.getContext();
                    String id=tvid1.getText().toString();
                    MyDBHelper db =new MyDBHelper(itemView.getContext()) ;
                    db.delete("institutes","id",id);


                    Intent intent = new Intent(itemView.getContext(), DeleteInstetute.class);
                    intent.putExtra("instituteName", tvname1.getText().toString());
                    intent.putExtra("Message", "Record is deleted");
                    context.startActivity(intent);

                }


            });
            itemView.findViewById(R.id.btnEditInsMgr).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {

                    String id=tvid1.getText().toString();

                    Context context= itemView.getContext();
                    Intent intent = new Intent(itemView.getContext(), EditInstitute.class);
                    intent.putExtra("instituteID", id);

                    context.startActivity(intent);

                }


            });


        }
    }
}
