package hr01.security.MenuAndRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MenuAndRoleRepository extends JpaRepository<MenuAndRole,Integer>,MenuAndRoleDataHelper {
}