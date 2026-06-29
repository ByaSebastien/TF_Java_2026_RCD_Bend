package be.bstorm.tf_java_2026_rcd_bend.models.user;

import be.bstorm.tf_java_2026_rcd_bend.entities.User;
import be.bstorm.tf_java_2026_rcd_bend.enums.UserRole;

public record UserDto(
        Long id,
        String username,
        UserRole role
) {

    public static UserDto fromUser(User user) {
        return new UserDto(user.getId(), user.getUsername(), user.getRole());
    }
}
