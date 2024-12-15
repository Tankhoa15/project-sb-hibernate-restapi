package com.ntkhoa.jpa.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    String username;
    String firstName;
    String lastName;
    LocalDate dob;
    Set<String> roles;
    /*
    chứa data mà server trả về cho client
    ví dụ khi tạo người dùng mới thì server sẽ trả về UserResponse chứa thông tin từ json
     */
}
