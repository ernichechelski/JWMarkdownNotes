package com.example.ernestchechelski.jwmarkdownnotes;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.util.Attributes;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


            List<MenuItem> items = new ArrayList();
            items.add(new MenuItem("First", R.id.swipe, R.layout.simple_note_item, new MenuItemInterface() {
                @Override
                public View onGenerateView(SwipeLayout itemLayout, View v, MenuItem item) {
                    itemLayout.addSwipeListener(new SimpleSwipeListener() {
                        @Override
                        public void onOpen(SwipeLayout layout) {

                        }
                    });

                    Button button = v.findViewById(R.id.swipe_single_action_button);
                    button.setText(item.getName());
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            //goToActivity(parentActivity,item);
                            Toast.makeText(getApplicationContext(), "click delete", Toast.LENGTH_SHORT).show();
                        }
                    });

                    return v;
                }
            }));


            mAdapter = new SwipeListViewAdapter(this,items,this,mListView);



    }
}
