package com.example.galeris;

import android.R.drawable;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends Activity {
	
	public Gallery galeri;
    public ImageView resimler;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        resimler=(ImageView) findViewById(R.id.imageView1);
        galeri=(Gallery)findViewById(R.id.gallery1);
        
        galeri.setAdapter(new ImageAdapter(this));
        galeri.setOnItemClickListener(new OnItemClickListener() {
        	public void onItemClick(AdapterView parent, View v, int resim,long id){
        		switch(resim){
        		case 0:resimler.setImageResource(R.drawable.a);break;
        		case 1:resimler.setImageResource(R.drawable.b);break;
        		case 2:resimler.setImageResource(R.drawable.c);break;
        		case 3:resimler.setImageResource(R.drawable.d);break;
        		case 4:resimler.setImageResource(R.drawable.e);break;
        		}
        		Log.i("MainActivitiy", "Resim degistirildi");
        		
        	}
		});
        
    }
    
    public class ImageAdapter extends BaseAdapter{
        int GalleryBackground;
        private Context context;
        private Integer[] resimlerId= {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e};
        public ImageAdapter(Context c){
        	context=c;
        	TypedArray attr=context.obtainStyledAttributes(R.styleable.Galeri);
        	GalleryBackground=attr.getResourceId(R.styleable.Galeri_android_galleryItemBackground,0);
        	attr.recycle();
            
        }
		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			Log.i("ImageAdapter", "getCount cagrildi");
			return resimlerId.length;
		}

		@Override
		public Object getItem(int resim) {
			// TODO Auto-generated method stub
			Log.i("ImageAdapter", "getItem cagrildi");
			return resim;
		}

		@Override
		public long getItemId(int resim) {
			// TODO Auto-generated method stub
			Log.i("ImageAdapter","getItemId");
			return resim;
		}
		
		

		@Override
		public View getView(int resim, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			ImageView imageview=new ImageView(context);
			imageview.setImageResource(resimlerId[resim]);
			imageview.setLayoutParams(new Gallery.LayoutParams(250, 200));
			imageview.setScaleType(ImageView.ScaleType.FIT_XY);
			imageview.setBackgroundResource(GalleryBackground);
			
			return imageview;
		}
		
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
