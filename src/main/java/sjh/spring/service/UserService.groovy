package sjh.spring.service

import org.springframework.stereotype.Service
import sjh.spring.domain.User
import sjh.spring.repository.UserRepository

import javax.inject.Inject
import javax.transaction.Transactional

/**
 * Created by Suh on 2016-10-30.
 */
@Service
@Transactional
class UserService {

    private UserRepository userRepository

    @Inject
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository
    }


    Optional<User> findOneBySeq(Long seq) {
        return Optional.ofNullable(userRepository.findOne(seq))
    }

}
