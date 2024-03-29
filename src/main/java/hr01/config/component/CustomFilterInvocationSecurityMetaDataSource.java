package hr01.config.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hr01.security.Role.RoleService;
import hr01.security.menu.Menu;
import hr01.security.menu.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CustomFilterInvocationSecurityMetaDataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    RoleService roleService;

    @Autowired
    MenuService menuService;


    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String urlString = ((FilterInvocation) o).getRequestUrl();
        List<String> attributes = new ArrayList<>();

        System.out.println("urlString: "+urlString);
        roleService.findRolesByUrl(urlString).forEach(role -> {
            System.out.println("in CustomFilterInvocationSecurityMetaSource.getAttributes method: " + role.getName());
            attributes.add(role.getName());
        });

        return attributes.size() > 0 ?
                SecurityConfig.createList(attributes.toArray(new String[attributes.size()]))
                : SecurityConfig.createList("ROLE_LOGIN");

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
