package converters;

import dao.TipoServicoDAO;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import models.TipoServico;

@Named(value = "tipoServicoConverter")
@ApplicationScoped
public class TipoServicoConverter implements Converter<TipoServico>{

    @Inject
    TipoServicoDAO dao;
    
    @Override
    public TipoServico getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            int id = Integer.parseInt( value );
            return dao.findById( id );
        } catch(Exception ex) {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, TipoServico value) {
        if ( value == null) {
            return null;
        }
        return String.valueOf( value.getId() );
    }
    
}
