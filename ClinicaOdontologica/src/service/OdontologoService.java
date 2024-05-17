package service;

import dao.OdontologoDAOCollection;
import dao.OdontologoDAOH2;
import dao.iDao;
import model.Odontologo;
import model.Paciente;

import java.util.List;

public class OdontologoService {
    private iDao<Odontologo> odonotologoiDao;
    private iDao<Odontologo> odontologoiDaoCollection;
    public OdontologoService() {
        odonotologoiDao = new OdontologoDAOH2();
        odontologoiDaoCollection = new OdontologoDAOCollection();
    }
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odonotologoiDao.guardar(odontologo);
    }
    public List<Odontologo> buscarTodosOdontologos(){
        return odonotologoiDao.buscarTodos();
    }
    public Odontologo guardarOdontologoCollection(Odontologo odontologo){
        return odontologoiDaoCollection.guardar(odontologo);
    }
    public List<Odontologo> buscarTodosOdontolgosCollection(){
        return odontologoiDaoCollection.buscarTodos();
    }
}
