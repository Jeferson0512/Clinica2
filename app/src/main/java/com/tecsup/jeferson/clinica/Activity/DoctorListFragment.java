package com.tecsup.jeferson.clinica.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tecsup.jeferson.clinica.Adapter.DoctorAdapter;
import com.tecsup.jeferson.clinica.Model.Medicos;
import com.tecsup.jeferson.clinica.R;
import com.tecsup.jeferson.clinica.Service.ApiService;
import com.tecsup.jeferson.clinica.Service.ApiServiceGenerator;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Usuario on 21/11/2017.
 */

public class DoctorListFragment extends Fragment {

    private static final String TAG = DoctorListFragment.class.getSimpleName();
    private RecyclerView doctorRecycler;
    private DoctorAdapter adapter;
    private LinearLayoutManager manager;


    public DoctorListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v=inflater.inflate(R.layout.fragment_doctor_list, container, false);
        // Inflate the layout for this fragment
        doctorRecycler=v.findViewById(R.id.recicler_doctor);
        manager=new LinearLayoutManager(getContext());
        doctorRecycler.setLayoutManager(manager);
        doctorRecycler.setAdapter(new DoctorAdapter(getContext()));
        getDoctorList();
        return v;
    }

    private void getDoctorList(){
        ApiService service= ApiServiceGenerator.createService(ApiService.class);
        Call<List<Medicos>> call=service.getMedicos();

        call.enqueue(new Callback<List<Medicos>>() {
            @Override
            public void onResponse(Call<List<Medicos>> call, Response<List<Medicos>> response) {
                try {
                    int statusCode = response.code();
                    Log.d(TAG, "HTTP status code: " + statusCode);

                    if (response.isSuccessful()) {

                        List<Medicos> medicos = response.body();
                        Log.d(TAG, "medicos: " + medicos);

                        DoctorAdapter adapter = (DoctorAdapter) doctorRecycler.getAdapter();
                        adapter.setLista(medicos);
                        adapter.notifyDataSetChanged();

                    } else {
                        Log.e(TAG, "onError: " + response.errorBody().string());
                        throw new Exception("Error en el servicio");
                    }

                } catch (Throwable t) {
                    try {
                        Log.e(TAG, "onThrowable: " + t.toString(), t);
                        Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    } catch (Throwable x) {
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Medicos>> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.toString());
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

}
