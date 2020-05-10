import requests


api_url = 'https://face-recognition4.p.rapidapi.com/FaceVerification'
api_key = 'Your API Key'

image1_path = 'Path to image1 directory'
image1_name = 'Image name1'
image2_path = 'Path to image2 directory'
image2_name = 'Image name2'

files = {'Photo1': (image1_name, open(image1_path + image1_name, 'rb'), 'multipart/form-data'),
         'Photo2': (image2_name, open(image2_path + image2_name, 'rb'), 'multipart/form-data')}
header = {
    "x-rapidapi-host": "face-recognition4.p.rapidapi.com",
    "x-rapidapi-key": api_key
}
response = requests.post(api_url, files=files, headers=header)

print("Status Code:", response.json()['statusCode'])
print("Status Message:", response.json()['statusMessage'])
print("Has Error:", response.json()['hasError'])

print("\nResult Index:", response.json()['data']['resultIndex'])
print("Result Message:", response.json()['data']['resultMessage'])
print("Similar Percent:", response.json()['data']['similarPercent'])

for i in range(0, 2):
    print('\nFace', i + 1, 'Information:')
    print('Rectangle')
    print("LeftTop", " X:", response.json()['imageSpecs'][i]['leftTop']['x'],
          " Y:", response.json()['imageSpecs'][i]['leftTop']['y'])
    print("LeftBottom", " X:", response.json()['imageSpecs'][i]['leftBottom']['x'],
          " Y:", response.json()['imageSpecs'][i]['leftBottom']['y'])
    print("RightTop", " X:", response.json()['imageSpecs'][i]['rightTop']['x'],
          " Y:", response.json()['imageSpecs'][i]['rightTop']['y'])
    print("RightBottom", " X:", response.json()['imageSpecs'][i]['rightBottom']['x'],
          " Y:", response.json()['imageSpecs'][i]['rightBottom']['y'])
