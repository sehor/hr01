package hr01.security.menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
@Autowired
MenuRepository repository;

private AntPathMatcher antPathMatcher=new AntPathMatcher();
     @Override
    public Menu addMenu(Menu menu) {
        return repository.save(menu);
    }
    @Override
    public Menu getMenu(Integer id) {
        return repository.findById(id).get();
    }
    @Override
    public Menu updateMenu(Menu menu) {
        return repository.save(menu);
    }
    @Override
    public void deleteMenu(Menu menu) {
       repository.delete(menu);
    }
    @Override
    public void deleteMenu(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public boolean isMatchAnyPattern(String urlStr) {
        for(Menu menu:repository.findAll()) {
            if(antPathMatcher.match(menu.getPattern(),urlStr)) {
                System.out.println(menu.getPattern()+"  :: "+urlStr);
                return true;
            }
        }
        return false;
    }


    @Override
    public List<Menu> findMenusByRoleId(Integer roleId) {
        return repository.findByRoleId(roleId);
    }

    @Override
    public List<Menu> findAll() {
        return repository.findAll();
    }
}