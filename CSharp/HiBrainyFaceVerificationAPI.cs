class HiBrainyFaceVerificationAPI
{
	string apiKey;

	public HiBrainyFaceVerificationAPI(string apiKey)
	{
		this.apiKey = apiKey;
	}

	public async Task<FaceVerificationResponseResult> FaceVerificationAsync(string FileName1st, string FileName2nd)
	{
		var content = new MultipartFormDataContent();
		var response = new HttpResponseMessage();
		string apiUrl = "https://face-recognition4.p.rapidapi.com/FaceVerification";
		FaceVerificationResponseResult hbFaces = new FaceVerificationResponseResult();
		try
		{
			content.Headers.Add("x-rapidapi-host", "face-recognition4.p.rapidapi.com");
			content.Headers.Add("x-rapidapi-key", apiKey);
			content.Add(new ByteArrayContent(File.ReadAllBytes(FileName1st)), "photo1", FileName1st.Split('\\').LastOrDefault());
			content.Add(new ByteArrayContent(File.ReadAllBytes(FileName2nd)), "photo2", FileName2nd.Split('\\').LastOrDefault());
		}
		catch (Exception ex) { throw new Exception(ex.Message); }
		try
		{
			using (var http = new HttpClient())
			{
				response = await http.PostAsync(apiUrl, content);
			}
			string resMessage = await response.Content.ReadAsStringAsync();
			if (response.IsSuccessStatusCode)
			{
				hbFaces = JsonConvert.DeserializeObject<FaceVerificationResponseResult>(resMessage);
				return hbFaces;
			}
			else
			{ throw new Exception(resMessage); }
		}
		catch (Exception ex) { throw new Exception(ex.Message); }
	}
}