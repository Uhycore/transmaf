package com.example.transmaf;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transmaf.R;
import com.example.transmaf.adapter.CarAdapter;
import com.example.transmaf.model.Car;
import com.example.transmaf.network.ApiClient;
import com.example.transmaf.network.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {

    private static final String TAG = "DashboardFragment";

    private RecyclerView rvCars;
    private CarAdapter carAdapter;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        rvCars = view.findViewById(R.id.rvCars);
        rvCars.setLayoutManager(new LinearLayoutManager(getContext()));
        carAdapter = new CarAdapter(getContext());
        rvCars.setAdapter(carAdapter);

        loadCars();

        return view;
    }

    private void loadCars() {
        ApiService apiService = ApiClient.getService();
        Call<List<Car>> call = apiService.getAllCars();

        call.enqueue(new Callback<List<Car>>() {
            @Override
            public void onResponse(@NonNull Call<List<Car>> call,
                                   @NonNull Response<List<Car>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Car> carList = response.body();
                    carAdapter.setData(carList);

                    Log.d(TAG, "Total cars: " + carList.size());
                } else {
                    if (getContext() != null) {
                        Toast.makeText(getContext(),
                                "Gagal mengambil data: " + response.code(),
                                Toast.LENGTH_SHORT).show();
                    }
                    Log.e(TAG, "Response error: " + response.code());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Car>> call,
                                  @NonNull Throwable t) {
                if (getContext() != null) {
                    Toast.makeText(getContext(),
                            "Error: " + t.getMessage(),
                            Toast.LENGTH_SHORT).show();
                }
                Log.e(TAG, "onFailure: ", t);
            }
        });
    }
}
