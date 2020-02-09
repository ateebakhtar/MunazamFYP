package com.example.munazamfyp.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.munazamfyp.DataModels.extendeditem;
import com.example.munazamfyp.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MovieVH> {


    private static final String TAG = "MovieAdapter";
    List<extendeditem> movieList;

    public RecyclerAdapter(List<extendeditem> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exampleitem, parent, false);
        return new MovieVH(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MovieVH holder, int position) {

        extendeditem movie = movieList.get(position);


        //holder.
        holder.titleTextView.setText(movie.getTopic());
        holder.descriptionTextView.setText(movie.getDescription());
        holder.dateTextView.setText(movie.getDate());
        holder.timeTextView.setText(movie.getTime());
        holder.CapacityTextView.setText(movie.getCapacity());


        boolean isExpanded = movieList.get(position).isExpanded();
        holder.expandableLayout.setVisibility(isExpanded ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieVH extends RecyclerView.ViewHolder {

        private static final String TAG = "MovieVH";

        ConstraintLayout expandableLayout;
        TextView titleTextView, dateTextView, timeTextView, descriptionTextView,CapacityTextView;

        public MovieVH(@NonNull final View itemView) {
            super(itemView);

            titleTextView = itemView.findViewById(R.id.titleTextView);
            dateTextView = itemView.findViewById(R.id.yearTextView);
            timeTextView = itemView.findViewById(R.id.timetextview);
            descriptionTextView = itemView.findViewById(R.id.plotTextView);
            CapacityTextView=itemView.findViewById(R.id.capacityTextView);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);


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
