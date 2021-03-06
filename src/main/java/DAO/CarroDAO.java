package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Carro;
import ultilidades.Conexao;

public class CarroDAO {

	public CarroDAO() {

	}

	public void addCarro(Carro newUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();

		try {
			PreparedStatement preStat = connection.prepareStatement("insert into carros (modelo, ano) values (?,?)");
			preStat.setString(1, newUser.getModelo());
			preStat.setDouble(2, newUser.getAno());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Carro> getListCarro() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Carro> lista = new ArrayList<Carro>();
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from carros");
			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
				Integer id2 = resultSet.getInt("id");
				String modelo = resultSet.getString("modelo");
				String ano = resultSet.getString("ano");
				Carro user = new Carro(modelo, Integer.parseInt(ano));
				user.setId(id2);
				lista.add(user);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void removeCarro(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();

		try {
			PreparedStatement preStat = connection.prepareStatement("delete from carros where id = ?");
			preStat.setInt(1, id);
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCarro(Carro updateUser) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();

		try {
			PreparedStatement preStat = connection
					.prepareStatement("update carros set modelo = ?, ano = ? where id = ?");
			preStat.setString(1, updateUser.getModelo());
			preStat.setDouble(2, updateUser.getAno());
			preStat.setInt(3, updateUser.getId());
			System.out.println(preStat);
			preStat.executeUpdate();
			System.out.println("Comando executado");
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Carro buscarCarro(Integer id) {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		Carro user = null;
		try {
			PreparedStatement preStat = connection.prepareStatement("select * from carros where id = ?");
			preStat.setInt(1, id);
			ResultSet resultSet = preStat.executeQuery();
			while (resultSet.next()) {

				Integer ida = resultSet.getInt("id");
				String modelo = resultSet.getString("modelo");
				String ano = resultSet.getString("ano");
				user = new Carro(modelo, Integer.parseInt(ano));
				user.setId(ida);

			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return user;
	}

}