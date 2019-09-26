package hr01.security.Role;

import java.util.List;

public interface RoleService {
Role addRole(Role role);
Role getRole(Integer id);
Role updateRole(Role role);
void deleteRole(Role role);
void deleteRole(Integer id);

List<Role> findRolesByUserId(Integer userId);

List<Role> findRolesByMenuId(Integer menuId);

 List<Role> findRolesByUrl(String url);
}