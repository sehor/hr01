package hr01.security.userAndRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserAndRoleRepository extends JpaRepository<UserAndRole,Integer>,UserAndRoleDataHelper {
}