package com.example.medicationapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.icu.text.Edits;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.medicationapp.R;
import com.example.medicationapp.activities.HomeActivity;
import com.example.medicationapp.activities.SplashActivity;
import com.example.medicationapp.adapters.MedicationsDetailsViewAdapter;
import com.example.medicationapp.database.DataBaseHelper;
import com.example.medicationapp.model.DataBaseNote;
import com.example.medicationapp.model.Medications;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MedicationDetailsFragment.OnMedicationDetailsFragmentListener} interface
 * to handle interaction events.
 * Use the {@link MedicationDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MedicationDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match


    private OnMedicationDetailsFragmentListener mListener;

    private Activity activity;

    private DataBaseHelper db;

    public MedicationDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment MedicationDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MedicationDetailsFragment newInstance() {
        MedicationDetailsFragment fragment = new MedicationDetailsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return View so that data can be rendered on screen.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_medication_details, container, false);
        activity = (HomeActivity)getActivity();
        if(activity instanceof HomeActivity){
            HomeActivity homeActivity = (HomeActivity) activity;
            db=homeActivity.getDb();
        }
        /**
         * RecyclerView for loading dynamic data on view.
         */
        RecyclerView recyclerView = v.findViewById(R.id.recyclerMedication);
        recyclerView.setHasFixedSize(true);
        ArrayList<Medications> medicationsList = new ArrayList<>();
        List<DataBaseNote> list = db.getAllDataBaseNote();
        for(int i=0; i<list.size();++i){
            medicationsList.add(new Medications(list.get(i).getId(),list.get(i).getName(),list.get(i).getTypeDescription(),list.get(i).getTimestamp().substring(0,10)));
        }
        MedicationsDetailsViewAdapter medicationsDetailsViewAdapter = new MedicationsDetailsViewAdapter(medicationsList);
        recyclerView.setAdapter(medicationsDetailsViewAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        return v;
    }

    /**
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnMedicationDetailsFragmentListener) {
            mListener = (OnMedicationDetailsFragmentListener) context;
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
    public interface OnMedicationDetailsFragmentListener {
        // TODO: Update argument type and name
        void onMedicationDetailsFragmentInteraction(Uri uri);
    }
}
