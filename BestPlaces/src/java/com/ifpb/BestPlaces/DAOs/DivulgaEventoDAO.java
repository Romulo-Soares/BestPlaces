package com.ifpb.BestPlaces.DAOs;

import com.ifpb.BestPlaces.Conexao.ConFactory;
import com.ifpb.BestPlaces.Entidades.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivulgaEventoDAO {

    public boolean insert(int idEvento, String usuario)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO divulgacao_evento (id_evento, usuario) "
                + "VALUES (?,?)");

        stmt.setInt(1, idEvento);
        stmt.setString(2, usuario);

        boolean retorno = stmt.executeUpdate() > 0;

        con.close();
        return retorno;

    }

    public boolean delete(int idEvento)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM divulgacao_evento WHERE id_evento = ?");

        stmt.setInt(1, idEvento);

        boolean retorno = stmt.executeUpdate() > 0;

        con.close();
        return retorno;

    }

    public List<Evento> eventosDivulgados(String usuario)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * "
                + "FROM evento "
                + "WHERE ID = "
                + "(SELECT de.ID_Evento "
                + "FROM Divulgacao_Evento de "
                + "WHERE de.usuario IN "
                + "(SELECT CASE "
                + "	WHEN usuario_interaginte = ? and amizade = true "
                + "		THEN usuario_interagido "
                + "	WHEN usuario_interagido = ? and amizade = true "
                + "		THEN usuario_interaginte "
                + "        END AS amigos "
                + "FROM interacao))");

        stmt.setString(1, usuario);
        stmt.setString(2, usuario);

        ResultSet rs = stmt.executeQuery();

        List<Evento> eventos = new ArrayList<>();

        while (rs.next()) {
            Evento evento = new Evento();
            evento.setId(rs.getInt("id"));
            evento.setUsuario(rs.getString("usuario"));
            evento.setIdLocal(rs.getInt("id_Local"));
            evento.setNome(rs.getString("nome"));
            evento.setData(rs.getString("data"));
            evento.setHora(rs.getString("hora"));
            evento.setLocal(rs.getString("local"));
            evento.setDescricao(rs.getString("descricao"));

            eventos.add(evento);

        }
        con.close();
        return eventos;
    }

}
