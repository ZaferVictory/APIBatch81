package pojos;

public class DummyREstApiDeletePojo {

    private String status;
    private String data;
    private String message;

    public DummyREstApiDeletePojo(String status, String data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public DummyREstApiDeletePojo() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
        return "DummyREstApiDeletePojo{" +
                "status='" + status + '\'' +
                ", data='" + data + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
