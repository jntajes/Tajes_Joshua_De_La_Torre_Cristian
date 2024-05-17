import dao.BD;
import dao.OdontologoDAOCollection;
import model.Odontologo;
import model.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.OdontologoService;
import service.PacienteService;

import java.util.List;

public class OdontologoServiceTest {
    @Test
    public void guardarOdontolgo(){
        BD.crearTablas();
        OdontologoService odonotologoService= new OdontologoService();
        Odontologo odontologo1= new Odontologo(1,"Jose", "Perez");
        Odontologo odontologo= odonotologoService.guardarOdontologo(odontologo1);
        Assertions.assertTrue(odontologo!=null);
    }

    @Test
    public void buscarTodosOdontologos(){
        BD.crearTablas();
        OdontologoService odontologoService=new OdontologoService();
        Odontologo odontologo1= new Odontologo(1,"Jose", "Perez");
        Odontologo odontologo2= new Odontologo(2,"Lucas", "Perez");
        Odontologo odontologo3= new Odontologo(3,"Pedro", "Porra");
        odontologoService.guardarOdontologo(odontologo1);
        odontologoService.guardarOdontologo(odontologo2);
        odontologoService.guardarOdontologo(odontologo3);
        List<Odontologo> listaOdontologos= odontologoService.buscarTodosOdontologos();
        Assertions.assertTrue(listaOdontologos!=null);
    }

    @Test
    public void guardarOdontologoCollection(){
        OdontologoService odonotologoService= new OdontologoService();
        Odontologo odontologo1= new Odontologo(1,"Jose", "Perez");
        odonotologoService.guardarOdontologoCollection(odontologo1);
        Assertions.assertTrue(odontologo1!=null);
    }

    @Test
    public void buscarTodosOdontolgosCollection(){
        OdontologoService odonotologoService= new OdontologoService();
        List<Odontologo> listaOdontolodos= odonotologoService.buscarTodosOdontolgosCollection();
        Assertions.assertTrue(listaOdontolodos!=null);
    }
}
