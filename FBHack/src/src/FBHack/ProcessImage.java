package src.FBHack;

import java.util.ArrayList;
import android.os.AsyncTask;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


class ProcessImage extends AsyncTask<Integer, Integer, Void>{

	ArrayList<Person> people;
	Bitmap framePic;
	
	public ProcessImage(Bitmap image) {
        super();
        framePic = image;
    }
	
	
	@Override
	protected Void doInBackground(Integer... arg0) {
		
		//people = locateFaces();
		//people = getNames(people);
		//display(people);

		return null;
	}
}
