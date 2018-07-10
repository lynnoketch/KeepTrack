package com.example.android.keeptrack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<Unit> {
    private List<Unit> unitList;
    private Context mCtx;
    public ListViewAdapter(List<Unit> unitList, Context mCtx) {
        super(mCtx, R.layout.list_items, unitList);
        this.unitList = unitList;
        this.mCtx = mCtx;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(mCtx);


        View listViewItem = inflater.inflate(R.layout.list_items, null, true);


        TextView textViewName = listViewItem.findViewById(R.id.Uname);
        TextView textViewfaculty = listViewItem.findViewById(R.id.year);
        TextView textViewsemester = listViewItem.findViewById(R.id.semester);
        TextView textViewlecturer = listViewItem.findViewById(R.id.lecturer);
        TextView textViewyear = listViewItem.findViewById(R.id.year);
        Unit unit = unitList.get(position);

       textViewName.setText(Unit.getUname());
       textViewfaculty.setText(Unit.getFaculty());
       textViewsemester.setText(Unit.getSemester());
       textViewlecturer.setText(Unit.getLecturer());
       textViewyear.setText(Unit.getYear());
        return listViewItem;
    }
}
