package com.example.lee.movie;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private DatabaseReference mDatabase;
    private ListView mListView;

    private List<Card> arrayList = new ArrayList<Card>();
    private CardListAdapter adapter;

    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    public static MainFragment newInstance(){
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mListView = (ListView) view.findViewById(R.id.list_storage);
        adapter = new CardListAdapter(getActivity().getApplicationContext(), arrayList);
        mListView.setAdapter(adapter);

        return view;
    }
    @Override
    public void onStart() {
        super.onStart();
        //mAuth.addAuthStateListener(mAuthListener);
        currentUser = mAuth.getInstance().getCurrentUser();
    }
}
