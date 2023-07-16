package com.example.fyp8july23;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProgramsAdapter extends RecyclerView.Adapter<ProgramsAdapter.ViewHolder>
{
    private Context context;
    private ArrayList id,prorgram, duration, semester_name, starting_date,  closing_date,institute;


    public ProgramsAdapter()

    {

    }
    //id,prorgram, duration, semester_name, starting_date,  closing_date,institute
    public ProgramsAdapter(Context context,ArrayList id,ArrayList prorgram,ArrayList duration,ArrayList semester_name,ArrayList starting_date,ArrayList  closing_date,ArrayList institute)
    {
        this.context = context;
        this.id=id;
        this.prorgram = prorgram;
        this.duration = duration;
        this.semester_name = semester_name;
        this.starting_date = starting_date;
        this.closing_date = closing_date;
        this.institute=institute;

    }


    @NonNull
    @Override
    public ProgramsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout and create the ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_programs_layout2, parent, false);
        return new ProgramsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgramsAdapter.ViewHolder holder, int position) {

        holder.tvid1.setText(String.valueOf(id.get(position)));
        holder.tvprorgram1.setText(String.valueOf(prorgram.get(position)));
        holder.tvduration1.setText(String.valueOf(duration.get(position)));
        holder.tvsemester_name1.setText(String.valueOf(semester_name.get(position)));
        holder.tvstarting_date1.setText(String.valueOf(starting_date.get(position)));
        holder.tvclosing_date1.setText(String.valueOf(closing_date.get(position)));
        holder.tvinstitute1.setText(String.valueOf(institute.get(position)));


    }

    @Override
    public int getItemCount() {
        return id.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tvid1,tvprorgram1,tvduration1, tvsemester_name1, tvstarting_date1,  tvclosing_date1,tvinstitute1;
        View rootView;
        int position;
        //Institute ins;

        public ViewHolder(View itemView) {
            super(itemView);
            tvid1= itemView.findViewById(R.id.tvInsid1);
            tvprorgram1 = itemView.findViewById(R.id.tvprorgram);
            tvduration1 = itemView.findViewById(R.id.tvduration);
            tvsemester_name1 = itemView.findViewById(R.id.tvsemester_name);
            tvstarting_date1 = itemView.findViewById(R.id.tvstarting_date);
            tvclosing_date1 = itemView.findViewById(R.id. tvclosing_date);
            tvinstitute1 = itemView.findViewById(R.id.tvinstituteprg );

            rootView=itemView;
//97,47,16
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("Demo","you have clicked on position"+" name: "+tvid1.getText().toString());
                    //  Toast.makeText(itemView.getContext(), "you have clicked on position name: "+ins.name,Toast.LENGTH_LONG).show();

                }
            });

            itemView.findViewById(R.id.btnApply).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {

                    Context context= itemView.getContext();
                    String id=tvid1.getText().toString();
                    //    MyDBHelper db =new MyDBHelper(itemView.getContext()) ;
                    //   db.delete("programs_table","id",id);


                    Intent intent = new Intent(itemView.getContext(), AdmissionRequest.class);
                    intent.putExtra("ProgramID", tvid1.getText().toString());
                    context.startActivity(intent);
                    context.startActivity(intent);

                }


            });


        }
    }
}
