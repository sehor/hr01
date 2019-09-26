package hr01.security.userAndRole;
public interface UserAndRoleService {
UserAndRole addUserAndRole(UserAndRole userAndRole);
UserAndRole getUserAndRole(Integer id);
UserAndRole updateUserAndRole(UserAndRole userAndRole);
void deleteUserAndRole(UserAndRole userAndRole);
void deleteUserAndRole(Integer id);
}