package com.example.pe_assignment.initialFragment.scan;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private HistoryRepository mRepository;
    private final MutableLiveData<List<History>> mAllHistories;

    public MainViewModel(Application application) {
        super(application);
        mRepository = new HistoryRepository(application);
        mAllHistories = mRepository.getAllHistories();
    }

    MutableLiveData<List<History>> getAllHistories() {
        return mAllHistories;
    }

    void insert(History history) {
        mRepository.insert(history);
    }

}
