package com.example.ernestchechelski.jwmarkdownnotes;

/**
 * Created by ernest.chechelski on 11/2/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SimpleSwipeListener;
import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.BaseSwipeAdapter;

import java.util.List;

public class SwipeListViewAdapter extends BaseSwipeAdapter {

    private Context mContext;
    private List<MenuItem> items;

    public SwipeListViewAdapter(Context mContext,List<MenuItem> items) {
        this.mContext = mContext;
        this.items = items;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public View generateView(int position, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.simple_note_item, null);
        SwipeLayout swipeLayout = (SwipeLayout)v.findViewById(getSwipeLayoutResourceId(position));

     /*   swipeLayout.addDrag(SwipeLayout.DragEdge.Left, v.findViewById(R.id.left));
        swipeLayout.addDrag(SwipeLayout.DragEdge.Right, v.findViewById(R.id.right));*/
        swipeLayout.addSwipeListener(new SimpleSwipeListener() {
            @Override
            public void onOpen(SwipeLayout layout) {

            }
        });

        Button button = v.findViewById(R.id.swipe_single_action_button);
        button.setText(items.get(position).name);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "click delete", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    @Override
    public void fillValues(int position, View convertView) {
        TextView t = (TextView)convertView.findViewById(R.id.position);
        t.setText(items.get(position).name);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
