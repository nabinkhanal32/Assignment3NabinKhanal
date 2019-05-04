package Adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignment_3nabinkhanal.Dashboard_Activity;
import com.example.assignment_3nabinkhanal.ItamAdd_activity;
import com.example.assignment_3nabinkhanal.ItemDescriptionActivity;
import com.example.assignment_3nabinkhanal.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterClothes extends RecyclerView.Adapter<AdapterClothes.ClothViewHolder>{
    Context mContext;
    List<Cloth> clothList;

    public AdapterClothes(Dashboard_Activity dashboard_activity, List<Cloth> clothlist) {
        this.mContext = mContext;
        this.clothList = clothlist;


    }
    @NonNull
    @Override
    public ClothViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemlist, viewGroup, false);
        return new ClothViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClothViewHolder clothViewHolder, int i) {
        final Cloth contacts = clothList.get(i);
        clothViewHolder.imgProfile.setImageResource(contacts.getImage());
        clothViewHolder.tvName.setText(contacts.getName());
        clothViewHolder.tvPrice.setText(contacts.getPrice());

        clothViewHolder.imgProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ItemDescriptionActivity.class);
                intent.putExtra("image",contacts.getImage());
                intent.putExtra("name",contacts.getName());
                intent.putExtra("price",contacts.getPrice());
                intent.putExtra("Description",contacts.getDesc());
                mContext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return clothList.size();
    }



    public class ClothViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imgProfile;
        TextView tvName, tvPrice;
        public ClothViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProfile = itemView.findViewById(R.id.imgProfile);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }
}