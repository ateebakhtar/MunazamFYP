package com.example.munazamfyp.Fragments;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.munazamfyp.Connections.EditAccountConnection;
import com.example.munazamfyp.DataModels.Data;
import com.example.munazamfyp.DataModels.WorkloadViewModel;
import com.example.munazamfyp.DataModels.PageViewModel;
import com.example.munazamfyp.DataModels.UserData;
import com.example.munazamfyp.Login;
import com.example.munazamfyp.R;

import java.util.ArrayList;

public class UserInformation extends Fragment {
    ArrayList<WorkloadViewModel> list1 = new ArrayList<>();

    UserInformation() {

    }


    public static com.example.munazamfyp.Fragments.UserInformation newInstance() {
        return new com.example.munazamfyp.Fragments.UserInformation();
    }


    private Button B;
    private Button edit;
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

        edit = root.findViewById(R.id.button12);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openedit(root);
            }
        });

        B = root.findViewById(R.id.logout);
        B.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlogin();
            }
        });
        return root;
    }

    public void openedit(final View view)
    {
        LayoutInflater li = LayoutInflater.from(view.getContext());
        View promptsView = li.inflate(R.layout.editaccountpromt, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(view.getContext());
        alertDialogBuilder.setView(promptsView);
        alertDialogBuilder.setTitle("Edit Account");
        final EditText nam = promptsView.findViewById(R.id.editText9);
        final EditText pass = promptsView.findViewById(R.id.editText11);
        if(nam.getText().toString().length() < 3 || nam.getText().toString() == null)
        {
            nam.setError("Please Enter a Valid Name of size 3 or more");
            nam.requestFocus();
        }
        else if(pass.getText().toString().length() < 8 || pass.getText().toString() == null)
        {
            pass.setError("Please Enter a Valid Password of size 8 or more");
            pass.requestFocus();
        }
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("Update",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id)
                            {
                                String name = nam.getText().toString();

                                String pass1 = pass.getText().toString();
                                if(name.length() >= 3 && pass1.length() >=8)
                                {
                                    System.out.println("values ---- "+Data.status);
                                    new EditAccountConnection(Data.status,name,pass1).execute();
                                    Intent i = new Intent(view.getContext(),Login.class);
                                    view.getContext().startActivity(i);
                                }
                                else
                                {
                                    Toast.makeText(view.getContext(), "Incorrect Length of Password or Username", Toast.LENGTH_SHORT).show();
                                }


                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();



    }
    public void openlogin() {
        Intent i = new Intent(root.getContext(), Login.class);
        UserData.name = null;
        startActivity(i);
    }
}