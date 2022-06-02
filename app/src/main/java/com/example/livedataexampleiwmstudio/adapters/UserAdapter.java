package com.example.livedataexampleiwmstudio.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.livedataexampleiwmstudio.R;
import com.example.livedataexampleiwmstudio.databinding.ItemUserBinding;
import com.example.livedataexampleiwmstudio.viewmodels.UserViewModel;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.CustomHolder> {

    private ArrayList<UserViewModel> arrayList=new ArrayList<UserViewModel>();
    private LayoutInflater layoutInflater ;

    public UserAdapter(ArrayList<UserViewModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public CustomHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (layoutInflater==null)
        layoutInflater=LayoutInflater.from(parent.getContext());


        ItemUserBinding userBinding= DataBindingUtil
                .inflate(layoutInflater, R.layout.item_user,parent,false);
        return new CustomHolder(userBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomHolder holder, int position) {

        UserViewModel userViewModel=arrayList.get(position);
        holder.bindUserViewModel(userViewModel);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class CustomHolder extends RecyclerView.ViewHolder {

        private ItemUserBinding itemUserBinding;

        public CustomHolder(@NonNull ItemUserBinding itemUserBinding) {
            super(itemUserBinding.getRoot());
            this.itemUserBinding=itemUserBinding;
        }

        public void bindUserViewModel(UserViewModel userViewModel){
            this.itemUserBinding.setUserViewModelItem(userViewModel);
            this.itemUserBinding.executePendingBindings();
        }

        public ItemUserBinding getItemUserBinding() {
            return itemUserBinding;
        }
    }
}
