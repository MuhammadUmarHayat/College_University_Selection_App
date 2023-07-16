package com.example.fyp8july23;


import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class InstituteAdapter extends RecyclerView.Adapter<InstituteAdapter.ViewHolder>
{
    private Context context;
    private ArrayList id,name, medium, address, city,  link;
    private List<ImageModel> imageList;

    public InstituteAdapter(Context context, ArrayList id, ArrayList name, ArrayList medium, ArrayList address, ArrayList city, ArrayList link, List<ImageModel> imageList) {
        this.context = context;
        this.id = id;
        this.name = name;
        this.medium = medium;
        this.address = address;
        this.city = city;
        this.link = link;
        this.imageList = imageList;
    }

    public InstituteAdapter(ArrayList id, ArrayList name, ArrayList medium, ArrayList address, ArrayList city, ArrayList link, List<ImageModel> imageList)
    {

        this.id = id;
        this.name = name;
        this.medium = medium;
        this.address = address;
        this.city = city;
        this.link = link;
        this.imageList = imageList;
    }

    public InstituteAdapter()
    {

    }
    public InstituteAdapter(Context context, ArrayList id, ArrayList name, ArrayList medium, ArrayList address, ArrayList city, ArrayList link)
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
    public InstituteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout and create the ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_institute_layout3, parent, false);
        return new InstituteAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstituteAdapter.ViewHolder holder, int position)
    {
        //name, medium, address, city,  link
        holder.tvid1.setText(String.valueOf(id.get(position)));
        holder.tvname1.setText(String.valueOf(name.get(position)));
        holder.tvmedium1.setText(String.valueOf(medium.get(position)));
        holder.tvaddress1.setText(String.valueOf(address.get(position)));
        holder.tvcity1.setText(String.valueOf(city.get(position)));
        holder.tvlink1.setText(String.valueOf(link.get(position)));
        ImageModel imageModel = imageList.get(position);
        holder.imageView.setImageBitmap(imageModel.getImage());


    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tvid1,tvname1, tvmedium1, tvaddress1, tvcity1,  tvlink1;
        ImageView imageView;
        View rootView;
        int position;
//        Institute ins;

        public ViewHolder(View itemView) {
            //tvname123,tvmedium123,tvaddress123,tvcity123,tvlink12
            super(itemView);
            tvid1= itemView.findViewById(R.id.tvInsid13);
            tvname1 = itemView.findViewById(R.id.tvname123);
            tvmedium1 = itemView.findViewById(R.id.tvmedium123);
            tvaddress1 = itemView.findViewById(R.id.tvaddress123);
            tvcity1 = itemView.findViewById(R.id.tvcity123);
            tvlink1 = itemView.findViewById(R.id.tvlink123);//
            imageView= itemView.findViewById(R.id.imageView);
            rootView=itemView;

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    Log.d("Demo","you have clicked on position"+" name: "+tvname1.getText().toString());
                    //  Toast.makeText(itemView.getContext(), "you have clicked on position name: "+ins.name,Toast.LENGTH_LONG).show();

                }
            });



        }
    }
}
