<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
    <h2>TodoList</h2>
    <p>TodoList 목록입니다.</p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Status</th>
            <th>Title</th>
            <th>CreatedDate</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>true</td>
            <td>Title</td>
            <td>20100708</td>
            <td>📌</td>
            <td>🗑</td>
        </tr>
        <tr>
            <td>Mary</td>
            <td>Moe</td>
            <td>mary@example.com</td>
            <td>📌</td>
            <td>🗑</td>
        </tr>
        <tr>
            <td>July</td>
            <td>Dooley</td>
            <td>july@example.com</td>
            <td>📌</td>
            <td>🗑</td>
        </tr>
        </tbody>
    </table>
</div>


<button type="button" class="btn btn-primary">Add</button>
<button type="button" class="btn btn-secondary">Delete</button>
</body>
</html>
