package sjh.spring.web.socket.dto

/**
 * Created by Suh on 2016-11-02.
 */
class Greeting {

    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }


}
