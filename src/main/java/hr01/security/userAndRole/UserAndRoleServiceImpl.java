package hr01.security.userAndRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAndRoleServiceImpl implements UserAndRoleService {
@Autowired
UserAndRoleRepository repository;
     @Override
    public UserAndRole addUserAndRole(UserAndRole userAndRole) {
        return repository.save(userAndRole);
    }
    @Override
    public UserAndRole getUserAndRole(Integer id) {
        return repository.findById(id).get();
    }
    @Override
    public UserAndRole updateUserAndRole(UserAndRole userAndRole) {
        return repository.save(userAndRole);
    }
    @Override
    public void deleteUserAndRole(UserAndRole userAndRole) {
       repository.delete(userAndRole);
    }
    @Override
    public void deleteUserAndRole(Integer id) {
        repository.deleteById(id);
    }
}