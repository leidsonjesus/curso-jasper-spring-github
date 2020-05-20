<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Relatórios de Contatos</title>
</head>
<body>

	<h1>Relatório Grafico View</h1>
	<div>
		<a href="<c:url value="/jasper/findGraficoViewPdf/pdf" />">Abrir relatório em PDF</a>
	</div>
		<div>
		<a href="<c:url value="/jasper/findGraficoViewHtml/html" />">Abrir relatório em HTML</a> 
	</div>
	
	<hr>
	
	<form id="form" action="<c:url value="/jasper/findChecked"/>" method="get">
		<input type="hidden" id="format" name="format" value="">
		<div style="width: 960px; height: auto; margin: 0 auto;">
			<p><b>Gerar Relatórios por Filtro</b></p>
			<input type="submit" value="PDF" onclick="getElementById('format').value='pdf'">
			<input type="submit" value="HTML" onclick="getElementById('format').value='html'">
			
			Ordenar por <select name="orderBy" title="Order By">
				<option value=""></option>
				<option value="nome">Nome</option>
				<option value="endereco.cidade">Cidade</option>
			</select> |
			de forma <select name="direction" title="Direction">
				<option value=""></option>
				<option value="asc">ASC</option>
				<option value="desc">DESC</option>
			</select>			
		</div>
		<div style="overflow: auto; width: 960px; height: 320px; margin: 0 auto;">
			<table style="width: 940px;">
				<thead>
					<tr bgcolor="d6d6d6">
						<th>Ck</th>
						<th>Nome Do Contato</th>
						<th>Logradouro</th>
						<th>Bairro</th>
						<th>Cidade</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="c" items="${listaDeContatos}" varStatus="i">
					<tr bgcolor="${ i.count % 2 == 0 ? 'c6c6d6' : 'f1f1f1' }">
						<td style="width: 50px; text-align: center;">
							<input type="checkbox" name="id" value="${c.id}">
						</td>
						<td style="text-align: left;">${c.nome}</td>
						<td style="text-align: left;">${c.endereco.logradouro}, ${c.endereco.numero}</td>
						<td style="text-align: left;">${c.endereco.bairro}</td>
						<td style="text-align: left;">${c.endereco.cidade}</td>
					</tr>	
					</c:forEach>
				</tbody>
			</table>	
		</div>
	</form>
 	<div style="width: 960px; height: 30px; margin: 0 auto; padding-top: 5px; background-color: #d6c6c6;">
		<form action="<c:url value="/search" />" method="get"> 
			Nome: <input type="text" name="nome">
			Cidade: <input type="text" name="cidade">
			<input type="submit" value="Localizar">
		</form>
	</div> 
	
	<hr>

	<h1>Relatórios Via Links</h1>
	<div>
		<a href="<c:url value="/jasper/findAllPdf" />">Abrir relatório em PDF</a>
	</div>
	<div>
		<a href="<c:url value="/jasper/findAllHtml" />">Abrir relatório em HTML</a>
	</div>	
	<div>
		<a href="<c:url value="/jasper/findAllCsv" />">Abrir relatório em CSV</a>
	</div>
		
	<hr>
	
	<h1>Relatórios Via Formatos</h1>
	<div>
		<a href="<c:url value="/jasper/findByFormat?format=pdf" />">Abrir relatório em PDF</a>
	</div>
	<div>
		<a href="<c:url value="/jasper/findByFormat?format=html" />">Abrir relatório em HTML</a>
	</div>
	<div>
		<a href="<c:url value="/jasper/findByFormat?format=csv" />">Abrir relatório em CSV</a>
	</div>
</body>
</html>