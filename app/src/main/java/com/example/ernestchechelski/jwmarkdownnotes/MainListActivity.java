package com.example.ernestchechelski.jwmarkdownnotes;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.swipe.util.Attributes;

import org.parceler.Parcels;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.ernestchechelski.jwmarkdownnotes.SwipeListViewAdapter.INTENT_KEY;

public class MainListActivity extends AppCompatActivity {

    @BindView(R.id.notes_list_view)
    ListView mListView;


    SwipeListViewAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        MenuItem user = (MenuItem) Parcels.unwrap(getIntent().getParcelableExtra(INTENT_KEY));
        if(user != null){
            mAdapter = new SwipeListViewAdapter(this,
                   user.getChildren(),
                    this,mListView);
        } else {




            mAdapter = new SwipeListViewAdapter(this,
                    Arrays.asList(
                            new MenuItem("Action first", Arrays.asList(
                                    new MenuItem("Action third"),
                                    new MenuItem("Action fourth"))),
                            new MenuItem("Action second")),
                    this,mListView);
        }


    }

}
