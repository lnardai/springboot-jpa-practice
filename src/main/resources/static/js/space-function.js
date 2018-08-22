
$( document ).ready(function() {

    var url = "/space/questions"; // the script where you handle the form input.
    $.ajax({
        type: "GET",
        url: url,
        data: $("#mindq1").serialize(), // serializes the form's elements.
        success: function (data) {
            if (data) {
                console.log("questions arrived", data);
                data.forEach(function (exercise) {
                        $("#question-list").append(createQuestionForm(exercise))
                    }
                );
            }
            else {
                console.log("Error");
            }
        },
        error: function (data) {
            console.log(data);
            $("#errorResult").html("Oops, valami nem jo! Uzenet:" + data.responseText);
        }
    });

});
