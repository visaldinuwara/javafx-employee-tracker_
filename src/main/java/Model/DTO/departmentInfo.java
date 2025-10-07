package Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class departmentInfo {
    private String departmentId;
    private String departmentName;
    private String departmentManager;
    private String departmentLocation;
    private String employeeCount;


}
