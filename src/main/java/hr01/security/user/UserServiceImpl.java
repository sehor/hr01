package hr01.security.user;

import hr01.security.Role.Role;
import hr01.security.Role.RoleService;
import hr01.security.menu.Menu;
import hr01.security.menu.MenuService;
import io.swagger.models.auth.In;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserRepository repository;
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;

    private final Logger log= Logger.getLogger("UserService");

    @Override
    @CachePut("c1")
    public User addUser(User user) {
        log.warning("add user :"+user.getUsername());return repository.save(user);
    }

    @Override
    @Cacheable("c1")
    public User getUser(Integer id) {
        log.warning("get user by id :"+id);return repository.findById(id).get();
    }

    @Override
    @Cacheable("c1")
    public List<User> getAllUser() {
        log.warning("find all user");
        return repository.findAll();
    }


    @Override
    @CachePut("c1")
    public User updateUser(User user) {
        log.warning("update user  :"+ user.getUsername());return repository.save(user);
    }

    @Override
    @CacheEvict("c1")
    public void deleteUser(User user) {
        log.warning("delete user :"+ user.getUsername());repository.delete(user);
    }

    @Override
    @CacheEvict("c1")
    public void deleteUser(Integer id) {
        log.warning("delete user by id: "+id);repository.deleteById(id);
    }




    @Override
    public List<Menu> getUsrMenusByUserId(Integer userId) {
        List<Menu> menus=new ArrayList<>();
        for(Role role:roleService.findRolesByUserId(userId)){
            for(Menu menu:menuService.findMenusByRoleId(role.getId())){
                 menus.add(menu);
            }
        }
        return menus;
    }


    @Override
    @Cacheable("c1")
    public User getUser(String username) {
         log.warning("get user by name:"+username);
         User user=repository.getUserByUsername(username);
         if(user!=null) user.setRoles(roleService.findRolesByUserId(user.getId()));
         return user;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=getUser(s);
        if(user==null) throw new UsernameNotFoundException("用户或密码错！");
        System.out.println("current user: "+user.getUsername()+" authorities: "+user.getRoles().get(0).getNameZh());
        return user;
    }
}