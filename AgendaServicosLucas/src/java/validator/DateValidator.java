/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@Named("dateValidator") //VER SE FUNCIONA
public abstract class DateValidator implements Validator{
    public void DateValidator(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String inputDate = value.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        try {
            Date date = sdf.parse(inputDate);

            // Verifica se a data é posterior à data atual
            Date currentDate = new Date();
            if (date.after(currentDate)) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data inválida", "A data não pode ser posterior à data atual.");
                context.addMessage(component.getClientId(), message);
            }
        } catch (ParseException e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Data inválida", "Formato de data inválido. Utilize o formato dd/MM/yyyy.");
            context.addMessage(component.getClientId(), message);
        }
    }
}
