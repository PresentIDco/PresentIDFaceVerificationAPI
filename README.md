# HiBrainyAPIs - Face Verification
The Face Verification Web Service is called Restful and in the post method. The parameters and input files are sent to the API in the form of Multipart Form. The service output is returned in Json format.

## Output Template

```
{
  'StatusCode': int, 
  'StatusMessage': string, 
  'HasError': bool, 
  'VerificationResult': 
    {
      'resultIndex': int, 
      'resultMessage': string, 
      'similarPercent': float
    }, 
  'Features': 
    [
      {
        'Gender': null, 
        'Age': null, 
        'Framepoints': 
          {
            'LeftTop': {'x': int, 'y': int}, 
            'RightTop': {'x': int, 'y': int}, 
            'RightBottom': {'x': int, 'y': int}, 
            'LeftBottom': {'x': int, 'y': int}
          }
      }, 
      {
        'Gender': null, 
        'Age': null, 
        'Framepoints': 
          {
            'LeftTop': {'x': int, 'y': int}, 
            'RightTop': {'x': int, 'y': int}, 
            'RightBottom': {'x': int, 'y': int}, 
            'LeftBottom': {'x': int, 'y': int}
          }
      }
    ]
}

```

## Languages
  * [Python](#python)
  * [C#](#csharp)
  * [Java](#java)

## Python

### Prerequisites
  [requests](https://pypi.org/project/requests/) python package.

#### Installation
To install [requests](https://pypi.org/project/requests/), simply:
 ```
 $ pip install requests
 ```

### Usage
The python sample code is [Here](Python/FaceVerification.py).  

* Give your API Key from [my.HiBrainy.com](https://my.HiBrainy.com) in the Dashboard page. and assign `api_key` variable.  

  ```python
    api_key = 'Your API Key'
  ```

* Assign the variables `image1_path`, `image1_name`, `image2_path` and `image2_name`, by images path and images name.  
  ```python
    image1_path = 'Path to image1 directory'
    image1_name = 'Image name1'
    image2_path = 'Path to image2 directory'
    image2_name = 'Image name2'
  ```

## CSharp  

### Prerequisites
 [Newtonsoft.Json](https://www.nuget.org/packages/Newtonsoft.Json/) framework for .NET    

#### Installation
Run this command in the Package Manager Console:  
``` 
Install-Package Newtonsoft.Json
```

### Usage

 * Add `FaceVerificationResponseResult.cs` class in your project, with following "using" statements.  
   ```c#
   using System;
   using System.Collections.Generic;
   ```
   [Here](CSharp/FaceVerificationResponseResult.cs) is the content of the `FaceVerificationResponseResult.cs` class. 

 * Add `HiBrainyFaceVerificationAPI.cs` class in your project, with following "using" statements.  
   ```c#
   using Newtonsoft.Json;
   using System;
   using System.Collections.Generic;
   using System.IO;
   using System.Linq;
   using System.Net.Http;
   using System.Threading.Tasks;
   ```
   [Here](CSharp/HiBrainyFaceVerificationAPI.cs) is the content of the `HiBrainyFaceVerificationAPI.cs` class.
  
  * Create "HiBrainyFaceVerificationAPI" class Instance. You can get all the features through below:  
 
    ```c#
	string apiKey = "Your API Key";
	HiBrainyFaceVerificationAPI faceVerification = new HiBrainyFaceVerificationAPI(apiKey);
	var verificationResult = faceVerification.FaceVerificationAsync("Path to image1", "Path to image2").Result;

	Console.WriteLine("Status Code: " + verificationResult.StatusCode);
	Console.WriteLine("Status Message: " + verificationResult.StatusMessage);
	Console.WriteLine("Has Error: " + verificationResult.HasError);

	Console.WriteLine("\nResult Index: " + verificationResult.VerificationResult.resultIndex);
	Console.WriteLine("Result Message: " + verificationResult.VerificationResult.resultMessage);
	Console.WriteLine("Similar Percent: " + verificationResult.VerificationResult.similarPercent);

	for (int i = 0; i < verificationResult.Features.Count; i++)
	{
		Console.WriteLine("\nFace " + (i + 1) + " Information:");
		Console.WriteLine("Rectangle");
		Console.WriteLine("LeftTop " + " X:" + verificationResult.Features[i].Framepoints.LeftTop.x + " Y:" + verificationResult.Features[i].Framepoints.LeftTop.y);
		Console.WriteLine("LeftBottom " + " X:" + verificationResult.Features[i].Framepoints.LeftBottom.x + " Y:" + verificationResult.Features[i].Framepoints.LeftBottom.y);
		Console.WriteLine("RightTop " + " X:" + verificationResult.Features[i].Framepoints.RightTop.x + " Y:" + verificationResult.Features[i].Framepoints.RightTop.y);
		Console.WriteLine("RightBottom " + " X:" + verificationResult.Features[i].Framepoints.RightBottom.x + " Y:" + verificationResult.Features[i].Framepoints.RightBottom.y + "\n");
	}
    ```
	Give your API Key from [my.HiBrainy.com](https://my.HiBrainy.com) in the Dashboard page. and assign `apiKey` variable.


## Java

### Prerequisites
 [OkHttp package](https://github.com/square/okhttp/) package  


### Usage
 * Add `FaceVerificationResponseResult` class in your project.  
   [Here](Java/FaceVerificationResponseResult.java) is the content of the `FaceVerificationResponseResult.java` class. 

 * Add following "using" statements to your project.  
   ```java
    import com.fasterxml.jackson.databind.ObjectMapper;
    import okhttp3.*;
    import java.io.File;
   ```
 * You can get all the features through below:

    ```java
	String apiURL = "http://api.hibrainy.com/api/v1/Face/FaceAllFeatures";
	String apiKey = "Your API Key";
	String imagePath1 = "Path to image1 file";
	String imagePath2 = "Path to image2 file";
	String imageName1 = "Image name1";
	String imageName2 = "Image name2";
	File file1 = new File(imagePath1 + imageName1);
	File file2 = new File(imagePath2 + imageName2);
	byte[] fileContent1 = new byte[(int) file1.length()];
	byte[] fileContent2 = new byte[(int) file2.length()];
	
	OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
                .url(apiURL)
                .post(RequestBody.create(MediaType.get("multipart/form-data"), fileContent1))
				.post(RequestBody.create(MediaType.get("multipart/form-data"), fileContent2))
                .header("API-Key", apiKey)
                .build();
	
	Call call = client.newCall(request);
    Response response = call.execute();
    ObjectMapper mapper = new ObjectMapper();
	
	FaceVerificationResponseResult faceVerification = mapper.readValue(response.body().string(), FaceVerificationResponseResult.class);
	System.out.println("Has Error: " + faceVerification.gethasError());
	System.out.println("Status Code: " + faceVerification.getStatusCode());
	System.out.println("Status Message: " + faceVerification.getStatusMessage());  

	
	System.out.println("\nResult Index: "+Integer.toString(faceVerification.getresultIndex()));
	System.out.println("\nesult Message: "+faceVerification.getresultMessage());
	System.out.println("\nSimilar Percent: "+Float.toString(faceVerification.getsimilarPercent()));
	
	int [][]lt = faceVerification.getLeftTop();
	int [][]lb = faceVerification.getLeftBottom();
	int [][]rt = faceVerification.getRightTop();
	int [][]rb = faceVerification.getRightBottom();
	
	System.out.println("Face #1 Rectangle:");
	System.out.println("Left Top:\t"+"X: "+Integer.toString(lt[0][0])+"\tY: "+Integer.toString(lt[0][1]));
	System.out.println("Left Bottom:\t"+"X: "+Integer.toString(lb[0][0])+"\tY: "+Integer.toString(lb[0][1]));
	System.out.println("Right Top:\t"+"X: "+Integer.toString(rt[0][0])+"\tY: "+Integer.toString(rt[0][1]));
	System.out.println("LeftTop:\t"+"X: "+Integer.toString(rb[0][0])+"\tY: "+Integer.toString(rb[0][1]));
	
	System.out.println("Face #2 Rectangle:");
	System.out.println("Left Top:\t"+"X: "+Integer.toString(lt[1][0])+"\tY: "+Integer.toString(lt[1][1]));
	System.out.println("Left Bottom:\t"+"X: "+Integer.toString(lb[1][0])+"\tY: "+Integer.toString(lb[1][1]));
	System.out.println("Right Top:\t"+"X: "+Integer.toString(rt[1][0])+"\tY: "+Integer.toString(rt[1][1]));
	System.out.println("LeftTop:\t"+"X: "+Integer.toString(rb[1][0])+"\tY: "+Integer.toString(rb[1][1]));
	```
	Give your API Key from [my.HiBrainy.com](https://my.HiBrainy.com) in the Dashboard page. and assign `apiKey` variable.