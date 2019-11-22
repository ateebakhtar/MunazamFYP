package com.example.munazamfyp.Fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.munazamfyp.Adapters.ReminderAdapter;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.Example_item;
import com.example.munazamfyp.DataModels.PageViewModel;
import com.example.munazamfyp.DataModels.ReminderModel;
import com.example.munazamfyp.DataModels.UserData;
import com.example.munazamfyp.Login;
import com.example.munazamfyp.R;

import java.util.ArrayList;

public class UserInformation extends Fragment {
    ArrayList<Example_item> list1 = new ArrayList<>();

    UserInformation() {

    }


    public static com.example.munazamfyp.Fragments.UserInformation newInstance() {
        return new com.example.munazamfyp.Fragments.UserInformation();
    }


    private Button B;
    private PageViewModel pageViewModel;
    View root;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.setIndex("Reminder");


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.activity_user_information, container, false);

        B = root.findViewById(R.id.logout);


        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();
            }
        });

        return root;
    }

    public void openlogin() {
        Intent i = new Intent(root.getContext(), Login.class);
        UserData.name = null;
        startActivity(i);
    }
}