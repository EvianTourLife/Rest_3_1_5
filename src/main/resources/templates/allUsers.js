async function getAllUsers() {
    const res = await fetch('http://localhost:8080/api/users');
    const users = await res.json();
    console.log(users);
    users.forEach(user => usersForHTML(user));
}

window.addEventListener('DOMContentLoaded', getAllUsers);

function usersForHTML({id, name, surname, age, password, username, email, role}) {
    const usersList = document.getElementById('#mainTableWithUsers');
    usersList.insertAdjacentHTML('beforeend', `
                                <tr>
                            <td>${id}</td>
                            <td>${name}</td>
                            <td>${surname}</td>
                            <td>${age}</td>
                            <td>${password}</td>
                            <td>${username}</td>
                            <td>${email}</td>
                            <td>${role}</td>
                            <td>
                                <button type="button" data-userid="${id}" data-action="edit" class="btn btn-outline-secondary"
                                data-toggle="modal" data-target="#someDefaultModal"></button>
                            </td>
                            <td>
                                <button type="button" data-userid="${id}" data-action="delete" class="btn btn-outline-danger"
                                data-toggle="modal" data-target="#someDefaultModal"></button>
                            </td>
                        </tr>
`)
};









