package validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@ManagedBean
@ViewScoped
@Named("emailValidator") //VER SE FUNCIONA
public abstract class EmailValidator implements Validator {

    public void EmailValidator(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String email = value.toString();
        String regex = "^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email inválido", "O email informado é inválido.");
            context.addMessage(component.getClientId(), message);
        }
    }
}
