package muzi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.struts.action.ActionForm;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserActionForm extends ActionForm {
    private int user_id;
    private String user_name;
    private String user_pwd;
    private int user_age;
}
