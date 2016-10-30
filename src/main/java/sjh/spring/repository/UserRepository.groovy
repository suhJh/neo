package sjh.spring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sjh.spring.domain.User

/**
 * User
 */
@Repository
interface UserRepository extends JpaRepository<User, Long> {


}
