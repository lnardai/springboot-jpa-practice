
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
    // or alternatively
    // return text.replace(urlRegex, '<a href="$1">$1</a>')
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

$( document ).ready(function() {
   if(window.location.href.indexOf("index") > -1) {
       var url = "/settings/play-intro"; // the script where you handle the form input.
       $.ajax({
           type: "GET",
           url: url,
           data: $("#mindq1").serialize(), // serializes the form's elements.
           success: function (data) {
               if (data) {
                   console.log("settings arrived", data);
               }
               else{
                   window.location = "/intro"
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
