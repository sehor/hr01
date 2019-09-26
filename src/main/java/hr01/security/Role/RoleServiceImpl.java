package hr01.security.Role;

import hr01.security.menu.Menu;
import hr01.security.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository repository;
    @Autowired
    MenuService menuService;


    private AntPathMatcher antPathMatcher=new AntPathMatcher();

    @Override
    public Role addRole(Role role) {
        return repository.save(role);
    }

    @Override
    public Role getRole(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public Role updateRole(Role role) {
        return repository.save(role);
    }

    @Override
    public void deleteRole(Role role) {
        repository.delete(role);
    }

    @Override
    public void deleteRole(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Role> findRolesByUserId(Integer userId) {
        List<Role> roles=new ArrayList<>();
        roles=repository.findRoleByUserId(userId);
        for(Role role:roles){
            role.setMenus(menuService.findMenusByRoleId(role.getId()));
        }
        return roles;
    }

    @Override
    public List<Role> findRolesByMenuId(Integer menuId) {
        return repository.findRolesByMenuId(menuId);
    }

    @Override
    public List<Role> findRolesByUrl(String url) {
        List<Role> roles=new ArrayList<>();
        for(Menu menu:menuService.findAll()){
            if(antPathMatcher.match(menu.getPattern(),url)){
                roles.addAll(findRolesByMenuId(menu.getId()));
            }
        }

        return roles;
    }
}