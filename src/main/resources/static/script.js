const uri = '/rest/races/';
$(document).ready(function () {
    fillTable();
    $('#btnSave').on('click', function () {
        save();
    });
});

function fillTable() {
    $.ajax({
        url: uri,
        type: 'GET',
        dataType: 'json'
    }).done(function (data) {
        let trHTML = '';
        $.each(data, function (key, race) {
            let edit = "<button onclick='edit(" + race.id + ")' value='Edit'>Edit</button>";
            let remove = "<button onclick='remove(" + race.id + ")' value='Delete'>Delete</button>";
            trHTML +=
                '<tr><td>' +
                race.name +
                '</td><td>' +
                race.capacity +
                '</td><td>' +
                race.countParticipants +
                '</td><td>' +
                edit + " | " + remove +
                '</td>';
            trHTML += '</tr>';
        });
        $("#tBody").html(trHTML);
    });
}

function edit(id) {
    $.ajax({
        url: uri + id,
        type: "GET",
        dataType: 'json',
    }).done(function (race) {
        $("#id").val(race.id);
        $("#name").val(race.name);
        $("#capacity").val(race.capacity);
        $("#participants").val(race.countParticipants);
    });
}

function remove(id) {
    $.ajax({
        url: uri + id,
        type: "DELETE",
    }).done(function () {
        alert("Deleted with success");
        fillTable();
    })
}

function save() {
    let raceId = $("#id").val();
    $.ajax({
        url: uri + raceId,
        type: "GET",
        contentType: "application/json",
    }).done(function () {
        $.ajax({
            url: uri + raceId,
            type: "PUT",
            data: JSON.stringify({
                id: raceId,
                name: $("#name").val(),
                capacity: $("#capacity").val(),
                countParticipants: $("#participants").val()
            }),
            contentType: "application/json",
        }).done(function () {
            alert("Updated");
            fillTable();
        });
    }).fail(function () {
        $.ajax({
            url: uri,
            type: "POST",
            data: JSON.stringify({
                id: raceId,
                name: $("#name").val(),
                capacity: $("#capacity").val(),
                countParticipants: $("#participants").val()
            }),
            contentType: "application/json",
        }).done(function () {
            alert("Saved");
            fillTable();
        });
    });

    // $.ajax({
    //     url: uri + raceId,
    //     type: "PUT",
    //     data: JSON.stringify({
    //         id: raceId,
    //         name: $("#name").val(),
    //         capacity: $("#capacity").val(),
    //         countParticipants: $("#participants").val()
    //     }),
    //     contentType: "application/json",
    // }).done(function () {
    //     alert("Success");
    //     fillTable();
    // });
    // $.ajax({
    //     url: uri,
    //     type: "POST",
    //     data: JSON.stringify({
    //         id: raceId,
    //         name: $("#name").val(),
    //         capacity: $("#capacity").val(),
    //         countParticipants: $("#participants").val()
    //     }),
    //     contentType: "application/json",
    // }).done(function () {
    //     alert("Success");
    //     fillTable();
    // });
}


