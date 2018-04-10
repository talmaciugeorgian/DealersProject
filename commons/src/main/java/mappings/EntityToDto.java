package mappings;

import dto.User;
import entities.UsersEntity;

public class EntityToDto {
    public User convert(UsersEntity usersEntity){
        User entity=new User();
        entity.setId(usersEntity.getId());
        entity.setUsername(usersEntity.getUsername());
        entity.setPassword(usersEntity.getPassword());
        return entity;
    }
}
