package com.example.munazamfyp.Adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.munazamfyp.AttendeeList;
import com.example.munazamfyp.Connections.AttendeesListConnection;
import com.example.munazamfyp.Connections.JoinMeetingConnection;
import com.example.munazamfyp.Connections.JoinedMeetingConnection;
import com.example.munazamfyp.DataModels.AttendeesModel;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.extendeditem;
import com.example.munazamfyp.R;

import java.util.List;

public class MeetingAdapter extends RecyclerView.Adapter<MeetingAdapter.MovieVH> {


    //helos from lotus
    int index;
    private static final String TAG = "MovieAdapter";
    List<extendeditem> movieList;
    Context cx;
    public MeetingAdapter(List<extendeditem> movieList, Context cs,int index)
    {
        cx = cs;
        this.movieList = movieList;
        this.index = index;
    }

    @NonNull
    @Override
    public MovieVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exampleitem, parent, false);
        return new MovieVH(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MovieVH holder, final int position) {

        extendeditem movie = movieList.get(position);

        holder.titleTextView.setText(movie.getTopic());
        holder.descriptionTextView.setText(movie.getDescription());
        holder.dateTextView.setText(movie.getDate());
        holder.timeTextView.setText(movie.getTime());
        holder.CapacityTextView.setText(movie.getCapacity());
        switch (index)
        {
            case 1:
                holder.joinmeeting.setText("Join Meeting");
                holder.joinmeeting.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        new JoinMeetingConnection(new AttendeesModel(1,1, Data.validid,Data.semester),cx).execute();
                    }
                });
                break;
            case 2:
                holder.joinmeeting.setText("View Attendees");
                holder.joinmeeting.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(cx, AttendeeList.class);
                        new AttendeesListConnection(cx).execute();
                        cx.startActivity(i);
                    }
                });
                break;
            case 3:
               holder.joinmeeting.setVisibility(View.GONE);
                break;
        }

        boolean isExpanded = movieList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);
    }
    @Override
    public int getItemCount()
    {
        return movieList.size();
    }


    class MovieVH extends RecyclerView.ViewHolder {


        ConstraintLayout expandableLayout;
        TextView titleTextView, dateTextView, timeTextView, descriptionTextView,CapacityTextView;
        Button joinmeeting;

        public MovieVH(@NonNull final View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            dateTextView = itemView.findViewById(R.id.yearTextView);
            timeTextView = itemView.findViewById(R.id.timetextview);
            descriptionTextView = itemView.findViewById(R.id.plotTextView);
            CapacityTextView=itemView.findViewById(R.id.capacityTextView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            joinmeeting = itemView.findViewById(R.id.button16);

            titleTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    extendeditem movie = movieList.get(getAdapterPosition());
                    movie.setExpanded(!movie.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }
}
