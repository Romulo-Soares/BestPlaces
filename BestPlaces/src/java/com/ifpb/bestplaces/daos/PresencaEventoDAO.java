package com.ifpb.bestplaces.daos;

import com.ifpb.bestplaces.conexao.ConFactory;
import com.ifpb.bestplaces.entidades.Evento;
import com.ifpb.bestplaces.entidades.PostagemPresencaEventos;
import com.ifpb.bestplaces.entidades.PresencaEvento;
import com.ifpb.bestplaces.interfaces.IPresencaEventoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PresencaEventoDAO implements IPresencaEventoDAO {

    @Override
    public boolean presenciarEvento(PresencaEvento pe)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO Presenca_Evento (ID_Evento, Usuario, "
                + "Comentario, Status, Data) VALUES (?,?,?,?,?)");

        stmt.setInt(1, pe.getIdEvento());
        stmt.setString(2, pe.getUsuario());
        stmt.setString(3, pe.getComentario());
        stmt.setString(4, pe.getStatus());
        stmt.setString(5, pe.getData());

        boolean retorno = stmt.executeUpdate() > 0;

        con.close();
        return retorno;

    }

    @Override
    public boolean isMarked(PresencaEvento pe)
            throws ClassNotFoundException, SQLException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "select * from presenca_evento "
                + "where id_evento = ? and usuario = ? and data = ?");

        stmt.setInt(1, pe.getIdEvento());
        stmt.setString(2, pe.getUsuario());
        stmt.setString(3, pe.getData());

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            con.close();
            return true;
        } else {
            con.close();
            return false;
        }
    }

    @Override
    public boolean isMarked(int idEvento, String usuario)
            throws ClassNotFoundException, SQLException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "select * from presenca_evento "
                + "where id_evento = ? and usuario = ?");

        stmt.setInt(1, idEvento);
        stmt.setString(2, usuario);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            con.close();
            return true;
        } else {
            con.close();
            return false;
        }
    }

    @Override
    public List<PostagemPresencaEventos> listaEventosPresenciados(String usuario)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "select e.id, e.usuario as usuarioCriador, e.id_local, e.nome, e.data as dataEvento, "
                + "	e.hora, e.local, e.descricao, pe.id_evento, pe.usuario as usuarioPresenca, "
                + "		pe.comentario, pe.status, pe.data as dataPresenca "
                + "from interacao i, evento e JOIN presenca_evento pe ON "
                + "	e.id = pe.id_evento "
                + "where ((pe.usuario = i.usuario_interaginte "
                + "	and i.amizade = true "
                + "		and i.usuario_interagido = ?) "
                + "	or (pe.usuario = i.usuario_interagido "
                + "		and i.amizade = true "
                + "			and i.usuario_interaginte = ?))");

        stmt.setString(1, usuario);
        stmt.setString(2, usuario);

        ResultSet rs = stmt.executeQuery();

        List<PostagemPresencaEventos> ps = new ArrayList<>();

        while (rs.next()) {
            Evento e = new Evento();
            e.setId(rs.getInt("id"));
            e.setUsuario(rs.getString("usuarioCriador"));
            e.setIdLocal(rs.getInt("id_local"));
            e.setNome(rs.getString("nome"));
            e.setData(rs.getString("dataEvento"));
            e.setHora(rs.getString("hora"));
            e.setLocal(rs.getString("local"));
            e.setDescricao(rs.getString("descricao"));
            
            PresencaEvento pe = new PresencaEvento();
            pe.setIdEvento(rs.getInt("id_evento"));
            pe.setUsuario(rs.getString("usuarioPresenca"));
            pe.setComentario(rs.getString("comentario"));
            pe.setStatus(rs.getString("status"));
            pe.setData(rs.getString("dataPresenca"));
            
            PostagemPresencaEventos ppe = new PostagemPresencaEventos();
            ppe.setEvento(e);
            ppe.setPresencaEvento(pe);

            ps.add(ppe);

        }
        con.close();
        return ps;
    }

}
