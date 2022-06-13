<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div style="padding: 25px;" class="container-md">

    <div class="row">
        <div class="col-9">
            <div class="card">
                <table class="table table-striped">
                    <thead class="thead-light">
                        <tr>
                            <th>#</th>
                            <th>Código</th>
                            <th>Nombre</th>
                            <th>Update</th>
                            <th># Fac</th>
                            <th></th>
                        </tr>
                    </thead>

                    <tbody>
                        <c:forEach var="curso" items="${cursos}">
                            <tr>
                                <td>${curso.idCurso}</td>
                                <td>${curso.codigoCurso}</td>
                                <td>${curso.nombreCurso}</td>
                                <td>${curso.lastUpdateCurso}</td>
                                <td>${curso.idFacilitadorFK}</td>
                                <td><a href="${pageContext.request.contextPath}/Curso?accion=editar&idCurso=${curso.idCurso}"
                                       class="btn btn-secondary">
                                        <i class="fas fa-angle-double-right"></i> Editar
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="col-3">

            <div>
                <jsp:include page="cursoAgregar.jsp"/>
            </div>

            <div class="card text-center bg-success text-white mb-3">
                <div class="card-body">
                    <h3>Cantidad de cursos</h3>
                    <h5 class="display-4">
                        <i class="fas fa-users"></i> ${totalCursos}
                    </h5>
                </div>
            </div>
        </div>
    </div>
</div>


