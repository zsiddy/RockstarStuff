public class JsonParser
{
    private Results[] results;

    private String response_code;

    public Results[] getResults()
    {
        return results;
    }

    public void setResults (Results[] results)
    {
        this.results = results;
    }

    public String getResponse_code()
    {
        return response_code;
    }

    public void setResponse_code (String response_code)
    {
        this.response_code = response_code;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [results = "+results+", response_code = "+response_code+"]";
    }
}