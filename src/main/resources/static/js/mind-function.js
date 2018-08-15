
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
        var $questionBox = $("<form>", {class: "row flex-question-item", id: exercise.id});
        $questionBox.submit(function (event) {
            console.log("clicked", event);
            submitAnswer(event, exercise.id)
            event.preventDefault(); // avoid to execute the actual submit of the form.
        });

        var header = $("<div>" , {style: "width : 100%;"});
        var question = $("<label>", {class: "white-text"});
        var icon = generateType(exercise)

        question.text(exercise.question);
        header.append(icon);
        header.append(question);

        var hintBox = $("<div>", {style: "width : 100%;"});
        var hint = $("<label>", {class: "hint-box-text"});
        hint.html(urlify(exercise.hint));
        hintBox.append(hint)

        if(exercise.imageUrl !== ""){
            var imgBox = $("<div>", {style: "width : 100%;"});
            var img = $("<img>", {class: "question-img-box", src: exercise.imageUrl});
            imgBox.append(img)
        }


        var footer = $("<div>", {id: "footer"+exercise.id, class: "question-footer"});

        createFooter(footer, exercise);

        $questionBox.append(header)
            .append(hintBox)
            .append(imgBox)
            .append(footer);

        return $questionBox;
    }

    function generateType(exercice){
        if(exercice.exerciseType === "QUEST"){
            return $("<i>", {class: "fas fa-map-marked-alt question-quest-type"});
        }
        if(exercice.exerciseType === "FIND_QR"){
            return $("<i>", {class: "fas fa-qrcode question-qr-type"});
        }
        return $("<i>", {class: "fas fa-question question-type"});
    }

    function createFooter(footer, exercise) {
        var inputField = $("<input>", {type: "text", name: "answer", class: "question-input"});
        var submitButton = $("<button>", {class: "btn btn-dark question-submit-btn"});
        submitButton.text("Küldés");

        var errorSpan = $("<span>", {class: "error-info-box", id: "errorResult" + exercise.id});

        if (exercise.answered) {
            var exactAnswer = $("<label>", {class: "white-text"});
            exactAnswer.text(exercise.providedAnswer);
            var answered = $("<i>", {class: "fa fa-check answered-check"});
            footer.append(exactAnswer);
            footer.append(answered);
        } else {
            footer.append(inputField).append(submitButton).append(errorSpan);
        }
    }

    function submitAnswer(e, id) {

        var url = "/mind/answer/"+id; // the script where you handle the form input.
        $.ajax({
            type: "POST",
            url: url,
            data: $("#"+id).serialize(), // serializes the form's elements.
            success: function (data) {
                console.log("Success:", data);
                $("#footer"+id).html("");
                createFooter($("#footer"+id), data);
                $("#errorResult").html("");

            },
            error: function (data) {
                console.log(data);
                $("#errorResult" + id).html("Oops, valami nem jo! Uzenet:" + data.responseText);
            }
        });

    }
});
