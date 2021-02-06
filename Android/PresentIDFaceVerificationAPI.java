package YourPackageName;

import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.util.List;


public class PresentIDFaceVerificationAPI{
	private static int resultCode;
	
    public static void faceVerification(String imageFile1, String imageFile2){
	   resultCode = -100;
	   post(imageFile1, imageFile2);
	   return;
	}

	public static getFaceVerificationResult(){
		return resultCode;
	}

    private byte[] getByteArrayFromFile (String aFileName){
        File vFile = new File(aFileName);
        int size = (int) vFile.length();
        byte[] bytes = new byte[size];

        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(vFile));
            buf.read(bytes, 0, bytes.length);
            buf.close();
            return  bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    private void post(String imageFile1, String imageFile2) {
        try{

            byte[] photo1ByteArray = getByteArrayFromFile(imageFile1);
            byte[] photo2ByteArray = getByteArrayFromFile(imageFile2);

            RequestParams params = new RequestParams();
            params.put("photo1",  new ByteArrayInputStream(photo1ByteArray), "photo1.jpg");
            params.put("photo2",  new ByteArrayInputStream(photo2ByteArray), "photo2.jpg");
            HiBrainyPostURLUtils.post("iamhere/", params, new JsonHttpResponseHandler() {
                @Override
                public void onStart() {
                    super.onStart();
                }

                @Override
                public void onSuccess(int statusCode, Header[] headers, org.json.JSONObject obj) {
                    try {
                        int VerificationResult = obj.getJSONObject("VerificationResult").getInt(("resultIndex"));
                        switch (VerificationResult){
                            case -2 : resultCode = -2; /* Your Code... */ break; //in the second photo, the FACE was Not Found
                            case -1 : resultCode = -1; /* Your Code... */ break; //in the first photo, the FACE was Not Found
                            case 0  : resultCode = 0; /* Your Code... */ break; //2 faces belong to the same person.
                            case 1  : resultCode = 1; /* Your Code... */ break; //2 faces belong to the same person probabely.
                            case 2  : resultCode = 2; /* Your Code... */ break; //2 faces belong to the different people probabely.
                            case 3  : resultCode = 3; /* Your Code... */ break; //2 faces belong to the different people.
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(int statusCode, Header[] headers,
                                      Throwable throwable, org.json.JSONObject errorResponse) {
				    resultCode = -200;
                    Toast.makeText(getApplicationContext(),"Your Error Message....",Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFinish() {
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}	
