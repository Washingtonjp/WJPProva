package Controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CarroDAO;
import DAO.IpvaDAO;
import entidades.Carro;
import entidades.Ipva;


@WebServlet("/ServletCarro")
public class ServletCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CarroDAO carrodao;
    private Ipva ipva;
    private IpvaDAO ipvadao;
   
    public ServletCarro() {
        super();
        carrodao = new CarroDAO();
        ipva = new Ipva(0);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		String modelo = request.getParameter("modelo");
		String ano = request.getParameter("ano");
		
		String option = request.getParameter("option");
		
		
		if(option.equals("insertForm")) {
			InsertForm(request, response);
			
		}else if (option.equals("updateForm")) {
			UpdateForm(request, response);
			
		}else if (option.equals("atualizarpag")) {
			ListListar(request, response);
			
			
		} else if (option.equals("update")) {
			Update(request, response); 
			
		} else if (option.equals("delete")) {
			Delete(request, response);
		
		} else if (option.equals("insert")) {
			if ((modelo != null)  && (ano!= null)) {
				if (!modelo.equals("")){
					carrodao = new CarroDAO();
					 Carro carro = new Carro(modelo,  Integer.parseInt(ano));
					 carrodao.addCarro(carro);
				}
			}
			
		}				
		request.setAttribute("lista", carrodao.getListCarro());
		request.setAttribute("resultado", ipva.retornarAno());
		request.setAttribute("comIpva", ipva.ComIpva());
		request.setAttribute("semIpva", ipva.SemIpva());
		
		request.getRequestDispatcher("/").forward(request, response);			
	}
	
	
	protected void InsertForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);		
	}
	
	protected void ListListar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("listaCar", carrodao.getListCarro() ); 	
	request.setAttribute("ipva", ipva.retornarAno() );
	}
	

	protected void chamandoIPVA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id"); 
		Integer ano = Integer.parseInt(request.getParameter("ano"));
		ipva = new Ipva(ano);
		request.setAttribute("ipva", ipva);
		request.getRequestDispatcher("/").forward(request, response);
	}
	
	
	protected void UpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		Integer id1 = Integer.parseInt(id);
		Carro userBuscar=  carrodao.buscarCarro(id1);
		request.setAttribute("user", userBuscar);
		request.getRequestDispatcher("cadastro.jsp").forward(request, response);		
	}
	
	protected void Update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String modelo = request.getParameter("modelo");
		String ano = request.getParameter("ano");
		
		
		
		if ((modelo != null)  && (ano != null)) {
			if (!modelo.equals("")){
				carrodao = new CarroDAO();
				Integer id1 = Integer.parseInt(id);
				Carro carro1 = new Carro(modelo,  Integer.parseInt(ano));
				carro1.setId(id1);
				carrodao.updateCarro(carro1);		
			}
		} 		
	}
	
	
	
	protected void Delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != null) {
			Integer id1 = Integer.parseInt(id);
			carrodao = new CarroDAO();
			carrodao.removeCarro(id1);
		}		
	}
	
	
	protected void Insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String modelo = request.getParameter("modelo");
		String ano = request.getParameter("ano");
		
		if ((modelo != null) && (ano!= null)) {
			if (!modelo.equals("")){
				carrodao = new CarroDAO();
				 Carro carro = new Carro(modelo, Integer.parseInt(ano));
				 carrodao.addCarro(carro);
			}
		}	
	}
	
}
