package com.example.fyp8july23;

import androidx.recyclerview.widget.RecyclerView;
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

public class AllCandidatesAdapter extends RecyclerView.Adapter<AllCandidatesAdapter.ViewHolder>
{
    private Context context;

    // public User_Applied(int id, String user_cnic,institute,program, status,remarks
    // String  String  String status, String remarks)
    private ArrayList id,  user_cnic,institute,program, status,remarks;


    public AllCandidatesAdapter()
    {

    }

    public AllCandidatesAdapter(Context context, ArrayList id, ArrayList user_cnic, ArrayList institute, ArrayList program, ArrayList status, ArrayList remarks)
    {
        this.context = context;
        this.id = id;
        this.user_cnic = user_cnic;
        this.institute = institute;
        this.program = program;
        this.status = status;
        this.remarks = remarks;
    }

    @NonNull
    @Override
    public AllCandidatesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item layout and create the ViewHolder
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.all_candidates_layout4, parent, false);
        return new AllCandidatesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AllCandidatesAdapter.ViewHolder holder, int position) {
        //user_cnic,institute,program, status,remarks;
        //   tvCandID1,tvCandProgram1,tvCandStatus1,tvCandRemarks1,tvCandidMgr1;
        holder.tvCandidMgr1.setText(String.valueOf(id.get(position)));
        holder.tvCandID1.setText(String.valueOf(user_cnic.get(position)));
        holder.tvCandname1.setText(String.valueOf(institute.get(position)));
        holder.tvCandProgram1.setText(String.valueOf(program.get(position)));
        holder.tvCandStatus1.setText(String.valueOf(status.get(position)));
        holder.tvCandRemarks1.setText(String.valueOf(remarks.get(position)));


    }

    @Override
    public int getItemCount()
    {
        return  id.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView tvCandname1,tvCandID1,tvCandProgram1,tvCandStatus1,tvCandRemarks1,tvCandidMgr1;
        View rootView;
        int position;
//        Institute ins;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCandname1= itemView.findViewById(R.id.tvCandname);
            tvCandID1 = itemView.findViewById(R.id.tvCandID);
            tvCandProgram1 = itemView.findViewById(R.id.tvCandProgram);
            tvCandStatus1 = itemView.findViewById(R.id.tvCandStatus);
            tvCandRemarks1 = itemView.findViewById(R.id.tvCandRemarks);
            tvCandidMgr1 = itemView.findViewById(R.id.tvCandidMgr);

            rootView=itemView;
//btnViewCandProfile,btnCandApproved,btnReject,btnCandBack
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("Demo","you have clicked on position"+" name: "+  tvCandidMgr1.getText().toString());
                    //  Toast.makeText(itemView.getContext(), "you have clicked on position name: "+ins.name,Toast.LENGTH_LONG).show();

                }
            });

            itemView.findViewById(R.id.btnCandApproved).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
//approve candidate
                    Context context= itemView.getContext();
                    String id=  tvCandidMgr1.getText().toString();
                    MyDBHelper db =new MyDBHelper(itemView.getContext()) ;
                    db.approveCandidate(id);


                    Intent intent = new Intent(itemView.getContext(), CandidateStatus.class);
                    intent.putExtra("CNIC", tvCandID1.getText().toString());
                    intent.putExtra("Message", " has been approved");
                    context.startActivity(intent);

                }


            });
            itemView.findViewById(R.id.btnReject).setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view) {

                    Context context= itemView.getContext();
                    String id=  tvCandidMgr1.getText().toString();
                    MyDBHelper db =new MyDBHelper(itemView.getContext()) ;
                    db.rejectCandidate(id);


                    Intent intent = new Intent(itemView.getContext(), CandidateStatus.class);
                    intent.putExtra("CNIC", tvCandID1.getText().toString());
                    intent.putExtra("Message", " has been rejected");
                    context.startActivity(intent);

                }


            });

//            itemView.findViewById(R.id.btnViewCandProfile).setOnClickListener(new View.OnClickListener()
//            {
//                @Override
//                public void onClick(View view)
//                {
//
//                    //view profile
//                    Context context= itemView.getContext();
//                    Intent intent = new Intent(itemView.getContext(), Manager.class);
//                    context.startActivity(intent);
//
//                }
//
//
//            });


        }
    }
}

