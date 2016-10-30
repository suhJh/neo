package sjh.spring.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.validator.constraints.Email

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
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
    private Long seq


    @Email
    @Size(max = 100)
    @Column(name="email", length = 100, unique = true)
    private String email


    @JsonIgnore
    @NotNull
    @Size(min = 60, max = 60)
    @Column(name = "password",length = 60)
    private String password


    @Size(max = 50)
    @Column(name = "name", length = 50)
    private String name








}
