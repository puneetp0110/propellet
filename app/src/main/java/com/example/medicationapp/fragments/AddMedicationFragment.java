package com.example.medicationapp.fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.medicationapp.R;
import com.example.medicationapp.activities.HomeActivity;
import com.example.medicationapp.database.DataBaseHelper;
import com.example.medicationapp.model.DataBaseNote;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddMedicationFragment.OnAddMedicationFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddMedicationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddMedicationFragment extends Fragment{

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private OnAddMedicationFragmentInteractionListener mListener;
    Button addMedicationBtn;
    EditText medicationNameText;
    EditText datePickerText;
    Activity activity;
    DataBaseHelper db;
    String date;
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
        datePickerText= (EditText)v.findViewById(R.id.datePickerText);
        datePickerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getActivity(),android.R.style.Theme_Material_Dialog_NoActionBar_MinWidth,mDateSetListener,year,month,day);

                dialog.show();
            }
        });


        addMedicationBtn =(Button)v.findViewById(R.id.addMedicationBtn);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        addMedicationBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                String descriptionTypeText = db.isFieldExist(DataBaseNote.DESCRIPTION_NAME,medicationNameText.getText().toString());

                if( medicationNameText.getText().toString().trim().equals("") || datePickerText.getText().toString().trim().equals("") || descriptionTypeText.equals("N/A") )
                {
                    alertDialogBuilder.setMessage("Something went Wrong").setCancelable(true);
                    AlertDialog alert = alertDialogBuilder.create();
                    alert.setTitle("Opps!!!");
                    alert.show();
                } else {
                    db.insertNode(medicationNameText.getText().toString(), datePickerText.getText().toString(),descriptionTypeText);
                    if(activity instanceof HomeActivity){
                        HomeActivity homeActivity = (HomeActivity) activity;
                        homeActivity.loadFragment(new MainFragment());
                    }
                }
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month++;

                date = year+"-"+(month<=9 ? "0"+month:month)+"-"+(day<=9 ? "0"+day:day);
                datePickerText.setText(date);
            }
        };

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
