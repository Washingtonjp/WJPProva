<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">

<nav class="navbar navbar-light" style="background-color: #e3f2fd;">

	<h1>Trabalho Final WJP</h1>

</nav>

<div class="container mt-5">
	<div class="row">
		<div class="col-md-5 mx-auto border text-center">
			<h3>Cadastrar IPVA</h3>
			<form method="post" action="ServletIpva">
				<input type="hidden" name="id" value="${ipva.id}" />

				<div class="form-group" style="text-align-last: left;">
					<label for="nome" class="form-label">Ano:</label> <input
						type="text" class="form-control" name="ano" value="${ipva.ano}"
						required>
				</div>

				<button type="submit" class="btn  btn-info col-2 mb-3 mt-3"
					name="option" value="update">Salvar</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>