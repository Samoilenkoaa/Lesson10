package com.example.lesson10.notedetails;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.lesson10.NoteDataClass;
import com.example.lesson10.R;


public class DetaileFragment extends Fragment {
    private TextView name;
    private TextView description;
    private TextView date;
    private Button buttonEdit;
    private boolean isLand;


    public static DetaileFragment newInstance(NoteDataClass note) {
        DetaileFragment fragment = new DetaileFragment();
        if(note != null) {
            Bundle args = new Bundle();
            args.putSerializable("note", note);
            fragment.setArguments(args);
        }

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        isLand = getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detaile, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        name = view.findViewById(R.id.name);
        description = view.findViewById(R.id.description);
        date = view.findViewById(R.id.date);
        buttonEdit = view.findViewById(R.id.button_save);

        buttonEdit.setOnClickListener(v -> {
            if (!isLand) {
                FragmentTransaction fragmentTr = getActivity().getSupportFragmentManager().beginTransaction();
                EditFragment fragment = EditFragment.newInstance((NoteDataClass) getArguments().getSerializable("note"));
//                fragmentTr.addToBackStack("");
                fragmentTr.replace(R.id.Fr_container, fragment);
                fragmentTr.commit();
            } else {
                FragmentTransaction fragmentTr = getActivity().getSupportFragmentManager().beginTransaction();
                getActivity().findViewById(R.id.Fr_container2).setVisibility(View.VISIBLE);
                EditFragment fragment = EditFragment.newInstance((NoteDataClass) getArguments().getSerializable("note"));
                fragmentTr.replace(R.id.Fr_container2, fragment);
                fragmentTr.commit();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getArguments() != null) {
            NoteDataClass noteDataClass = (NoteDataClass) getArguments().getSerializable("note");
            name.setText(noteDataClass.getName());
            description.setText(noteDataClass.getDescription());
            date.setText(noteDataClass.getDate());
        }
    }
}