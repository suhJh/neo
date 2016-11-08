package sjh.spring.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import sjh.spring.domain.Message
import sjh.spring.domain.User

/**
 * Created by Suh on 2016-11-06.
 */
@Repository
interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findBySender(User user)

    List<Message> findTop10ByTimestampBefore(Date timestamp)


}
