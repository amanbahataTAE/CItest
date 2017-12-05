package com.example.aman1.mymovielist.views;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.aman1.mymovielist.R;
import com.example.aman1.mymovielist.model.Result_;
import com.example.aman1.mymovielist.model.moviedetail.MovieDetail;
import com.example.aman1.mymovielist.services.RequestInterface;
import com.example.aman1.mymovielist.util.constants.API_LIST;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.example.aman1.mymovielist.services.ConnectionService.BackendService;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Movie_Detail extends Fragment {

    private RequestInterface requestInterface;
    private RecyclerView recyclerView;


    public Fragment_Movie_Detail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__movie__detail, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.rvSingleMovieDetail);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        requestInterface = BackendService();


        int  intig = 10;

        requestInterface.getMovieDetail(intig, API_LIST.API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<MovieDetail>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MovieDetail value) {

                        Log.i("SINGLEEEEE", value.getOriginalTitle());

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    public void initializeAdaptor(List<Result_> result){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MovieAdaptor(result, R.layout.rv_single_movie, getActivity()));
    }


}
