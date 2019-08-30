package com.example.medicationapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.medicationapp.R;
import com.example.medicationapp.activities.HomeActivity;
import com.example.medicationapp.database.DataBaseHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddMedicationFragment.OnAddMedicationFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddMedicationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddMedicationFragment extends Fragment {

    private OnAddMedicationFragmentInteractionListener mListener;
    Button addMedicationBtn;
    EditText medicationNameText;
    EditText medicationTypeText;
    Activity activity;
    DataBaseHelper db;
    public AddMedicationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AddMedicationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddMedicationFragment newInstance() {
        AddMedicationFragment fragment = new AddMedicationFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return View
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_add_medication, container, false);
        activity = (HomeActivity)getActivity();
        if(activity instanceof HomeActivity){
            HomeActivity homeActivity = (HomeActivity) activity;
            db=homeActivity.getDb();
        }
        medicationNameText = (EditText)v.findViewById(R.id.medicationNameText);
        medicationTypeText= (EditText)v.findViewById(R.id.medicationTypeText);
        addMedicationBtn =(Button)v.findViewById(R.id.addMedicationBtn);
        addMedicationBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if( medicationNameText.getText().toString().trim().equals("") || medicationTypeText.getText().toString().trim().equals("") )
                {

                } else {
                    String pattern = "yyyy-MM-dd";
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                    String date = simpleDateFormat.format(new Date());
                    db.insertNode(medicationNameText.getText().toString(), date,medicationTypeText.getText().toString());
                    if(activity instanceof HomeActivity){
                        HomeActivity homeActivity = (HomeActivity) activity;
                        homeActivity.loadFragment(new MainFragment());
                    }
                }
            }
        });
        return v;
    }

    /**
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnAddMedicationFragmentInteractionListener) {
            mListener = (OnAddMedicationFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    /**
     *
     */
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnAddMedicationFragmentInteractionListener {
        // TODO: Update argument type and name
        void onAddMedicationFragmentInteraction(Uri uri);
    }
}
