package hr01.security.menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer>,MenuDataHelper {

    @Query(value = "From Menu as m ,MenuAndRole as mr where m.id=mr.menuId and mr.roleId=:roleId")
    List<Menu> findByRoleId(@Param("roleId") Integer roleId);
}