package com.demo.tomcat.listviewtest;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    static String[] words = {"one", "two", "three"};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbEvent();
        listViewEvent();
    }

    private void listViewEvent()
    {
        ListView listView = (ListView)findViewById(R.id.ListView01);

        listView.setAdapter(new BaseAdapter()
        {
            @Override
            public int getCount()
            {
                return words.length;
            }

            @Override
            public Object getItem(int position)
            {
                return words[position];
            }

            @Override
            public long getItemId(int position)
            {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                View view = inflater.inflate(R.layout.single_item, null);
                TextView userName = (TextView) view.findViewById(R.id.tvUserName);
                TextView dataRange = (TextView) view.findViewById(R.id.tvDataRange);
                userName.setText(words[position]);
                dataRange.setText(Integer.toString(position));


                return view;
            }
        });
    }

    private void dbEvent()
    {
        SqlOpenHelper helper = new SqlOpenHelper(this);
        SQLiteDatabase database = helper.getWritableDatabase();
    }

}
