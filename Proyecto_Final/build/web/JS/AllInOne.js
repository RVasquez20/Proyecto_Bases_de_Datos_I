var entero = function (e){
  var event = e || window.event;
  var key = event.keyCode || event.wchich;
  
  var tecla= String.fromCharCode(key);
  var cadena = /\d/;
  
  if(!tecla.search(cadena)){
      return true;
  } else {
      return false;
  }
};
var text = function (e){
  var event = e || window.event;
  var key = event.keyCode || event.wchich;
  
  var tecla= String.fromCharCode(key);
  var cadena = /[a-zA-Z\s]/;
  
  if(!tecla.search(cadena)){
      return true;
  } else {
      return false;
  }
};

