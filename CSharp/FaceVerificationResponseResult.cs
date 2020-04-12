public class FaceVerificationResponseResult
{
    public int StatusCode { set; get; }
    public string StatusMessage { set; get; }
    public bool HasError { set; get; }
    public FaceVerificationResult VerificationResult { set; get; }
    public List<Features> Features { set; get; }
}

public class FaceVerificationResult
{
    public int resultIndex { set; get; }
    public string resultMessage { set; get; }
    public double similarPercent { set; get; }
}

public class Features
{
    public Gender Gender { get; set; }
    public AgeBoundary Age { get; set; }
    public RectPoints Framepoints { get; set; }
}

public class RectPoints
{
    public Dot LeftTop { get; set; }
    public Dot RightTop { get; set; }
    public Dot RightBottom { get; set; }
    public Dot LeftBottom { get; set; }
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