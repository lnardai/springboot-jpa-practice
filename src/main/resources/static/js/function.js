
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
