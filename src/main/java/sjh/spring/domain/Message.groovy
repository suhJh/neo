package sjh.spring.domain


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

import sjh.spring.config.CustomJsonDateDeserializer

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@Entity
@Table(name="TB_MESSAGE")
@JsonIgnoreProperties(ignoreUnknown = true)
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
    @Column(name="TIMESTAMP", nullable=true)
	@JsonIgnore
	private Date timestamp
	


    @PrePersist //sysdate or getdate와 같은 용도
    protected void onCreate() {
        if (timestamp == null)  timestamp = new Date()
    }

	public Long getSeq() {
		return seq;
	}

	public void setSeq(Long seq) {
		this.seq = seq;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	@JsonDeserialize(using = CustomJsonDateDeserializer.class)
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Message [seq=" + seq + ", sender=" + sender + ", message=" + message + ", timestamp=" + timestamp + "]";
	}

	
    
}
