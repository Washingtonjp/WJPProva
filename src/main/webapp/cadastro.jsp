<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Cadastro</title>
</head>

<body>
	<nav class="navbar navbar-light" style="background-color: #e3f2fd;">

		<h1>Trabalho Final WJP</h1>

	</nav>

	<div class="container mt-5">
		<div class="row">
			<div class="col-md-5 mx-auto border text-center">
				<h3>Cadastrar Veiculo</h3>
				<form method="post" action="ServletCarro">
					<input type="hidden" name="id" value="${user.id}" />

					<div class="form-group" style="text-align-last: left;">
						<label for="nome" class="form-label">Modelo:</label> <input
							type="text" class="form-control" name="modelo"
							value="${user.modelo}" required>
					</div>


					<div class="form-group" style="text-align-last: left;">
						<label for="email">Ano:</label> <input type="text"
							class="form-control" name="ano" value="${user.ano}" required>
					</div>
					<c:choose>
						<c:when test="${user == null}">
							<button type="submit" class="btn  btn-info col-2 mb-3 mt-3"
								name="option" value="insert">Salvar</button>
						</c:when>
						<c:otherwise>
							<button type="submit" class="btn  btn-info col-2 mb-3 mt-3"
								name="option" value="update">Atualizar</button>
						</c:otherwise>
					</c:choose>
				</form>
			</div>
		</div>
	</div>
</body>
</html>