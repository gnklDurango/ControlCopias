$(function() {
    $("#dialog-form").hide();
    $("#dialog-form_1").hide();
    $("#fol_sp").keyup(function() {
        var folio = $("#fol_sp").val();
        if (folio.length === 10) {

            $.ajax({
                url: "Consulta",
                data: {folio: folio, ban: 1},
                type: 'POST',
                dataType: 'Json',
                success: function(responseJson) {
                    var $select = $("#nom_pac");
                    $select.find('option').remove();
                    var sta = JSON.stringify(responseJson);
                    if (sta === "{}") {
                        bootbox.dialog({
                            message: "<h4 style='text-align: center'> ¿Desea dar de alta al paciente?</h4>",
                            title: "<h3 style='text-align: center'> Folio no encontrado </h3>",
                            buttons: {
                                success: {
                                    label: "Si",
                                    className: "btn-success",
                                    callback: function() {
                                        dialog = $("#dialog-form").dialog({
                                            autoOpen: false,
                                            height: 600,
                                            width: 450,
                                            modal: true,
                                            buttons: {
                                                "Guardar": addUser,
                                                Cancel: function() {
                                                    window.location.reload(this);  
                                                    
                                                }
                                            },
                                            close: function() {
                                                form[ 0 ].reset();
                                                allFields.removeClass("ui-state-error");
                                            }
                                        });
                                        form = $("#new").on("submit", function(event) {
                                            event.preventDefault();
                                            addUser();
                                        });
                                        dialog.dialog("open");
                                        var fecha_inicio;
                                        var fol_reno = $("#fol_sp").val();
                                        $("#folio").val(fol_reno);
                                        $("#fol_sp").val("");

                                        $("#f_naci").datepicker({
                                            changeMonth: true,
                                            changeYear: true,
                                            onSelect: function(textoFecha, objDatepicker) {

                                                var fecha_hoy = new Date();
                                                var ahora_anio = fecha_hoy.getYear();
                                                var fecha_naci = textoFecha.split("/");
                                                var anio_nacim = fecha_naci[0];
                                                if (anio_nacim <= ahora_anio) {

                                                    $("#edad").val("0");
                                                } else {
                                                    var date = calcular_edad(textoFecha);
                                                    $("#edad").val(date);
                                                }
                                            }
                                        });
                                        $("#f_ini").datepicker({
                                            changeMonth: true,
                                            changeYear: true,
                                            onSelect: function(textoFecha, objDatepicker) {
                                                var hoy_ini = new Date();
                                                fecha_inicio = new Date(textoFecha);
                                                if (fecha_inicio.valueOf() > hoy_ini.valueOf()) {
                                                    alert("La fecha de inicio no puede ser superior a la fecha actual");
                                                    $("#f_ini").val("");
                                                    return false;


                                                }
                                            }
                                        });
                                        $("#f_fin").datepicker({
                                            changeMonth: true,
                                            changeYear: true,
                                            onSelect: function(textoFecha, objDatepicker) {
                                                var f_i = new Date($("#f_inicio").val());
                                                var f_f = new Date(textoFecha);
                                                var hoy = new Date();
                                                var f_i_1 = f_i.valueOf();
                                                var f_f_1 = f_f.valueOf();
                                                if (fecha_inicio.valueOf() >= f_f_1) {
                                                    alert("La fecha de inicio no puede ser mayor que la fecha fin");
                                                    $("#f_fin").val("");
                                                    return false;

                                                } else if (hoy.valueOf() >= f_f_1) {

                                                    alert("La fecha fin no puede ser igual o menor a la fecha actual");
                                                    $("#f_fin").val("");
                                                    return false;
                                                }



                                            }
                                        });
                                        function addUser() {
                                            var valid = validar();
                                            if (valid) {

                                                var fol = $("#folio").val();
                                                var nom = $("#nombre").val();
                                                var a_p = $("#a_p").val();
                                                var a_m = $("#a_m").val();
                                                var f_n = $("#f_naci").val();
                                                var edad = $("#edad").val();
                                                var progr = $("#programa").val();
                                                var f_in = $("#f_ini").val();
                                                var f_fin = $("#f_fin").val();
                                                var sexo = $("#sexo").val();

                                                $.ajax({
                                                    url: "Consulta",
                                                    data: {folio: fol, nombre: nom, a_p: a_p, a_m: a_m, f_n: f_n, edad: edad, progr: progr, f_in: f_in, f_fin: f_fin, ban: 2, sexo: sexo},
                                                    type: 'POST',
                                                    success: function(responseJson) {
                                                        alert("Folio agregado correctamente");
                                                        dialog.dialog("close");
                                                    }, error: function(jqXHR, status, error) {

                                                        alert("Ocurrio un problema con su petición");
                                                    }
                                                });
                                                return valid;
                                            }
                                        }


                                    }
                                },
                                danger: {
                                    label: "No",
                                    className: "btn-danger"

                                }
                            }
                        });

                    } else {
                        $("#nom_pac").fadeOut(400).fadeIn(400).fadeOut(400).fadeIn(400);
                        $('<option>').val("").text("---Seleccionar---").appendTo($select);
                        $.each(responseJson, function(key, value) {

                            $('<option>').val(key).text(value).appendTo($select);
                        });
                        $('<option>').val("add").text("Agregar afiliado a este folio?").appendTo($select);
                    }
                },
                error: function(jqXHR, status, error) {

                    alert("Ocurrio un problema con su petición");
                }


            });
        }


    });
    $("#nom_pac").change(function() {
        var nom = $("#nom_pac").val();
        if (nom === "add") {

            var fecha_inicio;
            var fol_reno = $("#fol_sp").val();
            $("#folio").val(fol_reno);
            $("#fol_sp").val("");
            $("#f_naci").datepicker({
                changeMonth: true,
                changeYear: true,
                onSelect: function(textoFecha, objDatepicker) {

                    var fecha_hoy = new Date();
                    var ahora_anio = fecha_hoy.getYear();
                    var fecha_naci = textoFecha.split("/");
                    var anio_nacim = fecha_naci[0];
                    if (anio_nacim <= ahora_anio) {

                        $("#edad").val("0");
                    } else {
                        var date = calcular_edad(textoFecha);
                        $("#edad").val(date);
                    }
                }
            });
            $("#f_ini").datepicker({
                changeMonth: true,
                changeYear: true,
                onSelect: function(textoFecha, objDatepicker) {
                    var hoy_ini = new Date();
                    fecha_inicio = new Date(textoFecha);
                    if (fecha_inicio.valueOf() > hoy_ini.valueOf()) {
                        alert("La fecha de inicio no puede ser superior a la fecha actual");
                        $("#f_ini").val("");
                        return false;


                    }
                }
            });
            $("#f_fin").datepicker({
                changeMonth: true,
                changeYear: true,
                onSelect: function(textoFecha, objDatepicker) {
                    var f_i = new Date($("#f_inicio").val());
                    var f_f = new Date(textoFecha);
                    var hoy = new Date();
                    var f_i_1 = f_i.valueOf();
                    var f_f_1 = f_f.valueOf();
                    if (fecha_inicio.valueOf() >= f_f_1) {
                        alert("La fecha de inicio no puede ser mayor que la fecha fin");
                        $("#f_fin").val("");
                        return false;

                    } else if (hoy.valueOf() >= f_f_1) {

                        alert("La fecha fin no puede ser igual o menor a la fecha actual");
                        $("#f_fin").val("");
                        return false;
                    }



                }
            });
            function addUser() {
                var valid = validar();
                if (valid) {

                    var fol = $("#folio").val();
                    var nom = $("#nombre").val();
                    var a_p = $("#a_p").val();
                    var a_m = $("#a_m").val();
                    var f_n = $("#f_naci").val();
                    var edad = $("#edad").val();
                    var progr = $("#programa").val();
                    var f_in = $("#f_ini").val();
                    var f_fin = $("#f_fin").val();
                    var sexo = $("#sexo").val();

                    $.ajax({
                        url: "Consulta",
                        data: {folio: fol, nombre: nom, a_p: a_p, a_m: a_m, f_n: f_n, edad: edad, progr: progr, f_in: f_in, f_fin: f_fin, ban: 2, sexo: sexo},
                        type: 'POST',
                        success: function(responseJson) {
                            alert("Folio agregado correctamente");
                            dialog.dialog("close");
                        }, error: function(jqXHR, status, error) {

                            alert("Ocurrio un problema con su petición");
                        }
                    });
                    return valid;
                }
            }

            dialog = $("#dialog-form").dialog({
                autoOpen: false,
                height: 600,
                width: 450,
                modal: true,
                buttons: {
                    "Guardar": addUser,
                    Cancel: function() {
                        window.location.reload(this);
                    }
                },
                close: function() {
                    form[ 0 ].reset();
                    allFields.removeClass("ui-state-error");
                }
            });
            form = $("#reno").on("submit", function(event) {
                event.preventDefault();
                addUser();
            });
            dialog.dialog("open");
        }


        else {

            var fol = $("#fol_sp").val();

            $.ajax({
                url: "Consulta",
                data: {folio: fol, nombre: nom, ban: 3},
                type: 'POST',
                dataType: 'Json',
                success: function(Json) {
                    var hoy = new Date();
                    var fin = new Date(Json.f_f);
                    var hoy_y = hoy.valueOf();
                    var fin_y = fin.valueOf();
                    if (fin_y < hoy_y) {

                        bootbox.dialog({
                            message: "<h4 style='text-align: center'> ¿Desea renovar la vigencia del paciente?</h4>",
                            title: "<h3 style='text-align: center'> Vigencia vencida </h3>",
                            buttons: {
                                success: {
                                    label: "Si",
                                    className: "btn-success",
                                    callback: function() {
                                        $("#folio_n").val($("#fol_sp").val());
                                        var fecha_inicio;
                                        var fecha_hoy = new Date();
                                        var ahora_anio = fecha_hoy.getYear();
                                        var fecha_naci = Json.f_n.split("-");
                                        var anio_nacim = fecha_naci[0];
                                        if (anio_nacim <= ahora_anio) {

                                            $("#edad_n").val("0");
                                        } else {
                                            var date = calcular_edad_n(Json.f_n);
                                            $("#edad_n").val(date);
                                        }



                                        $("#f_ini_n").datepicker({
                                            changeMonth: true,
                                            changeYear: true,
                                            onSelect: function(textoFecha, objDatepicker) {
                                                var hoy_ini = new Date();
                                                fecha_inicio = new Date(textoFecha);
                                                if (fecha_inicio.valueOf() > hoy_ini.valueOf()) {
                                                    alert("La fecha de inicio no puede ser superior a la fecha actual");
                                                    $("#f_ini_n").val("");
                                                    return false;


                                                }
                                            }
                                        });
                                        $("#f_fin_n").datepicker({
                                            changeMonth: true,
                                            changeYeaonSelect: function(textoFecha, objDatepicker) {
                                                var f_i = new Date($("#f_inicio").val());
                                                var f_f = new Date(textoFecha);
                                                var hoy = new Date();
                                                var f_i_1 = f_i.valueOf();
                                                var f_f_1 = f_f.valueOf();
                                                if (fecha_inicio.valueOf() >= f_f_1) {
                                                    alert("La fecha de inicio no puede ser mayor que la fecha fin");
                                                    $("#f_fin_n").val("");
                                                    return false;

                                                } else if (hoy.valueOf() >= f_f_1) {

                                                    alert("La fecha fin no puede ser igual o menor a la fecha actual");
                                                    $("#f_fin_n").val("");
                                                    return false;
                                                }



                                            }
                                        });
                                        function addUser() {
                                            var valid = validar_r();
                                            if (valid) {

                                                var fol = $("#folio_n").val();
                                                var edad = $("#edad_n").val();
                                                var f_in = $("#f_ini_n").val();
                                                var f_fin = $("#f_fin_n").val();
                                                var nombre = $("#nom_pac").val();

                                                $.ajax({
                                                    url: "Consulta",
                                                    data: {folio: fol, edad: edad, nombre: nombre, f_in: f_in, f_fin: f_fin, ban: 4},
                                                    type: 'POST',
                                                    success: function(responseJson) {
                                                        alert("Se actualizó correctamente la vigencia");
                                                        dialog.dialog("close");
                                                    }, error: function(jqXHR, status, error) {

                                                        alert("Ocurrio un problema con su petición");
                                                    }
                                                });
                                                return valid;
                                            }
                                        }

                                        dialog = $("#dialog-form_1").dialog({
                                            autoOpen: false,
                                            height: 500,
                                            width: 450,
                                            modal: true,
                                            buttons: {
                                                "Guardar": addUser,
                                                Cancel: function() {
                                                    
                                                    window.location.reload(this);
                                                }
                                            },
                                            close: function() {
                                                form[ 0 ].reset();
                                                allFields.removeClass("ui-state-error");
                                            }
                                        });
                                        form = $("#reno").on("submit", function(event) {
                                            event.preventDefault();
                                            addUser();
                                        });
                                        dialog.dialog("open");
                                    }
                                },
                                danger: {
                                    label: "No",
                                    className: "btn-danger",
                                }
                            }
                        });



                    } else {


                        $("#1").val(Json.f_i).text(Json.f_i);
                        $("#2").val(Json.f_f).text(Json.f_f);
                        $("#3").val(Json.f_n).text(Json.f_n);
                        $("#4").val(Json.edad).text(Json.edad);
                    }

                }, error: function(jqXHR, status, error) {

                    alert("Ocurrio un problema con su petición");
                }

            });



        }
    });


});
function calcular_edad(fecha) {
    var fecha_hoy = new Date();
    var ahora_anio = fecha_hoy.getYear();
    var ahora_mes = fecha_hoy.getMonth();
    var ahora_dia = fecha_hoy.getDate();
    var fecha_naci = fecha.split("/");
    var anio_nacim = fecha_naci[0];
    var mes_nacim = fecha_naci[1];
    var dia_nacim = fecha_naci[2];
    var edad = (ahora_anio + 1900) - anio_nacim;
    if (ahora_mes < (mes_nacim - 1)) {
        edad--;
    }
    if (((mes_nacim - 1) === ahora_mes) && (ahora_dia < dia_nacim)) {
        edad--;
    }
    if (edad > 1900) {
        edad -= 1900;
    }
    //document.form.txtf_edad.value=edad;
    return edad;
}
function calcular_edad_n(fecha) {
    var fecha_hoy = new Date();
    var ahora_anio = fecha_hoy.getYear();
    var ahora_mes = fecha_hoy.getMonth();
    var ahora_dia = fecha_hoy.getDate();
    var fecha_naci = fecha.split("-");
    var anio_nacim = fecha_naci[0];
    var mes_nacim = fecha_naci[1];
    var dia_nacim = fecha_naci[2];
    var edad = (ahora_anio + 1900) - anio_nacim;
    if (ahora_mes < (mes_nacim - 1)) {
        edad--;
    }
    if (((mes_nacim - 1) === ahora_mes) && (ahora_dia < dia_nacim)) {
        edad--;
    }
    if (edad > 1900) {
        edad -= 1900;
    }
    //document.form.txtf_edad.value=edad;
    return edad;
}
function validar() {
    var valid = true;
    if ($("#folio").val() === "") {
        bootbox.alert("El campo folio no puede ir vacio");
        valid = false;
    } else if ($("#nombre").val() === "") {
        bootbox.alert("El campo nombre no puede ir vacio");
        valid = false;
    } else if ($("#a_p").val() === "") {
        bootbox.alert("El campo apellido paterno no puede ir vacio");
        valid = false;
    } else if ($("#a_m").val() === "") {
        bootbox.alert("El campo apellido materno no puede ir vacio");
        valid = false;
    } else if ($("#f_naci").val() === "") {
        bootbox.alert("El campo fecha de nacimiento no puede ir vacio");
        valid = false;
    } else if ($("#f_ini").val() === "") {
        bootbox.alert("El campo fecha de inicio no puede ir vacio");
        valid = false;
    } else if ($("#f_fin").val() === "") {
        bootbox.alert("El campo fecha de fin de vigencia no puede ir vacio");
        valid = false;
    }


    return valid;
}
function validar_r() {
    var valid = true;
    if ($("#folio_n").val() === "") {
        bootbox.alert("El campo folio no puede ir vacio");
        valid = false;
    } else if ($("#f_ini_n").val() === "") {
        bootbox.alert("El campo fecha de inicio no puede ir vacio");
        valid = false;
    } else if ($("#f_fin_n").val() === "") {
        bootbox.alert("El campo fecha de fin de vigencia no puede ir vacio");
        valid = false;
    }


    return valid;
}