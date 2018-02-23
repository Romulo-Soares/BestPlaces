package com.ifpb.bestplaces.daos;

import com.ifpb.bestplaces.conexao.ConFactory;
import com.ifpb.bestplaces.entidades.Local;
import com.ifpb.bestplaces.entidades.PostagemPresencaLocais;
import com.ifpb.bestplaces.entidades.PresencaLocal;
import com.ifpb.bestplaces.interfaces.IPresencaLocalDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PresencaLocalDAO implements IPresencaLocalDAO {

    @Override
    public boolean presenciarLocal(PresencaLocal pl)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "INSERT INTO presenca_local (id_local, usuario, comentario, status, data) "
                + "VALUES (?,?,?,?,?)");

        stmt.setInt(1, pl.getIdLocal());
        stmt.setString(2, pl.getUsuario());
        stmt.setString(3, pl.getComentario());
        stmt.setString(4, pl.getStatus());
        stmt.setString(5, pl.getData());

        boolean retorno = stmt.executeUpdate() > 0;

        con.close();
        return retorno;

    }

    @Override
    public boolean isMarked(PresencaLocal pl)
            throws ClassNotFoundException, SQLException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "select * from presenca_local "
                + "where id_local = ? and usuario = ? and data = ?");

        stmt.setInt(1, pl.getIdLocal());
        stmt.setString(2, pl.getUsuario());
        stmt.setString(3, pl.getData());

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
    public boolean isMarked(int idLocal, String usuario)
            throws ClassNotFoundException, SQLException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "select * from presenca_local "
                + "where id_local = ? and usuario = ?");

        stmt.setInt(1, idLocal);
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
    public List<PostagemPresencaLocais> listaLocaisPresenciados(String usuario)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "select l.id, l.nome, l.rua, l.cidade, l.descricao, l.estado, l.tipo, "
                        + "pl.usuario, pl.comentario, pl.status, pl.data "
                + "from interacao i, local l JOIN presenca_local pl ON "
                + "	l.id = pl.id_local "
                + "where ((pl.usuario = i.usuario_interaginte "
                + "	and i.amizade = true "
                + "		and i.usuario_interagido = ?) "
                + "	or (pl.usuario = i.usuario_interagido "
                + "		and i.amizade = true "
                + "			and i.usuario_interaginte = ?))");

        stmt.setString(1, usuario);
        stmt.setString(2, usuario);

        ResultSet rs = stmt.executeQuery();

        List<PostagemPresencaLocais> ps = new ArrayList<>();

        while (rs.next()) {
            PostagemPresencaLocais p = new PostagemPresencaLocais();
            p.setCidadeLocal(rs.getString("cidade"));
            p.setComentarioPresenciador(rs.getString("comentario"));
            p.setDataPresenca(rs.getString("data"));
            p.setDescricaoLocal(rs.getString("descricao"));
            p.setEstadoLocal(rs.getString("estado"));
            p.setNomeLocal(rs.getString("nome"));
            p.setRuaLocal(rs.getString("rua"));
            p.setStatusPresenciador(rs.getString("status"));
            p.setTipoLocal(rs.getString("tipo"));
            p.setUsuarioPresenciador(rs.getString("usuario"));
            p.setIdLocal(rs.getString("id"));

            ps.add(p);

        }
        con.close();
        return ps;
    }

}
