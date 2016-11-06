package sjh.spring.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.google.common.collect.Lists
import org.hibernate.validator.constraints.Email

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 * 회원 엔티티
 */
@Entity
@Table(name = "TB_USER")
class User implements Serializable {

    private static final long serialVersionUID = 1L

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="SEQ")
    private Long seq

	@JsonIgnore
    @Email
    @Size(max = 100)
    @Column(name="EMAIL", length = 100, unique = true)
    private String email


    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    @Column(name = "PWD",length = 60)
    private String password

	@JsonIgnore
    @Size(max = 50)
    @Column(name = "NAME", length = 50)
    private String name



	static long getSerialVersionUID() {
		return serialVersionUID
	}

	Long getSeq() {
		return seq
	}

	void setSeq(Long seq) {
		this.seq = seq
	}

	String getEmail() {
		return email
	}

	void setEmail(String email) {
		this.email = email
	}

	String getPassword() {
		return password
	}

	void setPassword(String password) {
		this.password = password
	}

	String getName() {
		return name
	}

	void setName(String name) {
		this.name = name
	}

	List<Message> getMessages() {
		return messages
	}

	void setMessages(List<Message> messages) {
		this.messages = messages
	}


	@Override
	public String toString() {
		return "User{" +
				"seq=" + seq +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
