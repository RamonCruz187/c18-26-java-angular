// register.component.js
function togglePasswordVisibility() {
  const passwordInput = document.getElementById('password');
  const type = passwordInput.getAttribute('type') === 'password' ? 'text' : 'password';
  passwordInput.setAttribute('type', type);
}

function validateForm() {
  const emailInput = document.getElementById('email');
  const email = emailInput.value;
  const emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

  if (!emailPattern.test(email)) {
      alert('Por favor, ingrese un correo electrónico válido.');
      emailInput.focus();
      return false;
  }

  // Continue with form submission if email is valid
  // Add additional validation if needed
}
