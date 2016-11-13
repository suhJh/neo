package sjh.spring.domain

import org.hibernate.validator.constraints.Email

import javax.persistence.*
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

    @Email
    @Size(max = 100)
    @Column(name="EMAIL", length = 100, unique = true)
    private String email

    @NotNull
    @Size(min = 60, max = 60)
    @Column(name = "PWD",length = 60)
    private String password

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
