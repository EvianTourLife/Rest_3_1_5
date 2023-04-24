$(async function() {
    await thisUser();
});
async function thisUser() {

    fetch("http://localhost:8080/api/getOneUser")
        .then(res => res.json())
        .then(data => {
            $('#headerEmail').append(data.email);
            let roles = data.roles.map(role => " " + role.role);
            $('#headerRoles').append(roles);
            let user = `$(
            <tr>
                <td>${data.id}</td>
                <td>${data.name}</td>
                <td>${data.surname}</td>
                <td>${data.age}</td>
                <td>${data.email}</td>
                <td>${data.roles.map(role => " " + role.role)}</td>)`;
            $('#userPanelBody').append(user);
        })
}
$(async function() {
    await thisAdmin();
});
async function thisAdmin() {

    fetch("http://localhost:8080/api/getOneUser")
        .then(res => res.json())
        .then(data => {
            let user = `$(
            <tr>
                <td>${data.id}</td>
                <td>${data.name}</td>
                <td>${data.surname}</td>
                <td>${data.age}</td>
                <td>${data.email}</td>
                <td>${data.roles.map(role => " " + role.role)}</td>)`;
            $('#adminPanelBody').append(user);
        })
}