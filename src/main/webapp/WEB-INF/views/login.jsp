
<!DOCTYPE html>
<html lang="en">
	
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <style>
    /* Global Styles */
    body {
      font-family: 'Roboto', sans-serif;
      background-color: #f5f5f5;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }

    /* Form Styles */
    .form-container {
      background-color: #fff;
      padding: 4rem;
      border-radius: 0.5rem;
      box-shadow: 0 4px 6px -1px rgba(0, 0, 0, 0.1), 0 2px 4px -1px rgba(0, 0, 0, 0.06);
      max-width: 400px;
      width: 100%;
    }

    .form-container h1 {
      text-align: center;
      margin-bottom: 1.5rem;
      color: #1a202c;
    }

    .form-group {
      margin-bottom: 1.5rem;
    }

    .form-group label {
      display: block;
      font-weight: 500;
      color: #4a5568;
      margin-bottom: 0.5rem;
    }

    .form-group input {
      width: 100%;
      padding: 0.75rem;
      border: 1px solid #e2e8f0;
      border-radius: 0.375rem;
      font-size: 1rem;
      color: #1a202c;
      transition: border-color 0.2s ease-in-out;
    }
	
	.error{
		text-align:center;
		color:red;
	}

    .form-group input:focus {
      outline: none;
      border-color: #4299e1;
    }

    .submit-button {
      display: block;
      width: 100%;
      background-color: #4299e1;
      color: #fff;
      font-weight: 500;
      padding: 0.75rem 1rem;
      border: none;
      border-radius: 0.375rem;
      font-size: 1rem;
      cursor: pointer;
      transition: background-color 0.2s ease-in-out;
    }

    .submit-button:hover {
      background-color: #3182ce;
    }

    .form-footer {
      text-align: center;
      margin-top: 1rem;
      color: #718096;
    }

    .form-footer a {
      color: #4299e1;
      text-decoration: none;
    }

    .form-footer a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
  <div class="form-container">
    <h1>Login</h1>
    <h3 class="error">${msg}</h3>
    <form action="login" method="post">
      <div class="form-group">
        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>
      </div>
      <button type="submit" class="submit-button">Login</button>
    </form>
    <div class="form-footer">
      Don't have an account? <a href="/">Sign up</a>
    </div>
  </div>
</body>
</html>