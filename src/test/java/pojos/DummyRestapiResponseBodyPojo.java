package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyRestapiResponseBodyPojo {
    private String status;
    private DummyRestApiDataPojo data;
    private String message;

    public DummyRestapiResponseBodyPojo(String status, DummyRestApiDataPojo data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public DummyRestapiResponseBodyPojo() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyRestApiDataPojo getData() {
        return data;
    }

    public void setData(DummyRestApiDataPojo data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyRestApiPojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}