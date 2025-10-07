package Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class employeeInfo {
    private String id;
    private String name;
    private String email;
    private String phoneNo;
    private String department;
    private String role;
}
