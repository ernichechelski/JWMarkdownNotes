package com.example.ernestchechelski.jwmarkdownnotes;

/**
 * Created by ernest.chechelski on 11/2/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.BaseSwipeAdapter;
import com.daimajia.swipe.util.Attributes;

import org.parceler.Parcels;

import java.util.List;

public class SwipeListViewAdapter extends BaseSwipeAdapter {

    private Context mContext;
    private Activity parentActivity;
    private ListView parentListView;
    private List<MenuItem> items;
    public static String INTENT_KEY = "SWIPE_LIST_VIEW_ADAPTER_KEY";


    public SwipeListViewAdapter(final Context mContext, List<MenuItem> items, Activity parentActivity, ListView parentListView) {
        this.mContext = mContext;
        this.items = items;
        this.parentActivity = parentActivity;
        this.parentListView = parentListView;
        this.parentListView.setAdapter(this);
        this.setMode(Attributes.Mode.Multiple);
        this.parentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //((SwipeLayout)(mListView.getChildAt(position - mListView.getFirstVisiblePosition()))).open(true);
            }
        });

        this.parentListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e("ListView", "OnTouch");
                return false;
            }
        });

        this.parentListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(mContext, "OnItemLongClickListener", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        this.parentListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Log.e("ListView", "onScrollStateChanged");
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });

        this.parentListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.e("ListView", "onItemSelected:" + position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.e("ListView", "onNothingSelected:");
            }
        });
    }


    private void goToActivity(Activity activityClass, MenuItem menuItem){
        Intent intent = new Intent(this.mContext, activityClass.getClass());
        intent.putExtra(INTENT_KEY, Parcels.wrap(menuItem));

        this.parentActivity.startActivity(intent);
    }


    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }



    @Override
    public View generateView(int position, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.simple_note_item, null);
        SwipeLayout swipeLayout = (SwipeLayout)v.findViewById(getSwipeLayoutResourceId(position));

        final MenuItem item = getItem(position);
        //swipeLayout.addDrag(SwipeLayout.DragEdge.t, v.findViewById(R.id.swipe));
        swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {
              
            }
        });

        Button button = v.findViewById(R.id.swipe_single_action_button);
        button.setText(item.getName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity(parentActivity,item);
                Toast.makeText(mContext, "click delete", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    @Override
    public void fillValues(int position, View convertView) {
        TextView t = (TextView)convertView.findViewById(R.id.position);
        t.setText(items.get(position).getName());
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public MenuItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
