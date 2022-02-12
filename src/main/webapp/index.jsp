<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<title>Lista Carro</title>
</head>

<body>
	<header>

		<nav class="navbar navbar-light" style="background-color: #e3f2fd;">

			<h1>Trabalho Final WJP</h1>

		</nav>

		<div class="container mt-5">
			<div class="row justify-content-center">
				<h1 class=col-10>Lista de Veiculos</h1>
				<hr class="mt-5">
			</div>
		</div>
	</header>

	<div class="container">
		<form action="ServletCarro" method="post" class="mt-5">
			<button type="submit" class="btn  btn-info mb-3" name="option"
				value="insertForm">Adicionar Veiculo</button>
			<button type="submit" class="btn  btn-info mb-3" name="option"
				value="atualizarpag">Atualizar Página</button>
		</form>


		<table class="table mt-5 col-6">
			<thead class="thead-dark">
				<tr>
					<th scope="col">Id</th>
					<th scope="col">Modelo</th>
					<th scope="col">Ano</th>
					<th scope="col">Ipva</th>
					<th scope="col">Açoes</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="Car" items="${listaCar}">
					<form action="ServletCarro" method="post">
						<tr>
							<input type="hidden" name="id" value="${Car.id}" />

							<td>${Car.id}</td>
							<td>${Car.modelo}</td>
							<td>${Car.ano}</td>
							<td><c:choose>
									<c:when test="${ipva <= Car.ano}">
										 Com Ipva
									</c:when>
									<c:otherwise>
										Sem Ipva
									</c:otherwise>
								</c:choose></td>

							<td>
								<button type="submit" name="option" value="updateForm"
									class=" btn-info btn ">Alterar</button>
								<button type="submit" name="option" value="delete"
									class=" btn-info btn ">delete</button>
							</td>
						</tr>
					</form>
				</c:forEach>

				<form action="ServletIpva" method="post">
					<table class="table mt-5">
						<tr>
							<th scope="col">Tabelas IPVA</th>
							<th scope="col">Quantidade</th>
							<th scope="col">Ano Base : ${requestScope.ipva}</th>
							<th scope="col">
								<button type="submit" name="option" value="update"
									class=" btn-info btn ">Alterar</button>

							</th>
							</form>
						<tr>
						<tr>
							<td>Com ipva</td>
							<td>${requestScope.comIpva}</td>

						</tr>
						<tr>
							<td>Sem Ipva</td>
							<td>${requestScope.semIpva}</td>

						</tr>
						<td>Total de Carros</td>
						<td>${requestScope.comIpva + requestScope.semIpva}</td>

						</tr>

					</table>
				</form>

			</tbody>
		</table>
	</div>
</body>
</html>