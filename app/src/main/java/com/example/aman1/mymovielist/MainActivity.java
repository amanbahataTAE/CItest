package com.example.aman1.mymovielist;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.aman1.mymovielist.model.Result;
import com.example.aman1.mymovielist.model.Result_;
import com.example.aman1.mymovielist.services.RequestInterface;
import com.example.aman1.mymovielist.util.constants.API_LIST;
import com.example.aman1.mymovielist.views.Fragment_MoviesList;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.aman1.mymovielist.services.ConnectionService.BackendService;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private static final String TAG = "Main Activity";

 //   CompositeDisposable compositeDisposible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        if (savedInstanceState == null){
            fragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, new Fragment_MoviesList())
                    .commit();
        }


    }


}
