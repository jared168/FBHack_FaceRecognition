package src.FBHack;

import java.util.ArrayList;
import android.os.AsyncTask;
import android.util.Log;
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
		
		Log.i("Jared", "Starting Background Task");
		
		
		FindNames nameGrabber = new FindNames();
		nameGrabber.getName(framePic);
		
		//people = locateFaces();
		//people = getNames(people);
		//display(people);

		return null;
	}
}
