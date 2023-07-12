/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package converters;

import dao.EquipeDAO;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import models.Equipe;

@Named(value = "equipeConverter")
@ApplicationScoped
public class EquipeConverter implements Converter<Equipe>{

    @Inject
    EquipeDAO dao;
    
    @Override
    public Equipe getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            int id = Integer.parseInt( value );
            return dao.findById( id );
        } catch(Exception ex) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Equipe value) {
        if ( value == null) {
            return null;
        }
        return String.valueOf( value.getId() );
    }
    
}
