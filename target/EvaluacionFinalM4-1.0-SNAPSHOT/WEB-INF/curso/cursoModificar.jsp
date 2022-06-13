<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <!-- Head -->
    <jsp:include page="/WEB-INF/comunes/head.jsp"/>

    <body>
        <!-- Header -->
        <jsp:include page="/WEB-INF/comunes/header.jsp"/>


        <form action="${pageContext.request.contextPath}/Curso?accion=modificar&curso.idCurso=${curso.idCurso}"
              method="POST" class="was-validated">

            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar curso con ID: ${curso.idCurso}</h4>
                                </div>

                                <div class="card-body">

                                    <div class="form-group">
                                        <label for="apellido">ID</label>
                                        <input type="text" class="form-control" name="id" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="apellido">Código</label>
                                        <input type="text" class="form-control" name="codigo" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="text">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="text">ID Facilitador</label>
                                        <input type="text" class="form-control" name="idFac" required>
                                    </div>

                                    <div class="row">
                                        <div class="col-3">
                                            <button type="submit" class="btn btn-success btn-block">
                                                <i class="fas fa-check"></i> Guardar Curso
                                            </button>
                                        </div>
                                        <br>
                                        <div class="col-3">
                                            <a href="${pageContext.request.contextPath}/Curso?accion=eliminar&idCurso=${curso.idCurso}"
                                               class="btn btn-danger btn-block">
                                                <i class="fas fa-trash"></i> Eliminar Curso
                                            </a>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </form>

    </body>
</html>