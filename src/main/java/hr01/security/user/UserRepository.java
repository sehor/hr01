package hr01.security.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>,UserDataHelper {

    User getUserByUsername(String username);
}