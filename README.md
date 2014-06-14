A simple Android image cropper library using canvas.

Goal of this project
====================
- Just for learning canvas in Android
- Build a library project
- An image cropper for future use, alternative to Android image cropper.

Future implementations
====================
- Custom aspect for cropped image (now only as square)
- Cropped image with higher resolution (now it's still depend on how ImageView can handle)

Usage
=====================

First declare ```CropActivity``` in your manifest file:

```
<activity android:name="gdg.ninja.croplib.CropActivity" >
```

Crop
------------
```
new Crop(inputUri).output(outputUri).quality(90).withMaxSize(maxWidth, maxHeight).start(activity);
```

Listen for the result of the crop:
```
@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data){
	if(resultCode == RESULT_OK){
		if(requestCode == Crop.REQUEST_CROP){
			Uri croppedImageUri = data.getData();
			//DO SOMETHING WITH croppedImageUri
		}
	}
}
```

How it look?
==============
![NinjaCrop](https://raw.githubusercontent.com/longtober/NinjaCrop/master/screenshot.png)
