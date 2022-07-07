package com.example.pe_assignment.initialFragment.scan;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private final Application mDataSource;

    public MainViewModelFactory(Application dataSource) {
        mDataSource = dataSource;
    }

    @Override
    @NonNull
    public <T extends ViewModel>
    T create(@NonNull Class<T> modelClass) {
        Log.i("Test", "MainViewModelProviderFactory: ");
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            Log.i("Test", "create: is assignable");
            return (T) new MainViewModel(mDataSource);
        }
        //noinspection unchecked
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}