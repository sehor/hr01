package hr01.security.MenuAndRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuAndRoleServiceImpl implements MenuAndRoleService {
@Autowired
MenuAndRoleRepository repository;
     @Override
    public MenuAndRole addMenuAndRole(MenuAndRole menuAndRole) {
        return repository.save(menuAndRole);
    }
    @Override
    public MenuAndRole getMenuAndRole(Integer id) {
        return repository.findById(id).get();
    }
    @Override
    public MenuAndRole updateMenuAndRole(MenuAndRole menuAndRole) {
        return repository.save(menuAndRole);
    }
    @Override
    public void deleteMenuAndRole(MenuAndRole menuAndRole) {
       repository.delete(menuAndRole);
    }
    @Override
    public void deleteMenuAndRole(Integer id) {
        repository.deleteById(id);
    }
}