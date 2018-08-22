
function getTimeRemaining(endtime) {
    var t = Date.parse(endtime) - Date.parse(new Date());
    var seconds = Math.floor((t / 1000) % 60);
    var minutes = Math.floor((t / 1000 / 60) % 60);
    var hours = Math.floor((t / (1000 * 60 * 60)) % 24);
    var days = Math.floor(t / (1000 * 60 * 60 * 24));
    return {
        'total': t,
        'days': days,
        'hours': hours,
        'minutes': minutes,
        'seconds': seconds
    };
}

function urlify(text) {
    var urlRegex = /(https?:\/\/[^\s]+)/g;
    return text.replace(urlRegex, function(url) {
        return '<a target="_blank" href="' + url + '">' + url + '</a>';
    })
}

function initializeClock(id, endtime) {
    var clock = document.getElementById(id);
    var daysSpan = clock.querySelector('.days');
    var hoursSpan = clock.querySelector('.hours');
    var minutesSpan = clock.querySelector('.minutes');
    var secondsSpan = clock.querySelector('.seconds');

    function updateClock() {
        var t = getTimeRemaining(endtime);

        daysSpan.innerHTML = t.days;
        hoursSpan.innerHTML = ('0' + t.hours).slice(-2);
        minutesSpan.innerHTML = ('0' + t.minutes).slice(-2);
        secondsSpan.innerHTML = ('0' + t.seconds).slice(-2);

        if (t.total <= 0) {
            clearInterval(timeinterval);
        }
    }

    updateClock();
    var timeinterval = setInterval(updateClock, 1000);
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

function createQuestionForm(exercise) {
    var $questionBox = $("<form>", {class: "row flex-question-item", id: exercise.id});
    $questionBox.submit(function (event) {
        console.log("clicked", event);
        submitAnswer(exercise.type.toLowerCase(), event, exercise.id)
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

function submitAnswer(type, e, id) {

    var url = "/"+ type +"/answer/"+id; // the script where you handle the form input.
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

$( document ).ready(function() {
   if(window.location.href.indexOf("index") > -1) {
       var url = "/settings/play-intro"; // the script where you handle the form input.
       $.ajax({
           type: "GET",
           url: url,
           data: $("#mindq1").serialize(), // serializes the form's elements.
           success: function (data) {
               if (data) {
                   window.location = "/intro"
               }
               else{
                   console.log("settings arrived", data);
               }
           },
           error: function (data) {
               console.log(data);
               $("#errorResult").html("Oops, valami nem jo! Uzenet:" + data.responseText);
           }
       });
   }


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


    $("#skip-intro").click(function(e) {
        var url = "/settings/assign/play-intro/false"; // the script where you handle the form input.
        $.ajax({
            type: "POST",
            url: url,
            success: function(data)
            {
                console.log('successful skipping intro');
                window.location.href = "/index"
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
