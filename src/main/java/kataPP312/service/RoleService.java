package kataPP312.service;

import kataPP312.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllUser();

    void save(Role role);

    Role showUserById(Long id);

    Role findByRoleName(String roleName);

    Role findById(Long id);
}
