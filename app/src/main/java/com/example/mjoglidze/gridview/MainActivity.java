package com.example.mjoglidze.gridview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    GridView mGridViewl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mGridViewl = (GridView) findViewById(R.id.gridview);
        mGridViewl.setAdapter(new EfficientAdapter(this));

        mGridViewl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                Toast.makeText(MainActivity.this, "" + (position + 1),
                        Toast.LENGTH_SHORT).show();
            }
        });


    }

    private static class EfficientAdapter extends BaseAdapter {
        private LayoutInflater mLayoutInflater;
        public EfficientAdapter(Context context){
            mLayoutInflater= LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mThumbIds.length;
        }

        @Override
        public Object getItem(int arg0) {
            return arg0;
        }

        @Override
        public long getItemId(int arg0) {
            return arg0;
        }

        @Override
        public View getView(int position, View converView, ViewGroup parent) {
            ViewHolder mVHolder;
            if(converView == null){
                converView=mLayoutInflater.inflate(R.layout.booklist, parent, false);
                mVHolder=new ViewHolder();
                mVHolder.mImageView=(ImageView)converView.findViewById(R.id.image);
                mVHolder.mTextViewname=(TextView)converView.findViewById(R.id.bookname);
                mVHolder.mTextViewauthor=(TextView)converView.findViewById(R.id.author);
                mVHolder.mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                mVHolder.mImageView.setPadding(8,8,8,8);
                converView.setTag(mVHolder);
            }else{
                mVHolder=(ViewHolder)converView.getTag();
            }
            mVHolder.mImageView.setImageResource(mThumbIds[position]);
            mVHolder.mTextViewname.setText(BookName[position]);
            mVHolder.mTextViewauthor.setText(Authors[position]);

            return converView;
        }

    }

    static class ViewHolder{
        ImageView mImageView;
        TextView mTextViewname;
        TextView mTextViewauthor;
    }

    static  final String[] BookName = new  String[] {"idioti", "eshmakni", "alkimikosi","idioti", "eshmakni",
                                                    "alkimikosi","idioti", "eshmakni", "alkimikosi","idioti"};
    static final String[] Authors = new String[] { "Ilia", "Akaki",
            "vazha", "sulxan-saba", "Ilia", "Akaki",
            "vazha", "sulxan-saba", "Ilia", "Akaki"};



    private static  Integer[] mThumbIds = { R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5 , R.drawable.sample_6,
            R.drawable.sample_2, R.drawable.sample_3,
            R.drawable.sample_4, R.drawable.sample_5 , R.drawable.sample_6,

    };
}



