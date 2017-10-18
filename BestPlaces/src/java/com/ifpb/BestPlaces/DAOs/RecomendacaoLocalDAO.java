package com.ifpb.BestPlaces.DAOs;

import com.ifpb.BestPlaces.Conexao.ConFactory;
import com.ifpb.BestPlaces.Entidades.Local;
import com.ifpb.BestPlaces.Entidades.RecomendacaoLocal;
import com.ifpb.BestPlaces.Interfaces.IRecomendacaoLocalDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecomendacaoLocalDAO implements IRecomendacaoLocalDAO {

    @Override
    public boolean recomendaLocal(RecomendacaoLocal rl) throws SQLException, ClassNotFoundException {
        if (new InteracaoUsuarioDAO().isFriend(rl.getUsuario_recomendador(), rl.getUsuario_destino())) {
            Connection con = ConFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(
                    "INSERT INTO recomendacao_local (usuario_recomendador, usuario_destino, id_local) "
                    + "VALUES (?,?,?)");

            stmt.setString(1, rl.getUsuario_recomendador());
            stmt.setString(2, rl.getUsuario_destino());
            stmt.setInt(3, rl.getId_local());

            boolean retorno = stmt.executeUpdate() > 0;

            con.close();
            return retorno;
        }
        return false;
    }

    @Override
    public boolean isRecommended(RecomendacaoLocal rl)
            throws ClassNotFoundException, SQLException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "select * from recomendacao_local "
                + "where usuario_recomendador = ? and "
                + "usuario_destino = ? and "
                + "id_local = ?");

        stmt.setString(1, rl.getUsuario_recomendador());
        stmt.setString(2, rl.getUsuario_destino());
        stmt.setInt(3, rl.getId_local());

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
    public List<Local> listaLocaisRecomendados(String usuario)
            throws SQLException, ClassNotFoundException {

        Connection con = ConFactory.getConnection();
        PreparedStatement stmt = con.prepareStatement(
                "select * from local "
                + "where id in "
                + "(select id_local "
                + "from recomendacao_local "
                + "where usuario_destino = ?)");

        stmt.setString(1, usuario);

        ResultSet rs = stmt.executeQuery();

        List<Local> locais = new ArrayList<>();

        while (rs.next()) {
            Local local = new Local();
            local.setId(rs.getInt("id"));
            local.setUsuario(rs.getString("usuario"));
            local.setNome(rs.getString("nome"));
            local.setRua(rs.getString("rua"));
            local.setCidade(rs.getString("cidade"));
            local.setDescricao(rs.getString("descricao"));
            local.setEstado(rs.getString("estado"));
            local.setTipo(rs.getString("tipo"));

            locais.add(local);

        }
        con.close();
        return locais;
    }

}
