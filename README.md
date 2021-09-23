## PresentID Photo ID Matching (Face Verification)
PresentID Photo ID matching API evaluates whether two faces belong to the same person or not. Face verification ensures a one-to-one (1:1) match of a face image captured at the time of onboarding with an image captured from a trusted credential such as a driver’s license, or a passport.

We have created a very deep convolutional neural network to extract very high-level features from a face for each person. We have provided a large-scale image database of faces from many sources e.g. web crowdsourcing, our built-in house dataset. There is a lot of diversity of races in the database. Our model inference time is 115ms on Intel CPU corei7 6700k. Especially in our solution, we save some frames that come from client SDK that is selected based on our own algorithm. This feature makes our matching stronger. Moreover, we save a checksum from a video to check duplicated videos.

Our method has got promising results under large appearance variations e.g. pose, age gaps, skin, glass, makeup, and beard.


![photoidmatching2](https://presentid.com/assets/img/photoidmatching2.png)

**Youtube Videos**
- https://www.youtube.com/embed/RqKJVjiaQhQ

**Input:**
- Image file
- Image URL link
- Base64 image

**Output:**
- Result index
- Image specs
- Similar percent 
- Result message

**Features:**
- Less than 10 seconds.
- Accuracy is %99.76 on the LFW face verification dataset, a very popular benchmark.
- Support IOS, Android, Windows and Mac devices.
- The smallest faces are detected (48px * 48px).
- Easy integration with your app.

**Use Cases:**
- Access Control
- Onboarding
- Fintech
- Car sharing & Taxi
- Online Brokers
- Health Care
- Dating Apps
- Customer Support

**Rules & Restrictions:**
- Send data via Base64 or an image URL or an image file.
- Image size should not exceed 8 MB.
- Also, the images should not be larger than 5000 pixels and smaller than 50 pixels.

## Free try in RapidAPI
https://rapidapi.com/PresentID/api/face-verification2
