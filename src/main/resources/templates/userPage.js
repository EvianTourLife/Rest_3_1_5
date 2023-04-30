$(async function() {
    await thisUser();
});
async function thisUser() {

    fetch("http://localhost:8080/api/user/getAuthorizedUser")
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
            $('#userPanelBody').append(user);
        })
}
