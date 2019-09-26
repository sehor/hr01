package hr01.security.MenuAndRole;
public interface MenuAndRoleService {
MenuAndRole addMenuAndRole(MenuAndRole menuAndRole);
MenuAndRole getMenuAndRole(Integer id);
MenuAndRole updateMenuAndRole(MenuAndRole menuAndRole);
void deleteMenuAndRole(MenuAndRole menuAndRole);
void deleteMenuAndRole(Integer id);
}