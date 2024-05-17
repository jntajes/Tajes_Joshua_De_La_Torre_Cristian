package dao;

import model.Domicilio;
import model.Odontologo;
import model.Paciente;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements iDao<Odontologo>{
    /*private Integer numeroMatricula;
    private String nombre, apellido;*/
    private static final Logger logger= Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_SELECT_ALL="SELECT * FROM ODONTOLOGOS";
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS VALUES(?,?,?)";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection=null;
        try {
            connection= BD.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1,odontologo.getNumeroMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3,odontologo.getApellido());
            psInsert.execute();
            logger.info("se inserto el nuevo odontologo");
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
        logger.info("iniciando la operacion de listar todos los odontologos");
        Connection connection= null;
        List<Odontologo> listaOdontologos = new ArrayList<>();
        try{
            connection= BD.getConnection();
            PreparedStatement psSElectAll= connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs= psSElectAll.executeQuery();
            while (rs.next()){
                Odontologo odontologo= new Odontologo(rs.getInt(1), rs.getString(2), rs.getString(3));
                listaOdontologos.add(odontologo);
            }
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        return listaOdontologos;
    }
}
