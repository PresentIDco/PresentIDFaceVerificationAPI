import requests


api_url = 'http://api.hibrainy.com/api/v1/Face/FaceVerification'
api_key = 'Your API Key'

image1_path = 'Path to image1 directory'
image1_name = 'Image name1'
image2_path = 'Path to image2 directory'
image2_name = 'Image name2'

files = {'Photo1': (image1_name, open(image1_path + image1_name, 'rb'), 'multipart/form-data'),
         'Photo2': (image2_name, open(image2_path + image2_name, 'rb'), 'multipart/form-data')}
header = {'API-Key': api_key}
response = requests.post(api_url, files=files, headers=header)

print("Status Code:", response.json()['StatusCode'])
print("Status Message:", response.json()['StatusMessage'])
print("Has Error:", response.json()['HasError'])

print("\nResult Index:", response.json()['VerificationResult']['resultIndex'])
print("Result Message:", response.json()['VerificationResult']['resultMessage'])
print("Similar Percent:", response.json()['VerificationResult']['similarPercent'])

for i in range(0, 2):
    print('\nFace', i + 1, 'Information:')
    print('Rectangle')
    print("LeftTop", " X:", response.json()['Features'][i]['Framepoints']['LeftTop']['x'],
          " Y:", response.json()['Features'][i]['Framepoints']['LeftTop']['y'])
    print("LeftBottom", " X:", response.json()['Features'][i]['Framepoints']['LeftBottom']['x'],
          " Y:", response.json()['Features'][i]['Framepoints']['LeftBottom']['y'])
    print("RightTop", " X:", response.json()['Features'][i]['Framepoints']['RightTop']['x'],
          " Y:", response.json()['Features'][i]['Framepoints']['RightTop']['y'])
    print("RightBottom", " X:", response.json()['Features'][i]['Framepoints']['RightBottom']['x'],
          " Y:", response.json()['Features'][i]['Framepoints']['RightBottom']['y'])