package entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ultilidades.Conexao;

public class Ipva {
	private Integer id;
	private Integer ano;
	private Integer comIPVA = 0;
	private Integer semIPVA = 0;
	private Integer cont = 0;

	public Ipva(Integer ano) {
		super();
		this.ano = ano;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getComIPVA() {
		return comIPVA;
	}

	public void setComIPVA(Integer comIPVA) {
		this.comIPVA = comIPVA;
	}

	public Integer getSemIPVA() {
		return semIPVA;
	}

	public void setSemIPVA(Integer semIPVA) {
		this.semIPVA = semIPVA;
	}

	public Integer getCont() {
		return cont;
	}

	public void setCont(Integer cont) {
		this.cont = cont;
	}

	public String SemIpva() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Ipva> lista = new ArrayList<Ipva>();
		int comIpva = 0;
		String qntRetorno = "";
		try {
			PreparedStatement preStat = connection.prepareStatement(
					"select carros.ano " + "from carros " + "join ipva " + "on carros.ano <= ipva.ano");
			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
				comIpva++;
				qntRetorno = String.valueOf(comIpva);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qntRetorno;

	}

	public String ComIpva() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Ipva> lista = new ArrayList<Ipva>();
		int comIpva = 0;
		String qntRetorno = "";
		try {
			PreparedStatement preStat = connection.prepareStatement(
					"select carros.ano " + "from carros " + "join ipva " + "on carros.ano > ipva.ano");
			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
				comIpva++;
				qntRetorno = String.valueOf(comIpva);
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qntRetorno;

	}

	public String retornarAno() {
		Conexao conexao = Conexao.getInstance();
		Connection connection = conexao.getConnection();
		ArrayList<Ipva> lista = new ArrayList<Ipva>();
		String qntRetorno = "";
		try {
			PreparedStatement preStat = connection.prepareStatement("select ipva.ano from ipva");
			ResultSet resultSet = preStat.executeQuery();

			while (resultSet.next()) {
				qntRetorno = resultSet.getString("ano");
			}
			resultSet.close();
			preStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return qntRetorno;

	}

}
