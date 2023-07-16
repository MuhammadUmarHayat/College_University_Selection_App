package com.example.fyp8july23;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AllNotificationsAdapter extends RecyclerView.Adapter<AllNotificationsAdapter.ViewHolder>
{
    private Context context;
    // public User_Applied(String user_cnic, String institute, String program, String status, String remarks
    private ArrayList user_cnic, institute,  program,status,  remarks;


    public AllNotificationsAdapter()
    {

    }

    public AllNotificationsAdapter(Context context, ArrayList user_cnic, ArrayList institute, ArrayList program, ArrayList status, ArrayList remarks)
    {
        this.context = context;
        this.user_cnic = user_cnic;
        this.institute = institute;
        this.program = program;
        this.status = status;
        this.remarks = remarks;
    }

    @NonNull
    @Override
    public AllNotificationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout and create the ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_notifications_layout, parent, false);
        return new AllNotificationsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllNotificationsAdapter.ViewHolder holder, int position) {
        //   public TextView tvCNIC1,tvInstituteName1,tvProgramApplied1,tvCurrentStatus1,tvRemarks1;
        //user_cnic, institute,  program,status,  remarks;
        holder.tvCNIC1.setText(String.valueOf(user_cnic.get(position)));
        holder.tvInstituteName1.setText(String.valueOf(institute.get(position)));
        holder.tvProgramApplied1.setText(String.valueOf(program.get(position)));
        holder.tvCurrentStatus1.setText(String.valueOf(status.get(position)));
        holder.tvRemarks1.setText(String.valueOf(remarks.get(position)));



    }

    @Override
    public int getItemCount()
    {
        return user_cnic.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tvCNIC1,tvInstituteName1,tvProgramApplied1,tvCurrentStatus1,tvRemarks1;
        View rootView;
        int position;
        //Institute ins;
        //tvCNIC,tvInstituteName,tvProgramApplied,tvCurrentStatus,tvRemarks
        public ViewHolder(View itemView) {
            super(itemView);
            tvCNIC1= itemView.findViewById(R.id.tvCNIC);
            tvInstituteName1 = itemView.findViewById(R.id.tvInstituteName);
            tvProgramApplied1 = itemView.findViewById(R.id.tvProgramApplied);
            tvCurrentStatus1 = itemView.findViewById(R.id.tvCurrentStatus);
            tvRemarks1 = itemView.findViewById(R.id.tvRemarks);


            rootView=itemView;

            itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {
                    Log.d("Demo","you have clicked on position"+" name: "+ tvCNIC1.getText().toString());
                    //  Toast.makeText(itemView.getContext(), "you have clicked on position name: "+ins.name,Toast.LENGTH_LONG).show();

                }
            });



        }
    }
}
