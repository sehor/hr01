package hr01.security.Role;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer>,RoleDataHelper {

    @Query(value = "from Role as r,UserAndRole as ur where r.id=ur.roleId and ur.userId=:userId")
    List<Role> findRoleByUserId(@Param("userId") Integer userId);

    @Query(value = "from Role as r,MenuAndRole as mr where r.id=mr.roleId and mr.menuId=:menuId")
    List<Role> findRolesByMenuId(@Param("menuId")Integer menuId);
}