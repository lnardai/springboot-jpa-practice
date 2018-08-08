
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

    function createQuestionForm(exercise) {
        var questionText = exercise.question;
        var $questionBox = $("<form>", {class: "row flex-question-item", id: exercise.id});
        var header = $("<div>" , {style: "width : 100%;"});
        var hintBox = $("<div>", {style: "width : 100%;"});
        var imgBox = $("<div>", {style: "width : 100%;"});
        var footer = $("<div>");

        var question = $("<label>", {class: "white-text"});
        question.text(questionText);

        var hint = $("<label>", {class: "hint-box-text"});

        hint.html(urlify(exercise.hint));

        var submitButton = $("<button>", {class: "btn btn-primary"});
        var img = $("<img>", {class: "question-img-box", src: exercise.imageUrl});


        submitButton.text("Kuldes");
        $questionBox.submit(function (event) {
            console.log("clicked", event);
            submitAnswer(event, exercise.id)
            event.preventDefault(); // avoid to execute the actual submit of the form.
        });

        var inputField = $("<input>", {type: "text", name: "answer"});
        var errorSpan = $("<span>", {class: "error-info-box", id: "errorResult"+exercise.id});


        if(exercise.answered){
            var exactAnswer = $("<label>", {class: "white-text"});
            exactAnswer.text(exercise.providedAnswer);
            var answered = $("<i>", { class: "fa fa-check answered-check" });
            footer.append(exactAnswer);
            footer.append(answered);
        } else{
            footer.append(inputField).append(submitButton);
        }

        header.append(question);
        imgBox.append(img)
        hintBox.append(hint)

        $questionBox.append(header)
            .append(hintBox)
            .append(imgBox)
            .append(footer)
            .append(errorSpan);

        return $questionBox;
    }

    function submitAnswer(e, id) {

        var url = "/mind/answer/"+id; // the script where you handle the form input.
        $.ajax({
            type: "POST",
            url: url,
            data: $("#"+id).serialize(), // serializes the form's elements.
            success: function (data) {
                $("#errorResult").html("");
            },
            error: function (data) {
                console.log(data);
                $("#errorResult" + id).html("Oops, valami nem jo! Uzenet:" + data.responseText);
            }
        });

    }
});
