package com.example.livedataexampleiwmstudio.viewmodels;

import android.content.Context;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.livedataexampleiwmstudio.BR;
import com.example.livedataexampleiwmstudio.adapters.UserAdapter;
import com.example.livedataexampleiwmstudio.models.User;

import java.util.ArrayList;

public class UserViewModel extends BaseObservable {

    private MutableLiveData<ArrayList<UserViewModel>> arrayListMutableLiveData=new MutableLiveData<>();
    private ArrayList<UserViewModel> arrayListHolder=new ArrayList<>();

    private String name;
    private String phone;
    Context context;

    public UserViewModel(Context context) {
        this.context = context;

        //connect to server API

        for (int i = 0; i <5 ; i++) {
            User user =new User("www.google.com"+i,String.valueOf(i));
            UserViewModel userViewModel=new UserViewModel(user);
            arrayListHolder.add(userViewModel);
        }
        arrayListMutableLiveData.setValue(arrayListHolder);

    }

    public UserViewModel(User user) {
        this.name = user.getName();
        this.phone = user.getPhone();

    }

   @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;

        notifyPropertyChanged(BR.phone);
    }

    @BindingAdapter("bind:recyclerUser")
    public static void recyclerviewBinder(RecyclerView recyclerView,MutableLiveData<ArrayList<UserViewModel>> arrayListMutableLiveData){


        arrayListMutableLiveData.observe((LifecycleOwner) recyclerView.getContext(), new Observer<ArrayList<UserViewModel>>() {
            @Override
            public void onChanged(ArrayList<UserViewModel> userViewModels) {
                Log.i("", "onChanged: "+userViewModels.toString());

                UserAdapter userAdapter=new UserAdapter(userViewModels);
                recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL,false));
                recyclerView.setAdapter(userAdapter);
            }
        });


    }

    public MutableLiveData<ArrayList<UserViewModel>> getArrayListMutableLiveData() {
        return arrayListMutableLiveData;
    }
}
