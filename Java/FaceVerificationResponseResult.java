public class FaceVerificationResponseResult {
    //Connection Status
    boolean hasError;
    int StatusCode;
    String StatusMessage;
    
	//Verification Result
	int resultIndex;
	String resultMessage;
	float similarPercent;
     
	//FacePoints
	int [][] LeftTop;
	int [][] RightTop;
	int [][] RightBottom;
	int [][] LeftBottom;


    public boolean gethasError() {
        return hasError;
    }

    public void sethasError(boolean hasError) {
        this.hasError = hasError;
    }
    public int getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(int StatusCode) {
        this.StatusCode = StatusCode;
    }
        
     public String getStatusMessage() {
        return StatusMessage;
    }

    public void setStatusMessage(String StatusMessage) {
        this.StatusMessage = StatusMessage;
    }
        
    public int getresultIndex() {
        return resultIndex;
    }

    public void setresultIndex(int resultIndex) {
        this.resultIndex = resultIndex;
    }

    public String getresultMessage() {
        return resultMessage;
    }

    public void setresultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }
    

    public float getsimilarPercent() {
        return similarPercent;
    }

    public void setsimilarPercent(float similarPercent) {
        this.similarPercent = similarPercent;
    }
    
    public int [][] getLeftTop() {
        return LeftTop;
    }

    public void setLeftTop(int  LeftTop[][]) {
        this.LeftTop[0][0] = LeftTop[0][0];
        this.LeftTop[0][1] = LeftTop[0][1];

    }
    
    public int [][] getRightTop() {
        return RightTop;
    }

    public void setRightTop(int  RightTop[][]) {
        this.RightTop[0][0] = RightTop[0][0];
        this.RightTop[0][1] = RightTop[0][1];

    } 

    public int [][] getRightBottom() {
        return RightTop;
    }

    public void setRightBottom(int  RightBottom[][]) {
        this.RightBottom[0][0] = RightBottom[0][0];
        this.RightBottom[0][1] = RightBottom[0][1];

    }  
    
    public int [][] getLeftBottom() {
        return RightTop;
    }

    public void setLeftBottom(int  LeftBottom[][]) {
        this.LeftBottom[0][0] = LeftBottom[0][0];
        this.LeftBottom[0][1] = LeftBottom[0][1];

    }  
    
}