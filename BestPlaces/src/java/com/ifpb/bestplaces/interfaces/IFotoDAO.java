package com.ifpb.bestplaces.interfaces;

import com.ifpb.bestplaces.entidades.Foto;
import java.sql.SQLException;
import java.util.List;

public interface IFotoDAO {

    public Foto read(int id, String tabela)
            throws SQLException, ClassNotFoundException;

    public boolean insert(Foto f, String tabela)
            throws SQLException, ClassNotFoundException;

    public boolean insertE(Foto f, String tabela)
            throws SQLException, ClassNotFoundException;

    public boolean delete(int id, String tabela)
            throws SQLException, ClassNotFoundException;

    public List<Foto> listarFotosLocal(int idLocal)
            throws SQLException, ClassNotFoundException;

    public int interatorFotos_Local(String tabela)
            throws SQLException, ClassNotFoundException;

    public Foto retornaFotoLocal(int idLocal)
            throws SQLException, ClassNotFoundException;

    public boolean insertFotosPresencaEvento(Foto f, String tabela)
            throws SQLException, ClassNotFoundException;
}
