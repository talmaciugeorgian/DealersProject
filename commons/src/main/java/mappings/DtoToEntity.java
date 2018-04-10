package mappings;

import dto.User;
import entities.UsersEntity;

public class DtoToEntity {
    public UsersEntity convert(User user){
        UsersEntity entity= new UsersEntity();
        entity.setId(user.getId());
        entity.setPassword(user.getPassword());
        entity.setUsername(user.getUsername());
        return entity;
    }
}
