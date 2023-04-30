$(async function() {

    deleteUser();
});
function deleteUser(){
    const deleteForm = document.forms["formDeleteUser"];
    deleteForm.addEventListener("submit", ev => {
        ev.preventDefault();
        fetch("http://localhost:8080/api/admin/users/" + deleteForm.id.value, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            }
        })
            .then(() => {
                $('#deleteFormCloseButton').click();
                allUsers();
            })
    })
}
async function getUser(id) {
    let url = "http://localhost:8080/api/user/" + id;
    let response = await fetch(url);
    return await response.json();
}
$('#delete').on('show.bs.modal', ev => {
    let button = $(ev.relatedTarget);
    let id = button.data('id');
    showDeleteModal(id);
})

async function showDeleteModal(id) {
    $('#rolesDeleteUser').empty();
    let user = await getUser(id);
    let form = document.forms["formDeleteUser"];
    form.id.value = user.id;
    form.name.value = user.name;
    form.surname.value = user.surname;
    form.age.value = user.age;
    form.email.value = user.email;
    form.password.value = user.password;

    await fetch("http://localhost:8080/api/admin/roles")
        .then(res => res.json())
        .then(roles => {
            roles.forEach(role => {
                let el = document.createElement("option");
                el.text = role.role;
                el.value = role.id;
                $('#rolesDeleteUser')[0].appendChild(el);
            })
        })


    // await fetch("http://localhost:8080/api/admin/roles")
    //     .then(res => res.json())
    //     .then(roles => {
    //         roles.forEach(role => {
    //             let el = document.createElement("option");
    //             el.text = role.role;
    //             el.value = role.id;
    //             $('#newUserRoles')[0].appendChild(el);
    //         })
    //     })
}
