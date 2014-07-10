<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Módulo informativo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="css/jquery-ui.css" rel="stylesheet" media="screen">
        <link href="css/jquery-ui.theme.css" rel="stylesheet" media="screen">
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/bootbox.js"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>
        <script type="text/javascript" src="js/Consult.js"></script>
        <script type="text/javascript" src="js/clave.js"></script>
        <style>
            label, input { display:block; }
            input.text { margin-bottom:12px; width:95%; padding: .4em; }
            fieldset { padding:0; border:0; margin-top:25px; }
            h1 { font-size: 1.2em; margin: .6em 0; }
            div#users-contain { width: 350px; margin: 20px 0;}
            div#users-contain table { margin: 1em 0; border-collapse: collapse; width: 100%; }
            div#users-contain table td, div#users-contain table th { border: 1px solid #eee; padding: .6em 10px; text-align: left; }
            .ui-dialog .ui-state-error { padding: .3em; }
            .validateTips { border: 1px solid transparent; padding: 0.3em; }
        </style>
        <style type="text/css">
         

            a { 
                text-decoration:none; 
                color:#00c6ff;
            }

            h1 {
                font: 4em normal Arial, Helvetica, sans-serif;
                padding: 20px;	margin: 0;
                text-align:center;
            }

            h1 small{
                font: 0.2em normal  Arial, Helvetica, sans-serif;
                text-transform:uppercase; letter-spacing: 0.2em; line-height: 5em;
                display: block;
            }

            h2 {
                font-weight:700;
                color:#bbb;
                font-size:20px;
            }

            h2, p {
                margin-bottom:10px;
            }

            @font-face {
                font-family: 'BebasNeueRegular';
                src: url('fonts/BebasNeue-webfont.eot');
                src: url('fonts/BebasNeue-webfont.eot?#iefix') format('embedded-opentype'),
                    url('fonts/BebasNeue-webfont.woff') format('woff'),
                    url('fonts/BebasNeue-webfont.ttf') format('truetype'),
                    url('fonts/BebasNeue-webfont.svg#BebasNeueRegular') format('svg');
                font-weight: normal;
                font-style: normal;

            }

           

            .clock {width:200px; border-style:outset ; border-color:#2d6ca2;   border-radius: 12px;  color: #000; }

            #Date { font-family:'BebasNeueRegular', Arial, Helvetica, sans-serif; font-size:15px; text-align:left; text-shadow:0 0 5px #00c6ff; }

            #reloj { width:200px; text-align: left; padding:0px; list-style:none;  }
            #reloj li { width:100px;display:inline; font-size:15px; text-align:center; font-family:'BebasNeueRegular', Arial, Helvetica, sans-serif; text-shadow:0 0 50px #00c6ff; }

            #point { position:relative; -moz-animation:mymove 1s ease infinite; -webkit-animation:mymove 1s ease infinite; padding-left:10px; padding-right:10px; }

            @-webkit-keyframes mymove 
            {
                0% {opacity:1.0; text-shadow:0 0 20px #00c6ff;}
                50% {opacity:0; text-shadow:none; }
                100% {opacity:1.0; text-shadow:0 0 20px #00c6ff; }	
            }


            @-moz-keyframes mymove 
            {
                0% {opacity:1.0; text-shadow:0 0 20px #00c6ff;}
                50% {opacity:0; text-shadow:none; }
                100% {opacity:1.0; text-shadow:0 0 20px #00c6ff; }	
            }

        </style>
        <script type="text/javascript">
            $(document).ready(function() {
// Creamos 2 variables con los nombres de los meses.
                var monthNames = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"];
                var dayNames = ["Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"]

// Cramos un dato newDate()
                var newDate = new Date();
// Extraemos la hora del objecto
                newDate.setDate(newDate.getDate());
// Sacamos dia, mes y año
                $('#Date').html(dayNames[newDate.getDay()] + " " + newDate.getDate() + ' ' + monthNames[newDate.getMonth()] + ' ' + newDate.getFullYear());

                setInterval(function() {
                    // Creamos los newDate() y extraemos los segundos
                    var seconds = new Date().getSeconds();

                    $("#sec").html((seconds < 10 ? "0" : "") + seconds);
                }, 1000);

                setInterval(function() {
                    // Creamos un newDate() y extraemos los minutos
                    var minutes = new Date().getMinutes();

                    $("#min").html((minutes < 10 ? "0" : "") + minutes);
                }, 1000);

                setInterval(function() {
                    //Creamos un newDate() y extraemos la hora
                    var hours = new Date().getHours();
                    // Add a leading zero to the hours value
                    $("#hours").html((hours < 10 ? "0" : "") + hours);
                }, 1000);

            });
        </script>
    </head>
    <body>       
        <div class="container-fluid">
            <div class="row">
                <div class="clock col-lg-2 col-md-2 col-sm-2 "  >
                    <div id="Date" style="margin-left: 40px;" ></div>

                    <ul id="reloj" style="margin-left: 40px;" >
                        <li id="hours"> </li>
                        <li id="point">:</li>
                        <li id="min"> </li>
                        <li id="point">:</li>
                        <li id="sec"> </li>
                    </ul>
                  
                </div>
                   <div class="col-lg-1 col-md-1 col-sm-1 " >
                    <div class="col-lg-2 col-md-2 col-sm-2"><img class="logo" width="150px" src="images/sp.gif " alt="100px" ></div>
                </div>
                <div class="col-lg-7 col-md-7 col-sm-7 " >
                    <h1>Módulo informativo</h1>
                </div>
                <div class="col-lg-2 col-md-2 col-sm-2 " >
                    <div class="col-lg-2 col-md-2 col-sm-2"><img class="logo" width="150px" src="images/gnklogo.png " alt="100px" ></div>
                </div>
            </div>
            <br/>
            <div class="row" style="padding-top: 50px" >
                <div class="col-lg-5" >
                    <div class="panel panel-primary">
                        <div class="panel-heading"><strong><h5 style="text-align: center; font-weight: bold" >Ingrese folio SP</h5></strong></div>
                        <div class="panel-body">
                            <h4>Folio de afiliado:</h4>
                            <input type="text" id="fol_sp" name="fol_sp" maxlength="10" class="form-control">
                            <br/>
                            <h4>Nombre del afiliado:</h4>
                            <select id="nom_pac" name="nom_pac" class="form-control" ></select>
                        </div>
                        <br/>
                        <table class="table" >
                            <thead>
                            <th>Fecha de inicio de vigencia</th>
                            <th>Fecha fin de vigencia</th>
                            <th>Fecha de nacimiento</th>
                            <th>Edad</th>
                            </thead>    
                            <tbody>
                            <td style="text-align: center" id="1"></td>
                            <td style="text-align: center" id="2"></td>
                            <td style="text-align: center" id="3"></td>
                            <td style="text-align: center" id="4"></td>
                            </tbody>
                        </table>
                    </div>
                </div>    

                <div class="col-lg-7" >
                    <div class="panel panel-success"  >
                        <div class="panel panel-heading"><strong><h5 style="text-align: center; font-weight: bold" >Ingrese clave o descripción a contultar</h5></strong></div>
                        <div class="panel-body">
                            <h4>Clave:</h4>
                            <input type="text" style="width: 300px" id="clave" name="clave" class="form-control">
                            <br/>
                            <h4>Por descripción:</h4>
                            <input type="text"  id="descrip" name="descrip" class="form-control">
                        </div>
                        
                        <table class="table" >
                            <thead>
                            <th style="text-align: center; font-weight: bold" >Clave</th>
                            <th style="text-align: center; font-weight: bold " >Descripción</th>
                            <th style="text-align: center; font-weight: bold " >Existencias</th>
                            </thead>    
                            <tbody>
                            <td style="text-align: center; " id="m_1"></td>
                            <td style="text-align: center;" id="m_2"></td>
                            <td style="text-align: center;" id="m_3"></td>

                            </tbody>
                        </table>
                    </div>  
                </div>

            </div>   
        </div>
        <div id="dialog-form"  title="Datos del nuevo paciente"  >
            <p class="validateTips" style="text-align: center;" >Todos los campos son obligatorios</p>

            <form id="new" >
                <fieldset>
                    <label for="No. Afiliación">No. Afiliación</label>
                    <input type="text" name="folio" id="folio" placeholder="Ingrese no. de afiliación" class="text ui-widget-content ui-corner-all">
                    <label for="Nombre(s)">Nombre(s)</label>
                    <input type="text" name="text" onkeyup="javascript:this.value=this.value.toUpperCase();" id="nombre" placeholder="Ingrese nombre del beneficiario"  class="text ui-widget-content ui-corner-all">
                    <label for="Apellido paterno">Apellido paterno</label>
                    <input type="text" name="a_p" id="a_p" onkeyup="javascript:this.value=this.value.toUpperCase();" placeholder="Ingrese apellido paterno " class="text ui-widget-content ui-corner-all">
                    <label for="Apellido materno">Apellido materno</label>
                    <input type="text" name="a_m" onkeyup="javascript:this.value=this.value.toUpperCase();" id="a_m" placeholder="Ingrese apellido materno " class="text ui-widget-content ui-corner-all">
                    <label for="Fecha de nacimiento">Fecha de nacimiento</label>
                    <input type="text" name="f_naci" id="f_naci" placeholder="Fecha de nacimiento" class="text ui-widget-content ui-corner-all">
                    <label for="Edad">Edad</label>
                    <input type="text" name="edad" id="edad" placeholder="Edad" readonly="true" onclick="calcular_edad(this)" class="text ui-widget-content ui-corner-all">
                    <label for="Sexo">Sexo</label>
                    <select class="text ui-widget-content ui-corner-all" name="sexo" id="sexo" >
                        <option value="F" >Femenino</option>
                        <option value="M" >Masculino</option>
                    </select>
                    <label for="programa">Programa</label>
                    <select class="text ui-widget-content ui-corner-all" name="programa" id="programa" >
                        <option value="SP" >SEGURO POPULAR</option>
                        <option value="PA" >POBLACIÓN ABIERTA</option>
                        <option value="OP" >OPORTUNIDADES</option>

                    </select>
                    <label for="Fecha de nacimiento">Fecha de inicio</label>
                    <input type="text" name="f_ini" id="f_ini" placeholder="Fecha de inicio" readonly="true" class="text ui-widget-content ui-corner-all">
                    <label for="Fecha de nacimiento">Fecha de fin</label>
                    <input type="text" name="f_fin" id="f_fin" placeholder="Fecha de nacimiento" readonly="true" class="text ui-widget-content ui-corner-all">
                    <!-- Allow form submission with keyboard without duplicating the dialog button -->
                    <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
                </fieldset>
            </form>
        </div>
        <div id="dialog-form_1"  title="Datos de la nueva vigencia"  >
            <p class="validateTips" style="text-align: center" >Todos los campos son obligatorios</p>

            <form id="reno" >
                <fieldset>
                    <label for="No. Afiliación">No. Afiliación</label>
                    <input type="text" name="folio_n" id="folio_n" placeholder="Ingrese no. de afiliación" readonly="true" class="text ui-widget-content ui-corner-all">
                    <label for="Edad">Edad</label>
                    <input type="text" name="edad_n" id="edad_n" placeholder="Edad" readonly="true" onclick="calcular_edad(this)" class="text ui-widget-content ui-corner-all">
                    <label for="Fecha de nacimiento">Fecha de inicio</label>
                    <input type="text" name="f_ini_n" id="f_ini_n" placeholder="Fecha de inicio" readonly="true" class="text ui-widget-content ui-corner-all">
                    <label for="Fecha de nacimiento">Fecha de fin</label>
                    <input type="text" name="f_fin_n" id="f_fin_n" placeholder="Fecha de nacimiento" readonly="true" class="text ui-widget-content ui-corner-all">
                </fieldset>
            </form>
        </div>

    </body>
</html>
