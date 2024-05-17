package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOCollection implements iDao<Odontologo>{
    /*private Integer numeroMatricula;
    private String nombre, apellido;*/
    private static final Logger logger= Logger.getLogger(OdontologoDAOCollection.class);
    List<Odontologo> listaOdontologos;

    public OdontologoDAOCollection() {
        listaOdontologos = new ArrayList<>();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        try {
            listaOdontologos.add(odontologo);
            logger.info("se inserto el nuevo odontologo a la lista");
        }catch (Exception e){
            logger.warn(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public Odontologo buscarPorId(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        listaOdontologos.forEach(odontologo -> logger.info("Nombre del odontologo es: "+odontologo.getNombre()+" "+odontologo.getApellido()+" con matricula "+odontologo.getNumeroMatricula()));
        return listaOdontologos;
    }
}
