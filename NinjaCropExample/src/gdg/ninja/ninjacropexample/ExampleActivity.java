package gdg.ninja.ninjacropexample;

import gdg.ninja.croplib.Crop;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ExampleActivity extends Activity{
	
	private static int REQUEST_PICTURE = 1111;

	Button mBtnChooseImage;
	ImageView mImgDemo;
	Activity mActivity;

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ac_example);
		
		mBtnChooseImage = (Button) findViewById(R.id.btn_choose_image);
		mImgDemo = (ImageView) findViewById(R.id.img_demo);
		mActivity = this;
		
		mBtnChooseImage.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View arg0){
				choosePictureFromGallery();
			}
		});
	}
	
	private void choosePictureFromGallery(){
		Intent intent = new Intent();
		intent.setType("image/*");
		intent.setAction(Intent.ACTION_GET_CONTENT);
		startActivityForResult(Intent.createChooser(intent, "Choose picture!"),
				REQUEST_PICTURE);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		if(resultCode == RESULT_OK){
			if(requestCode == REQUEST_PICTURE){
				Uri imgSource = data.getData();
				new Crop(imgSource).start(mActivity);
			}else if(requestCode == Crop.REQUEST_CROP){
				Uri imgResult = data.getData();
				mImgDemo.setImageURI(imgResult);
			}
		}
	}
}
