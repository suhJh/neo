package sjh.spring.web.socket.dto

/**
 * Created by Suh on 2016-11-02.
 */
class HelloMessage {

    private String name;

    public HelloMessage() {
    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
