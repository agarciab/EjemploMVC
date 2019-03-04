<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
	<h2>Persona Form</h2>
	<div>
		<form action="plus1" method="post">
			Nombre: <input type="text" name="nombre" value="" /> <br />
			Apellidos: <input type="text" name="apellidos" value="" /> <br />
			Edad: <input type="text" name="edad" value="" /> <br />
			<input type="submit" value="Enviar" />
		</form>
	</div>
</body>
</html>
