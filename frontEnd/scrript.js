const BASE_URL = "http://localhost:9090/employees";
const tableBody = document.getElementById("employeeTableBody");
const form = document.getElementById("employeeForm");

// 🟢 Fetch all employees
async function fetchEmployees() {
  const response = await fetch(BASE_URL);
  const data = await response.json();

  tableBody.innerHTML = ""; // Clear previous rows
  data.forEach(emp => {
    const row = `
      <tr>
        <td>${emp.id}</td>
        <td>${emp.name}</td>
        <td>${emp.email}</td>
        <td>${emp.position}</td>
        <td>${emp.salary}</td>
        <td>
          <button onclick="deleteEmployee(${emp.id})">🗑️ Delete</button>
        </td>
      </tr>
    `;
    tableBody.innerHTML += row;
  });
}

// 🟢 Add new employee
form.addEventListener("submit", async (e) => {
  e.preventDefault();

  const employee = {
    name: document.getElementById("name").value,
    email: document.getElementById("email").value,
    position: document.getElementById("position").value,
    salary: document.getElementById("salary").value
  };

  await fetch(BASE_URL, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(employee)
  });

  form.reset();
  fetchEmployees();
});

// 🔴 Delete employee
async function deleteEmployee(id) {
  await fetch(`${BASE_URL}/${id}`, { method: "DELETE" });
  fetchEmployees();
}

// Load employees on page load
fetchEmployees();
