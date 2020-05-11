public class FaceVerificationResponseResult
{
    public int statusCode { set; get; }
    public string statusMessage { set; get; }
    public bool hasError { set; get; }
    public FaceVerificationResult data { set; get; }
    public List<Features> imageSpecs { set; get; }
}

public class FaceVerificationResult
{
    public int resultIndex { set; get; }
    public string resultMessage { set; get; }
    public double similarPercent { set; get; }
}

public class Features
{
    //public Gender gender { get; set; }
    //public AgeBoundary age { get; set; }
     public Dot leftTop { get; set; }
     public Dot rightTop { get; set; }
     public Dot rightBottom { get; set; }
     public Dot leftBottom { get; set; }
}

public class Dot
{
    public int x { set; get; }
    public int y { set; get; }
}

public class Gender
{
    public int index { set; get; }
    public string title { set; get; }
}

public class AgeBoundary
{
    public int minAge { set; get; }
    public int maxAge { set; get; }
}
