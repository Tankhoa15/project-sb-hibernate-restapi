package com.ntkhoa.jpa.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Long id;
    String username;
    String password;
    String firstName;
    String lastName;
    LocalDate dob;
    /*
    chứa data mà server trả về cho client
    ví dụ khi tạo người dùng mới thì server sẽ trả về UserResponse chứa thông tin từ json
     */
}
