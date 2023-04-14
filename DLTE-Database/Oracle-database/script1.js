const form = document.getElementById('payee-form');
const errorMessage = document.getElementById('error-message');

form.addEventListener('submit', (event) => {
  event.preventDefault();

  const name = document.getElementById('name').value.trim();
  const email = document.getElementById('email').value.trim();
  const accountNumber = document.getElementById('account-number').value.trim();

  if (!name || !email || !accountNumber) {
    errorMessage.textContent = 'Please fill in all fields.';
    return;
  }

  if (!isValidEmail(email)) {
    errorMessage.textContent = 'Please enter a valid email address.';
    return;
  }

  if (!isValidAccountNumber(accountNumber)) {
    errorMessage.textContent = 'Please enter a valid account number.';
    return;
  }

  // If all validation passes, we can submit the form
  form.submit();
});

function isValidEmail(email) {
  // Basic email validation using a regular expression
  const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return regex.test(email);
}

function isValidAccountNumber(accountNumber) {
  // Basic account number validation - must be a string of numbers only
  const regex = /^[0-9]+$/;
  return regex.test(accountNumber);
}