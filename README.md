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
