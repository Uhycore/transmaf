package com.example.transmaf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.transmaf.R;
import com.example.transmaf.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private Context context;
    private List<Car> carList = new ArrayList<>();

    public CarAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<Car> cars) {
        this.carList = cars;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_car, parent, false);
        return new CarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {
        Car car = carList.get(position);

        holder.tvCarName.setText(car.getName());
        holder.tvPlateNumber.setText(car.getPlateNumber());
        holder.tvDescription.setText(
                car.getDescription() != null ? car.getDescription() : "Tidak ada deskripsi"
        );

    }

    @Override
    public int getItemCount() {
        return carList != null ? carList.size() : 0;
    }

    public static class CarViewHolder extends RecyclerView.ViewHolder {

        TextView tvCarName, tvPlateNumber, tvDescription;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCarName = itemView.findViewById(R.id.tvCarName);
            tvPlateNumber = itemView.findViewById(R.id.tvPlateNumber);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }
    }
}
