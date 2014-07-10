$(function() {
    $("#clave").on("keyup", function() {
        var clave = $("#clave").val();
        $.ajax({
            url: "Consulta",
            data: {clave: clave, ban: 5},
            type: 'POST',
            dataType: 'Json',
            success: function(data) {
                var sta = JSON.stringify(data);
               
                if (sta === "{}") {
                    
                    $("#m_1").val("").text("");
                    $("#m_2").val("").text("");
                    $("#m_3").val("").text("");
                   

                } else {
                    $("#m_1").val(data.clave).text(data.clave);
                    $("#m_2").val(data.descrip).text(data.descrip);
                    $("#m_3").val(data.cant).text(data.cant);
                }



            }, error: function(jqXHR, textStatus, errorThrown) {

                alert("Clave invalida");

            }



        });




    });

    $("#clave").focusout(function() {

        $("#m_1").val("").text("");
        $("#m_2").val("").text("");
        $("#m_3").val("").text("");


    });

$("#descrip").autocomplete({
        width: 300,
        max: 10,
        delay: 100,
        minLength: 1,
        autoFocus: true,
        cacheLength: 1,
        scroll: true,
        highlight: false,
        source: function(request, response) {
            $.ajax({
                url: "Consulta",
                dataType: "json",
                data: request,
                type: 'GET',
                success: function( data, textStatus, jqXHR) {
                    console.log( data);
                    var items = data;
                    response(items);
                    
                },
                error: function(jqXHR, textStatus, errorThrown){
                     console.log( textStatus);
                    
                }
            });
        },select:function(a , b ){
            var des = b.item.value ;
            
            $.ajax({
                url:"Consulta",
                data:{ban: 6, descrip: des},
                type: 'POST',
                dataType: 'Json',
                success: function(data) {
                    $("#m_1").val(data.clave).text(data.clave);
                    $("#m_2").val(data.descrip).text(data.descrip);
                    $("#m_3").val(data.cant).text(data.cant);  
                },error: function(jqXHR, textStatus, errorThrown) {
                    alert("error");
                }
                
                
                
                
            });
            
        }
 
    });

   $("#descrip").focusout(function() {

        $("#m_1").val("").text("");
        $("#m_2").val("").text("");
        $("#m_3").val("").text("");


    });

});