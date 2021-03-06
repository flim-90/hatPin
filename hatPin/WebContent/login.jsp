<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="css/hatPin.css">
  <style>
  </style>
  <title>Portale d'accesso</title>
</head>
<body>
  <div class="generico">
  <!--  <div class="circle"><h1 class="text" class="card-title"  id="nomeApp">hat<font color = #D93223v>P</font>in</h1></div>-->
  <img src="./immagini/logoHatPin.png" class="logoHatPin">
    <form action="logIn" method="post">
      <div class="card text-center bg-custom">
      <div class="card-body">
      <div class="form-group">
        <label class="text" for="username">Username</label>
        <input name="username" type="text" class="form-control" id="username">
      </div>
      <div class="form-group">
        <label class="text" for="password">Password</label>
        <input name="password" type="password" class="form-control" id="password">
      </div>
      <div id="errori"><p class="text">${errore_login}</p></div>
      <button type="submit" class="btn btn-info btn-outline-light" id="submitButton">Submit</button>
    </form>
  </div>
</div>
</div>
</div>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>
