package sjh.spring.domain

import com.fasterxml.jackson.annotation.JsonBackReference

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.PrePersist
import javax.persistence.Table
import javax.persistence.Temporal
import javax.persistence.TemporalType

/**
 * Created by Suh on 2016-11-06.
 */
@Entity
@Table(name="TB_MESSAGE")
class Message implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="SEQ")
    private Long seq

    @ManyToOne
    @JoinColumn(name="SENDER")
    @JsonBackReference  // 재귀적으로 json만드는 걸 방지해주는 어노테이션임
    private User sender

    @Column(name="MESSAGE")
    private String message

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="TIMESTAMP")
    private Date timestamp


    @PrePersist //sysdate or getdate와 같은 용도
    protected void onCreate() {
        if (timestamp == null)  timestamp = new Date()
    }


    Long getSeq() {
        return seq
    }

    void setSeq(Long seq) {
        this.seq = seq
    }

    User getSender() {
        return sender
    }

    void setSender(User sender) {
        this.sender = sender
    }

    String getMessage() {
        return message
    }

    void setMessage(String message) {
        this.message = message
    }

    Date getTimestamp() {
        return timestamp
    }

    void setTimestamp(Date timestamp) {
        this.timestamp = timestamp
    }

    @Override
    public String toString() {
        return "Message{" +
                "seq=" + seq +
                ", sender=" + sender +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
