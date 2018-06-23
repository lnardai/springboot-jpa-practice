
$( document ).ready(function() {

$("#mindq1").submit(function(e) {

    var url = "/mind/answer/1"; // the script where you handle the form input.

    $.ajax({
        type: "POST",
        url: url,
        data: $("#mindq1").serialize(), // serializes the form's elements.
        success: function(data)
        {
            $("#errorResult").html("");
        },
        error: function(data)
        {
            console.log(data);
            $("#errorResult").html("Oops, valami nem jo! Uzenet:" + data.responseText);
        }
    });

    e.preventDefault(); // avoid to execute the actual submit of the form.
});

    console.log( "ready!" );
});
