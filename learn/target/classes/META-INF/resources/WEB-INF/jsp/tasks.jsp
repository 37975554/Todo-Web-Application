<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tasks</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<c:url value='/WEB-INF/css/styles.css' />">
</head>
<body>
    <div class="container mt-5">
        <div class="row">
            <!-- Left Navbar -->
            <div class="col-md-3">
                <ul class="list-group">
                    <li class="list-group-item">
                        <a href="create-task" class="btn btn-primary btn-block">Create Tasks</a>
                    </li>
                    <li class="list-group-item">
                        <a href="updateTask" class="btn btn-secondary btn-block">Update Tasks</a>
                    </li>
                    <li class="list-group-item">
                        <a href="update-profile" class="btn btn-secondary btn-block">Update Profile</a>
                    </li>
                </ul>
            </div>

            <!-- Main Content -->
            <div class="col-md-9">
                <h2 class="text-center">Todo Tasks</h2>
                <div class="task-list">
                    <c:forEach items="${todoTasks}" var="task">
                        <div class="card mb-3">
                            <div class="card-body">
                                <h5 class="card-title">${task.description}</h5>
                                <p class="card-text">${task.date}</p>
                            </div>
                        </div>
                    </c:forEach>

                    <h2 class="text-center">Finished Tasks</h2>
                    <div class="task-list">
                        <c:forEach items="${finishedTasks}" var="task">
                            <div class="card mb-3">
                                <div class="card-body">
                                    <h5 class="card-title">${task.description}</h5>
                                    <p class="card-text">${task.date}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
