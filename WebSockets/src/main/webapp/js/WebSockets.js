/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

(function(window, document, JSON){
    var url = 'ws://localhost:8080/WebSockets/endpoint';
    var ws = new WebSocket(url);
    var mensajes = document.getElementById('conversacion');
    var boton = document.getElementById('btnEnviar');
    
    ws.onopen = onOpen;
    ws.onclose = onClose;
    ws.onmessage = onMessage;
    boton.addEventListener('click', enviar);
    
    function onOpen(){
        console.log('Conectado...');
    }
    
    function onClose(){
        console.log('Desconectado...');
    }
    
    function enviar(){
        var msg = {};
        msg.usuario = document.getElementById('usuario');
        var entidad = {};
        entidad.nombre = document.getElementById('nombre');
        entidad.apellido = document.getElementById('apellido');
        entidad.edad = document.getElementById('edad');
        msg.entidad = entidad;
        
        ws.send(JSON.stringify(msg));
    }
    
    function onMessage(evt){
        var obj = JSON.parse(evt.data);
        msg = obj.usuario + ' dice: ' + obj.mensaje;
        mensajes.innerHTML += '<br/>' + msg;
    }
})(window, document, JSON);


