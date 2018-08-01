
$( document ).ready(function() {

    var url = "/mind/questions"; // the script where you handle the form input.
    $.ajax({
        type: "GET",
        url: url,
        data: $("#mindq1").serialize(), // serializes the form's elements.
        success: function (data) {
            if (data) {
                console.log("questions arrived", data);
                data.forEach(function (exercise) {
                        $("#question-list").append(createQuestion(exercise.question))
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

    function createQuestion(questionText) {
        var $questionBox = $("<form>", {class: "row", id: "mindq1"});
        var question = $("<label>", {class: "white-text"});
        question.text(questionText);

        var submitButton = $("<button>", {class: "btn btn-primary"});

        submitButton.text("Kuldes");
        $questionBox.submit(function (event) {
            console.log("clicked", event);
            submitAnswer(event)
            event.preventDefault(); // avoid to execute the actual submit of the form.
        });

        var inputField = $("<input>", {type: "text", name: "answer"});

        var errorSpan = $("<span>", {class: "error-info-box", id: "errorResult"});

        $questionBox.append(question).append(inputField).append(submitButton).append(errorSpan);

        return $questionBox;

// <button type="submit" class="btn btn-primary">Kuldes</button>
//         <span class="error-info-box" id="errorResult"></span>
    }

    function submitAnswer(e) {

        var url = "/mind/answer/1"; // the script where you handle the form input.
        $.ajax({
            type: "POST",
            url: url,
            data: $("#mindq1").serialize(), // serializes the form's elements.
            success: function (data) {
                $("#errorResult").html("");
            },
            error: function (data) {
                console.log(data);
                $("#errorResult").html("Oops, valami nem jo! Uzenet:" + data.responseText);
            }
        });

    }
});
