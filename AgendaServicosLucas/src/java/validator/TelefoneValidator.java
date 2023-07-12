/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
@Named("telefoneValidator") //VER SE FUNCIONA
public abstract class TelefoneValidator implements Validator {

    public void TelefoneValidator(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String telefone = value.toString();
        String regex = "^\\(\\d{2}\\) \\d{4,5}-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(telefone);

        if (!matcher.matches()) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Telefone inválido", "O telefone informado é inválido. Utilize o formato (99) 99999-9999.");
            context.addMessage(component.getClientId(), message);
        }
    }
}
